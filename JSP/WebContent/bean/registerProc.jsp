<%@page import="kosta.bean.RegisterDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("utf-8");
 %>   
 	<jsp:useBean id="register" class="kosta.bean.Register"></jsp:useBean>
	<jsp:setProperty property="*" name="register"/> 
<%
	RegisterDao dao = RegisterDao.getInstance();
	dao.insert(register);
%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>