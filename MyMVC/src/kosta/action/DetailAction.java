package kosta.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.model.Board;
import kosta.model.BoardDao;

public class DetailAction implements Action {

	   @Override
	   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      ActionForward forward = new ActionForward();

	      request.setCharacterEncoding("utf-8");
	      String seq = request.getParameter("seq");
	      BoardDao dao = new BoardDao();
	      Board board = dao.detailBoard(seq);

	      request.setAttribute("board", board);
	   //   System.out.println("디테일액션");

	      forward.setRedirect(false);	// 같은 요청이기 때문에 Dispatcher
	      forward.setPath("detail.jsp");
	      return forward;
	   }

}
