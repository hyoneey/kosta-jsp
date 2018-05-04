<%@page import="kosta.model.Reply"%>
<%@page import="java.util.List"%>
<%@page import="kosta.model.Board"%>
<%@page import="kosta.model.BoardService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	String id = request.getParameter("b_id");
	int b_id = 0;
	
	if(id != null){
		b_id = Integer.parseInt(id);
	}
	
	BoardService service = BoardService.getInstance();
	Board board = service.selectBoardService(b_id, true);
	
	List<Reply> replyList = service.selectReplyService(b_id);
	//el태그에서 뽑아오기 위해서 사용, 이름을 board로 지정했으니 board로 보냄
	request.setAttribute("replyList", replyList);
	request.setAttribute("board", board);	

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function fn_reply(){
		location.href = "insertform.jsp?b_id=${board.b_id }";
	}
	
	function fn_update(){
		location.href = "updateform.jsp?b_id=${board.b_id }";
	}

</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-1" data-genuitec-path="/BoardProject/WebContent/detail.jsp">
	<h3 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-1" data-genuitec-path="/BoardProject/WebContent/detail.jsp">글세부보기</h3>
	<table border="1">
		<tr height="30">
			<td width="150">글번호</td>
			<td width="150">${board.b_id }</td>
			<td width="150">조회수</td>
			<td width="150">${board.b_hit }</td>
		</tr>
		<tr height="30">
			<td width="150">작성자</td>
			<td width="150">${board.b_name }</td>
			<td width="150">작성일</td>
			<td width="150">
				<fmt:formatDate value="${board.b_date }" pattern="yyyy-MM-dd"/>
			</td>
		</tr>			
		<tr height="30">
			<td width="150">파일</td>
			<td colspan="3">
				<a href="download.jsp?filename=${board.b_fname }">${board.b_fname }</a>
			</td>			
		</tr>
		<tr height="30">
			<td width="150">제목</td>
			<td colspan="3">${board.b_title }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">${board.b_content }</td>			
		</tr>
		<tr height="30">			
			<td colspan="4">
				<input type="button" value="답변글" onclick="fn_reply()">
				<input type="button" value="수정"  onclick="fn_update()">
			</td>			
		</tr>
	</table>
	<br><br>
	
	<h5>댓글 목록</h5>
	<table border="1">
		<tr height="30">
			<td width="150"> 번호</td>
			<td width="150"> 이름 </td>
			<td width="150"> 내용 </td>
		</tr>
		<c:forEach var="i" items="${ replyList}" >
			<tr height="30">
				<td width="150"> ${i.r_id }</td>
				<td width="150"> ${i.r_name }</td>
				<td width="150"> ${i.r_content }</td>
			</tr>
		</c:forEach>
		
	</table>
	<br><br>
	
	<!-- 댓글폼 -->
	<form action="reply.jsp" method="post">
		<input type="hidden" name="b_id" value="<%= b_id %>">
		이름: <input type="text" name="r_name" size=10>
		내용: <input type="text" name="r_content" size=30>
		<input type="submit" value="submit">	
	</form>	
	
</body>
</html>






