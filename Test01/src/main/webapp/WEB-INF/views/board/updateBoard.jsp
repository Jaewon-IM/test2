<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>[ Blog 글수정 ]</h1>
		
		<form action="/board/updateBoard" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="boardTitle" value="${board.boardTitle}" id="boardTitle" size="50px">
					</td>
				</tr>
				<tr>	
					<th>내용</th>
					<td>
						<textarea name="boardContent" rows="10px" cols="50px">${board.boardContent}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						<!-- 게시판번호(PK)를 보내주는 보이지 않는 input (update를 위해) -->
						<input type="hidden" name="boardNum" value="${board.boardNum }">
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>