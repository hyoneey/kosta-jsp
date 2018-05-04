<%@page import="kosta.bean.Register"%>
<%@page import="kosta.bean.RegisterDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%
    	String id = request.getParameter("id");
		RegisterDao dao = RegisterDao.getInstance();
    	Register register = dao.info(id);
	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=register.getPass() %>
	<%=register.getName() %>
	<%=register.getAge() %>
</body>
</html>