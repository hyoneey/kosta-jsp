<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String m_id = "kosta";
    String m_pass = "1234";
  
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    	
    String m_name = "홍길동";
    String name = URLEncoder.encode(m_name,"utf-8");
    	
    if(id.equals(m_id) && pass.equals(m_pass)){
    	Cookie cookie = new Cookie("name", name);
    	response.addCookie(cookie);
    	response.sendRedirect("main.jsp");
    }else{
    	response.sendRedirect("loginForm.jsp");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-3" data-genuitec-path="/mybatis/WebContent/cookie/loginProc.jsp">

</body>
</html>