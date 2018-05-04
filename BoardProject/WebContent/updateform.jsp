<%@ page import="kosta.model.BoardService"%>
<%@ page import="kosta.model.Board"%>
<%@page import="kosta.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	String id = request.getParameter("b_id");
	int b_id = 0;
	if(id != null){
		//타이틀에 해주기 위해 형변환
		b_id = Integer.parseInt(id);
	}
	
	BoardService service = BoardService.getInstance();
	Board board = service.selectBoardService(b_id,false);
	
	request.setAttribute("board", board);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정하기</h1>
	<form action="updateOk.jsp" method="post">				
		<table border="1" cellpadding="0" cellspacing="0">
			<tr height="30">
				<td width="80">작성자</td>
				<td width="170"><input type="hidden" name="b_name" size="10" value="<%=b_id %>">
				</td>
				<td width="80">비밀번호</td>
				<td width="170"><input type="password" name="b_pwd" size="10">
				</td>
			</tr>
			
			<tr height="30">
				<td width="80">제목</td>
				<td align="left" colspan="3">
					<c:choose>
						<c:when test="${param.b_id != null }">
							<input type="text" name="b_title" size="50"
									value=" ${board.b_title }">
						</c:when>
						<c:otherwise>
							<input type="text" name="b_title" size="50">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr height="30">
				<td colspan="4">
					<textarea rows="10" cols="70" name="b_content"></textarea>
				</td>
			</tr>
			<tr height="30">
				<td colspan="4" align="center"><input type="submit" value="수정하기">&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>