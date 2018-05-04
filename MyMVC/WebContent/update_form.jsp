<%@page import="kosta.model.Board"%>
<%@page import="kosta.model.BoardDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>수정하기</h3>
<hr>
<form action="UpdateAction.do" method="post">
	글 번호:<input type="hidden" name="seq" value="${board.seq }"><br>
	작성자: <input type="hidden" name="writer"><br>
	제목: <input type="text" name="title"><br>
	내용:<br>
	<textarea rows="6" cols="70" name="contents"></textarea>
	<br>
	<input type="submit" value="수정">
</form>
</body>
</html>