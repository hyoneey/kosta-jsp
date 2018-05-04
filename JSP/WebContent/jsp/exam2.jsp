<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		/* 요청 */
		 request.setAttribute("result", 100); 
	%>
	
	<!--  request 값이 되어서 저장된 값이 전달되어진다. -->
	<!-- 기존에 있던 request를 가져와서 사용 하는것 exam2.jsp -->
	 <jsp:forward page="a.jsp"></jsp:forward> 
	  
	<%
		//체크박스에 있는 데이터 값을 받고자 할때 사용하는 함수 : getParameterValues()
		String str[] = request.getParameterValues("opt");
	
		//response내장객체 - result의 값이 전달 되지 않는다.
		//sendRedirect : 새롭게 요청을해서 새로운 request가 생성된다. a.jsp
		//response.sendRedirect("a.jsp");
		
	%>
	
</body>
</html>