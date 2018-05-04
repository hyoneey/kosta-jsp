package kosta.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/*@WebFilter(urlPatterns={
      //인코딩을 적용하겠다
      "/bean/insert_form.jsp",
      "/bean/insertAction.jsp"
})*/
@WebFilter("/bean/*") //폴더단위

public class EncFilter implements Filter {

   @Override
   public void destroy() { }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
         throws IOException, ServletException {
      if(request.getCharacterEncoding()==null) {
         //캐릭터인코딩 설정된것이없다
         request.setCharacterEncoding("UTF-8");
      }
      chain.doFilter(request, response); //체인걸림
   }

   @Override
   public void init(FilterConfig arg0) throws ServletException { }

}