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
</head>
<body>
	<jsp:forward page="el_result.jsp">
		<jsp:param value="apple" name="fruit"/>
	</jsp:forward>
</body>
</html>