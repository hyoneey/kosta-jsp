<%@ page import="kosta.model.BoardService"%>
<%@ page import="kosta.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%
	String id = request.getParameter("b_id");
	int b_id = 0;
	int b_ref = 0; //그룹번호
	int b_step =0; //그룹 내 순서
	int b_level =0;
	
	 //답변글
	if(id != null){
		//타이틀에 해주기 위해 형변환
		b_id = Integer.parseInt(id);
	}
	
	BoardService service = BoardService.getInstance();
	Board board = service.selectBoardService(b_id,false);
	
	if(board != null){
		b_ref = board.getB_ref(); //부모의 ref
		b_step = board.getB_step(); //부모의 step
		b_level = board.getB_level(); //부모의 level
	}

	//el태그에서 뽑아오기 위해서 사용, 이름을 board로 지정했으니 board로 보냄
	request.setAttribute("board", board);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"52652",secure:"52657"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-4" data-genuitec-path="/BoardProject/WebContent/insertform.jsp">
	<h1 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-4" data-genuitec-path="/BoardProject/WebContent/insertform.jsp">글작성하기</h1>
	<form action="insertOk.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name ="b_id" value="<%=b_id  %>">
	<input type="hidden" name ="b_ref" value="<%=b_ref  %>">
	<input type="hidden" name ="b_step" value="<%=b_step  %>">
	<input type="hidden" name ="b_level" value="<%=b_level  %>">
				
		<table border="1" cellpadding="0" cellspacing="0">
			<tr height="30">
				<td width="80">작성자</td>
				<td width="170"><input type="text" name="b_name" size="10">
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
									value="[re]: ${board.b_title }">
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
				<td>파일</td>
				<td colspan="3">
					<input type="file" name="b_fname">
				</td>
			</tr>
			<tr height="30">
				<td colspan="4" align="center"><input type="submit" value="글쓰기">&nbsp;&nbsp;
					<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>