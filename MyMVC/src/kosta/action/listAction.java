package kosta.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.model.Board;
import kosta.model.BoardDao;

public class listAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.listBoard();
		
		request.getSession().setAttribute("list", list);
	
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); //새로운 요청
		forward.setPath("list.jsp");

		return forward;
	}

	

}
