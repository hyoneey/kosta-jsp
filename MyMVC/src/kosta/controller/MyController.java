package kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.action.DeleteAction;
import kosta.action.InsertAction;
import kosta.action.InsertFormAction;
import kosta.action.UpdateAction;
import kosta.action.UpdateFormAction;
import kosta.action.listAction;
import kosta.action.DetailAction;

@WebServlet({ "/MyController", "*.do" })
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyController() {
		super();
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// insertForm.do , insertAction.do , list.do , detail.do

		String requestURI = request.getRequestURI(); // 경로:컨텍스트경로/파일
		// System.out.println(requestURI); // /MyMVC/insertForm.do

		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		//System.out.println(command); // insertForm.do

		Action action = null;
		ActionForward forward = null;

		if (command.equals("insertForm.do")) {
			action = new InsertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertAction.do")) {
			action = new InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("listAction.do")) {
			//System.out.println("listAction 호출");
			action = new listAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("DetailAction.do")){
			action = new DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("DeleteAction.do")){
			action = new DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("UpdateAction.do")){
			action = new UpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("UpdateFormAction.do")){
			action = new UpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				// dispatcher해서 url경로가 insertForm.do가 되어 있다. dispatcher는 요청을
				// 보내주는 클래스같은것?
			}
		} 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
