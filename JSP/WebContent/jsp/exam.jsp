<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<%
		for(int i=0; i<6; i++){
	%>
		<h3>HTML 내용 반복</h3>
	<%
		}
	%> --%>

	<% 
		for(int i=1; i<=4; i++){
	%>
	<table border=1>
		<tr>
		<%			for(int j=1; j<=2; j++){ %>
			<td>1</td>
			<% } %>
		</tr>
	</table>
	<%
		}
	%>

</body>
</html>