<%@page import="java.util.HashMap"%>
<%@page import="kosta.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "kosta");

	Member m = new Member();
	m.setName("홍길동");
	request.setAttribute("member", m);
	
	HashMap<String, String> map = new HashMap<String,String>();
	map.put("samsung", "양창섭");
	request.setAttribute("baseball", map);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/mybatis/WebContent/EL/el_exam.jsp">
	<jsp:forward page="el_result.jsp">
		<jsp:param value="apple" name="fruit"/>
	</jsp:forward>
</body>
</html>