<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     List<String> check = (List<String>)session.getAttribute("product");
    
    if(check == null){
    	out.println("선택한 과일이 없습니다.");
    }else{
    	for(String fruit: check){
    		out.println(fruit);
    	}
    }
    	
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>