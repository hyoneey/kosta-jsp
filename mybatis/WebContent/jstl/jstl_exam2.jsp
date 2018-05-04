<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.fruit == 'banana' }">
		<c:out value="banana"></c:out>
	</c:if>

	<c:choose>
		<c:when test="${param.fruit == 'apple' }">
			<c:out value="apple : 사과"></c:out>
		</c:when>
		<c:when test="${param.fruit == 'orange' }">
			<c:out value="orange : 오렌지"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="mango : 망고"></c:out>
		</c:otherwise>
	</c:choose>
	<br><br>
	
	<c:set var="now" value="<%=new Date() %>"></c:set>
	
	before : ${now}<br>
	after : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd hh:mm"/>
	<br><br>
	
	before : ${50000000 }원 <br>
	after : <fmt:formatNumber value="${50000000 }" type="currency" currencySymbol="\\"></fmt:formatNumber>
	<br><br>
	
	<fmt:formatNumber value="0.99" type="percent"></fmt:formatNumber><br>
	<fmt:formatNumber value="3.154353" pattern="#.00"></fmt:formatNumber>

</body>
</html>