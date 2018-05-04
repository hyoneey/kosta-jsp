package kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hundredServlet
 */
@WebServlet("/hundredServlet")
public class hundredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hundredServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int total=0;
		
		for(int i=1; i<=100; i++){
			total +=i;
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Hundred Servlet</title></head>");
		out.println("<body>");
		out.println(total);
		out.println("</body>");
		out.println("</html>");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
