<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String name = "";
	
	if(cookies != null){
		for(int i=0; i<cookies.length; i++){
			if(cookies[i].getName().equals("name")){
				name = URLDecoder.decode(cookies[i].getValue(),"utf-8");
			}else if(cookies.length == 1 && cookies[i].getName().equals("JSESSIONID")){
				response.sendRedirect("loginForm.jsp");
			}
		}
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
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-5" data-genuitec-path="/mybatis/WebContent/cookie/main.jsp">
	<%=name %>님 반갑습니다.
	<a href="logout.jsp" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-5" data-genuitec-path="/mybatis/WebContent/cookie/main.jsp">로그아웃</a>
</body>
</html>