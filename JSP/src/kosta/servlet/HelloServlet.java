package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

//어노테이션 방식
@WebServlet({ "/HelloServlet", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청,응답 을 지니고 있어야 한다.
		//응답은 response 객체가 처리
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//printwriter에 쓰면 reponse 객체에 쓰여짐. : reponse를 클라이언트로본다.
		
		out.println("<html><head><title>HelloServlet</title></head>");
		out.println("<body>");
		out.println("<h1>HelloServlet!!!</h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
		
	}

}
