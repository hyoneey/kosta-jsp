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
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-15" data-genuitec-path="/mybatis/WebContent/jstl/jstl_exam2.jsp">
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
	<br data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-15" data-genuitec-path="/mybatis/WebContent/jstl/jstl_exam2.jsp"><br>
	
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