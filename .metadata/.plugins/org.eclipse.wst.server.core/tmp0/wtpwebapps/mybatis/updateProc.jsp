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
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-21" data-genuitec-path="/mybatis/WebContent/updateProc.jsp">

</body>
</html>