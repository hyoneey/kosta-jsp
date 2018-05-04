<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>글목록보기</h3>
	<a href="insert_form.jsp">글쓰기</a>
	<table width="500" border="1" cellpadding="0" cellspacing="0"  >
		<tr>
			<th>목록</th>			
			<th>제목</th>	
			<th>작성자</th>		
			<th>조회수</th>

		</tr>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.seq }</td>
				<td><a href="DetailAction.do?seq=${board.seq}">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>${board.hitcount }</td>
			</tr>
		</c:forEach>


	</table>
	<br>
</body>
</html>