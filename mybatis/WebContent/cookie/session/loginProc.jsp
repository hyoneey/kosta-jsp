<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String m_id = "kosta180";
    String m_pass = "1234";
       
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    
    String m_name = "홍길동";
    String name = m_name;
  
   session.setAttribute("name", name);  
    
    if(id.equals(m_id)&&pass.equals(m_pass)){   // id와 pass가 일치하면(= 로그인에 성공한다면)
        request.getSession();   // 세션 시작
       // 데이터 저장

       response.sendRedirect("main.jsp");
    } else {
       response.sendRedirect("loginForm.jsp");
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