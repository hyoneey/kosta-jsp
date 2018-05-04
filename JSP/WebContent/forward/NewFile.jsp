<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 넘어오는 데이터 값 -->
   <%
    	String value =request.getParameter("page");
    	if(value == null){
    		value="select.jsp";
    	}	
    %>
    <jsp:forward page="<%=value %>"></jsp:forward>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>