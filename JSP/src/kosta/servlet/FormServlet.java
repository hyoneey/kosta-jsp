package kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;


@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public FormServlet() {
        super();
    }


   protected void doPost(HttpServletRequest request, 
         HttpServletResponse response) throws ServletException, IOException {
	   
	   //post 방식으로 했을 때 인코딩 방식 : 한글이 깨지지 않도록 하는것
	   request.setCharacterEncoding("utf-8");
	   
	   
      // 데이터 받기 - request가 처리
      String num1 = request.getParameter("num1");      // 이름 동일하게 설정
      String num2 = request.getParameter("num2");
      
     int result =Integer.parseInt(num1)+Integer.parseInt(num2);
      
    //  int result = 100;
      
      request.setAttribute("result", result);
      
      //페이지 이동하는 함수 : 서블릿이 아니라 jsp에서 출력
      	RequestDispatcher re =
      			request.getRequestDispatcher("/jsp/result.jsp");
      	re.forward(request, response);
   
     // System.out.println("num1 : " + num1);
   }

}