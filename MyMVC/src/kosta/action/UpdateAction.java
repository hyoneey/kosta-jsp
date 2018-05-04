package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.model.BoardDao;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 // 한글 인코딩
		 request.setCharacterEncoding("utf-8");
		 
		 // board 객체 생성
		 BoardDao dao = BoardDao.getInstance();
		 int seq = (Integer.parseInt(request.getParameter("seq")));
		 
		 Board board = new Board();
		 
		 // 수정한 값 넣어주기
		 board.setTitle(request.getParameter("title"));
		 board.setSeq(seq);
		 board.setContents(request.getParameter("contents"));
		 
		 // 결과값을 가져가기
		 request.setAttribute("board", board);
		  
		 // updateBoard 메서드호출 -> 값 변경
		 dao.updateBoard(board);
		 
		 ActionForward forward = new ActionForward();
		 forward.setRedirect(true);		// 새로운 요청이기 때문에 true로 해야함
		 forward.setPath("listAction.do");
		   
	     return forward;
	}

}
