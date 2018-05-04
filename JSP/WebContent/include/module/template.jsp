<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%
    	String body = request.getParameter("body");
	    if(body == null){
	    	body = "../main.jsp";
	    }
    %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div id="header">
			<jsp:include page="header.jsp"/>
		</div>
		
		<!-- 값이 선택한 것으로 동적으로 변하기 위해 값을 받아와서 바꿔주기위해 사용 -->
		<!-- %=body%>로 쓸수 있다. 넘겨줄때 이름.jsp로 넘겨준다면 -->
		<%-- 		
			<jsp:include page='<%= "../"+request.getParameter("body")+".jsp" %>'></jsp:include>
		 --%>
		 
			<jsp:include page="menu.jsp"/>

			<hr>
			<jsp:include page="<%=body %>"></jsp:include>
			<hr>
		<div>
			<jsp:include page="footer.jsp"/>
		</div>
</body>
</html>