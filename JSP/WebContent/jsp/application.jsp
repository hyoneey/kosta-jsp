<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//콘텍스트 경로
   String path="/message/notice.txt";
   String contextPath=application.getContextPath();
   String fullPath=application.getRealPath(path);

/*    out.println(contextPath+"<br>");
   out.println(fullPath); */
   
   try {
      BufferedReader br= new BufferedReader(new FileReader(fullPath));
      String str="";
      while((str=br.readLine())!=null) {
         out.println(str+"<br>");
      }
   } catch(Exception e) {
      e.printStackTrace();
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