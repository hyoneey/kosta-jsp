<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String product = request.getParameter("product");

	//session은 하나의 값을 저장하여 전달하기 때문에 list로 받아서 모든 값을 담아준다.
	List<String> list = (List<String>)session.getAttribute("product");
	
	if(list == null){
		//리스트를 생성, 생성된 리스트를 세션에 추가
		list = new ArrayList<>();
		session.setAttribute("product", list);
	}
	
	list.add(product);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="javascript:history.back()">뒤로가기</a>
	<%=product%>
</body>
</html>