<%@page import="kosta.model.Board"%>
<%@page import="kosta.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>글목록보기</h3>
   <a href="insertForm.do">글쓰기</a>
   <table width="500" border="1" cellpadding="0" cellspacing="0">
      <tr>
         <th>글번호</th>
         <th>제목</th>
         <th>작성자</th>
         <th>내용</th>
         <th>작성일자</th>
         <th>조회수</th>
      </tr>

      <tr>

         <td>${board.seq }</td>
         <td>${board.title }</td>
         <td>${board.writer}</td>
         <td>${board.contents }</td>
         <td>${board.regdate }</td>
         <td>${board.hitcount }</td>
      </tr>
   </table>
   <a href="UpdateFormAction.do?seq=${board.seq }">수정하기</a>
   <a href="DeleteAction.do?seq=${board.seq }">삭제하기</a>

</body>
</html>