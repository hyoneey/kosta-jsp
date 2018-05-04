<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	ul{
		background: blue;
		width: 200px;
		height: 200px;
	}
	ul>li{
		list-style: none;
	}
</style>
</head>
<body>
	<ul>
		<!-- GET방식으로 하기때문에 body가 key값이고 value는 join과 main으로 가져와서 보여줌 -->
		<li><a href="template.jsp?body=../main.jsp">메인</a></li>
		<li><a href="template.jsp?body=../join.jsp">회원가입</a></li>
	</ul>

</body>
</html>