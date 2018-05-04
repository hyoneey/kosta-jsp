<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> jsp 예제 </h1>
	<%
		Calendar date = Calendar.getInstance();
		SimpleDateFormat today =
				new SimpleDateFormat("yyyy년 MM월 dd일");
	%>
	
	오늘은 <%= today.format(date.getTime()) %>
	
	
</body>
</html>