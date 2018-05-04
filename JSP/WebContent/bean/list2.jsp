
<%@page import="kosta.bean.Board"%>
<%@page import="java.util.List"%>
<%@page import="kosta.bean.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDao dao = BoardDao.getInstance();
	List<Board> list = dao.listBoard();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>글목록보기</h3>
	<a href="insert_form.jsp">글쓰기</a>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<%
			for(int i=0; i<list.size(); i++){
				Board board=list.get(i);
		%>
			<tr>
				<td><%= board.getSeq() %> </td>
				
				<td><a href="detail.jsp?seq=<%=board.getSeq() %>">
					<%=board.getTitle()  %></a></td>
				
				<td><%=board.getWriter()  %></td>
				<td><%=board.getRegdate()  %></td>
				<td><%=board.getHitcount()  %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>