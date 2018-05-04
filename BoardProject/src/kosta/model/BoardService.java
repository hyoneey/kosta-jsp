package kosta.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardService {
	//서비스에서 dao 호출 
	//싱글톤 형식 : private
	private static BoardService service = new BoardService();
	private static BoardDao dao;
	private static final int PAGE_SIZE = 2;
	
	public static BoardService getInstance(){
		dao = BoardDao.getInstance();		
		return service;
	}

	//데이터 삽입 - inesertOk
	public int insertBoardService(HttpServletRequest request)throws Exception{	
		Board board = new Board();
		
		//파일 업로드(경로, 크기, 인코딩방식, 파일이름 중복되었을때 정책)
		String uploadPath = request.getRealPath("upload"); //경로
		int size = 20 * 1024 * 1024; //20MB
		
		MultipartRequest multi
			= new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		board.setB_name(multi.getParameter("b_name"));
		board.setB_title(multi.getParameter("b_title"));
		board.setB_content(multi.getParameter("b_content"));
		board.setB_pwd(multi.getParameter("b_pwd"));
		
		board.setB_id(Integer.parseInt(multi.getParameter("b_id")));
		board.setB_ref(Integer.parseInt(multi.getParameter("b_ref")));
		board.setB_step(Integer.parseInt(multi.getParameter("b_step")));
		board.setB_level(Integer.parseInt(multi.getParameter("b_level")));
		
		//파일 업로드시
		if(multi.getFilesystemName("b_fname") != null){
			String b_fname = multi.getFilesystemName("b_fname");
			board.setB_fname(b_fname);
			
			//썸네일 이미지(jpg, gif) aaa.gif => aaa_small.gif
			String pattern = b_fname.substring(b_fname.indexOf(".")+1); //gif
			String headName = b_fname.substring(0, b_fname.indexOf("."));
			
			System.out.println("pattern: "+pattern);
			System.out.println("headName: "+headName);
			
			//원본 File 객체
			String imagePath = uploadPath + "\\" + b_fname;
			File src = new File(imagePath);
			
			//썸네일 이미지 File 객체
			String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern;
			File dest = new File(thumImagePath);
			
			if(pattern.equals("jpg") || pattern.equals("gif")){
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			
			
		}else{
			board.setB_fname("");
		}
		
		
		//답변글일때
		if(board.getB_id() != 0){
			HashMap<String, Integer> map =
					new HashMap<String, Integer>();
			
			//map.put("변수명",값) :변수명은 xml #{ 변수명}
			map.put("b_step", board.getB_step());
			map.put("b_ref", board.getB_ref());	
			
			dao.updateStep(map);
						
			//뒤로 한칸씩밀려나도록
			board.setB_id(dao.selectB_id()+1);
			board.setB_step(board.getB_step()+1);
			board.setB_level(board.getB_level()+1); //들여쓰기
			
		}else{ //원본글
			board.setB_id(dao.selectB_id()+1); //새로운 b_id , 처음에 b_id를 null을 지님
			board.setB_ref(dao.selectB_id()+1); //원본글 b_ref : 그룹번호
		}
		
		return dao.insertBoard(board);
	}
	
	//리스트- list.jsp 
	public ListModel listBoardService(HttpServletRequest request, int requestPage){
		Search search = new Search();
		HttpSession session = request.getSession();
		
		//새로운 검색 시도 - 검색을 눌러야만 실행
		if(request.getParameter("temp") != null || request.getParameter("pageNum") == null){
			session.removeAttribute("search");
		}
		
		//검색시
		if(request.getParameterValues("area") != null){
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
		}
		else if((Search)session.getAttribute("search") != null){ //검색 후에 페이징을 클릭시
			search = (Search)session.getAttribute("search");
		}
		
		/* 페이징 처리 */
		//페이지당 글 갯수, 총 글 갯수, 현재페이지,시작페이지,마지막페이지 => 페이징 UI
		//startRow, endRow => 데이터 출력
		int totalCount = dao.countBoard(search); //전체 글내용
		int totalPageCount = totalCount/PAGE_SIZE; //페이지번호
		
		if(totalCount%PAGE_SIZE >0){ //페이지 넘겨서 데이터 이동
			totalPageCount++;
		}
		//시작페이지 = 현재페이지 - (현재페이지 -1)%5(보여주고싶은 페이지수)
		int startPage = requestPage - (requestPage-1)%5;
		int endPage = startPage +4;
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		int startRow = (requestPage-1) * PAGE_SIZE;
		List<Board> list = dao.listBoard(search, startRow);
		
		return new ListModel(list, requestPage, totalPageCount, startPage, endPage);
	}
	
	//selectboard 호출 , 파라미터가 b_id와 ture : 조회랑 조회수 업데이트 
	//detail에서는 true , insertform에서는 false를 반환
	//디테일 - detail, selectboard 호출
	public Board selectBoardService(int b_id, boolean check){			
		if(check){		
			dao.hitCount(b_id);
		}
		return dao.selectBoard(b_id);
	}
	
	//수정 - pw일치 
	public int updateBoardService(Board board){		
		return dao.updateBoard(board);
	}
	
	//댓글입력
	public int insertReplyService(Reply reply){
		return dao.replyInsert(reply);
	}
	
	public List<Reply> selectReplyService(int b_id){			
		return dao.selectReply(b_id);
	}
	
}
