package kosta.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//누구에게 전송할 것인가 ,적용할 jsp
@WebFilter(urlPatterns={
		"/session/main.jsp",
		"/session/logout.jsp"
}) //폴더단위
public class EncFilter implements Filter{
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		
		String name = (String)session.getAttribute("name");
		
		if(name==null){
			response.sendRedirect("loginForm.jsp");
		}
		
		chain.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
