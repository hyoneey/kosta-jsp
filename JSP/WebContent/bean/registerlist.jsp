<%@page import="kosta.bean.Register"%>
<%@page import="java.util.List"%>
<%@page import="kosta.bean.RegisterDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    	RegisterDao dao = RegisterDao.getInstance();
    	List<Register> list = dao.listInfo();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>글목록보기</h3>
	<table width="500" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<%
			for(int i=0; i<list.size(); i++){
				Register register=list.get(i);
		%>
		<tr>

			<td><a href="register.jsp?id=<%=register.getId() %>">
				<%=register.getId() %> </a></td>
			
			<td><%=register.getName() %></td>
			<td><%=register.getPass() %></td>
			<td><%=register.getAge() %></td>

		</tr>
		<% } %>
	</table>
</body>
</html>