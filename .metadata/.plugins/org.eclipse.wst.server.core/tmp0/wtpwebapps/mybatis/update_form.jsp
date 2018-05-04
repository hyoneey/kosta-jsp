<%@page import="kosta.model.Board"%>
<%@page import="kosta.model.BoardDao" %>
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
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-22" data-genuitec-path="/mybatis/WebContent/update_form.jsp">
<h3 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-22" data-genuitec-path="/mybatis/WebContent/update_form.jsp">수정하기</h3>
<hr>
<form action="updateProc.jsp" method="post">
	글 번호:<input type="hidden" name="seq" value="<%= board.getSeq()%>"><br>
	작성자: <input type="hidden" name="writer"><br>
	제목: <input type="text" name="title"><br>
	내용:<br>
	<textarea rows="6" cols="70" name="contents"></textarea>
	<br>
	<input type="submit" value="수정">
</form>
</body>
</html>