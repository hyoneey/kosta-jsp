<%@page import="kosta.bean.BoardDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

	<jsp:useBean id="board" class="kosta.bean.Board"></jsp:useBean>
	<jsp:setProperty name="board" property="*"/>
	
<%
	/* static변수는 class명으로 접근 */
	BoardDao dao = BoardDao.getInstance();
	dao.insertBoard(board);
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