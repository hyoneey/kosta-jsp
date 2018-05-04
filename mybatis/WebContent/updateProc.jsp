<%@page import="kosta.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
       // 한글 인코딩
       request.setCharacterEncoding("utf-8");
    %>
     <!-- 객체 생성 -->
        <jsp:useBean id="board" class="kosta.model.Board"/>
        
     <!-- 값 가져오기 -->
        <jsp:setProperty name="board" property="*"/>
     
     <%
        out.println(board.getSeq());
        BoardDao dao = BoardDao.getInstance();
        dao.updateBoard(board);
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