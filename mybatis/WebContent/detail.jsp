<%@page import="kosta.model.Board"%>
<%@page import="kosta.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String seq = request.getParameter("seq");
		BoardDao dao = BoardDao.getInstance();
    	Board board = dao.detailBoard(seq);
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <p><%= board.getContents() %></p>   
	 
	 <a href="update_form.jsp?seq=<%= board.getSeq() %>">수정하기</a>
	 <a href="delete.jsp?seq=<%=board.getSeq() %>">삭제하기</a>

</body>
</html>