<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>[ Blog 글쓰기 ]</h1>
		
		<form action="/board/writeBoard" method="post" >
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="boardTitle" id="boardTitle" size="50px">
					</td>
				</tr>
				<tr>	
					<th>내용</th>
					<td>
						<textarea name="boardContent" rows="10px" cols="50px"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="저장">
					</td>
				</tr>
			</table>
			<input type="hidden" name="memberId" value="${sessionScope.memberId }">
		</form>
		
	</body>
</html>