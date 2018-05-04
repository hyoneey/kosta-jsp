<%@page import="java.util.ArrayList"%>
<%@page import="kosta.model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-14" data-genuitec-path="/mybatis/WebContent/jstl/jstl_exam.jsp">
	<%String hello= "Hello"; %>
	<c:set var="msg" value="Hello2"></c:set>
	<c:out value="${msg }"></c:out>

	<!-- 구구단 4단 -->
	<ul data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-14" data-genuitec-path="/mybatis/WebContent/jstl/jstl_exam.jsp">
		<c:forEach var="i" begin="1" end="9">
			<li>4 * ${i} = {4*i}</li>
		</c:forEach>
	</ul>

	<%
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("홍길동","강남"));
		list.add(new Member("홍길동2","가산"));
		list.add(new Member("홍길동3","강북"));
		
		request.setAttribute("list", list);
	%>

	<table border="1">
		<tr>
			<td>이름</td>
			<td>주소</td>
		</tr>
		<c:forEach var="m" items="${list }">
			<td>${m.name }</td>
			<td>${m.address }</td>
		</c:forEach>
	</table>
	
	<c:redirect url="jstl_exam2.jsp">
		<c:param name="fruit" value="mango"></c:param>
	</c:redirect>

</body>
</html>