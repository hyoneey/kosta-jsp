<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	
	//session.setAttribute("데이터이름", 데이터값); 세션에 데이터값 저장
	session.setAttribute("username", username); 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title>ch06 : selProduct.jsp</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-20" data-genuitec-path="/mybatis/WebContent/mission01/selProduct.jsp">
<div align="center" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-20" data-genuitec-path="/mybatis/WebContent/mission01/selProduct.jsp">
	<H2>상품선택</H2>
	<HR>
	${username } 님 환영합니다!!!!
	<HR>
	<form name="form1" method="POST" action="add.jsp">
		<SELECT name="product">
			<option>사과</option>
			<option>귤</option>
			<option>파인애플</option>
			<option>자몽</option>
			<option>레몬</option>
		</SELECT>
		<input type="submit" value="추가"/>
	</form>
	<a href="checkOut.jsp">계산</a>
</div>
</body>
</html>




