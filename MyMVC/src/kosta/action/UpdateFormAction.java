package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.model.BoardDao;

public class UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   // 한글 인코딩
		   request.setCharacterEncoding("utf-8");
		   
		   // Board 객체생성 
		   BoardDao dao = BoardDao.getInstance();
		   Board board = new Board();
		   
		   // seq 값 받기
		   String seq = request.getParameter("seq");
		   
		   // 글 내용 가져오기
		   board = dao.detailBoard(seq);
		   
		   // seq 정수형으로 형변환
		   int seq_int = Integer.parseInt(seq);
		   
		   request.setAttribute("board", board);
		   board.setSeq(seq_int);
		   
		   ActionForward forward = new ActionForward();
		   forward.setRedirect(false);
		   forward.setPath("update_form.jsp");
		   
		   return forward;
	}

}
