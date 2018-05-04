<%@page import="kosta.model.Search"%>
<%@page import="kosta.model.Board"%>
<%@page import="java.util.List"%>
<%@page import="kosta.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("utf-8");
 
 	Search search = new Search();
 	//체크박스의 값을 가져오기 위해 사용 , 여러개 값이 존재하기 때문에 getParameterValues로 가져온다.
 	search.setArea(request.getParameterValues("area"));
 	//like절에 들어가는 내용이므로 값을 넣을 때 미리 '%'를 넣어준다.
 	search.setSearchKey("%"+request.getParameter("searchKey"));
 	
 	
 	
 	BoardDao dao = BoardDao.getInstance();
	List<Board> list = dao.listBoard(search);
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
		<% for(int i=0;i<list.size();i++){
					Board board = list.get(i);	
		%>
		<tr>
			<td><%= board.getSeq() %></td>
			<td><a href="detail.jsp?seq=<%= board.getSeq() %>"><%= board.getTitle() %></a></td>
			<td><%= board.getWriter() %></td>			
			<td><%= board.getRegdate() %></td>			
			<td><%= board.getHitcount() %></td>			
		</tr>
		<%} %>
	</table>
	<br>
	
	<!-- 검색 -->
	<form action="list.jsp" method="post">
		<input type="checkbox" name="area" value="title">제목
		<input type="checkbox" name="area" value="writer">작성자
		<input type="text" name="searchKey" size="10"></input>
		<input type="submit" value="검색">
	</form>
	
</body>
</html>















