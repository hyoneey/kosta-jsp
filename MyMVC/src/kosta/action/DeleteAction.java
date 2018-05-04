package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.model.BoardDao;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String seq = request.getParameter("seq");
		BoardDao dao = BoardDao.getInstance();
		Board board =  dao.detailBoard(seq);
		dao.deleteBoard(board);

		request.setAttribute("board", board);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("listAction.do");

		return forward;
	}

}
