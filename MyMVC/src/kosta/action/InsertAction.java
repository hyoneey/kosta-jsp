package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.model.BoardDao;

public class InsertAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao dao = BoardDao.getInstance();
		
		request.setCharacterEncoding("utf-8");
		
		Board board = new Board();
		board.setContents(request.getParameter("contents"));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));		
		
		dao.insertBoard(board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); //새로운 요청
		forward.setPath("listAction.do");

		//.do로 컨트롤러에게 요청
		
		
		
		return forward;
	}

}
