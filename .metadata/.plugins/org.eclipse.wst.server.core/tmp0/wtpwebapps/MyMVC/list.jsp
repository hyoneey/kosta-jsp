<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-3" data-genuitec-path="/MyMVC/WebContent/list.jsp">

	<h3 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-3" data-genuitec-path="/MyMVC/WebContent/list.jsp">글목록보기</h3>
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