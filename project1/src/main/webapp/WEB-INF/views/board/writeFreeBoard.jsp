<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>글쓰기</title>
	</head>
	<body>
		<h1>글 작성</h1>
		
		<form action="writeFreeBoard" method="post">
			<table>
				<tr>
					<td>
						<input type="text" name="boardTitle" id="title" placeholder="제목을 입력해주세요">
					</td>
				</tr>
				<tr>
					<td>
						<textarea name="boardContent" style="width:500px; height:300px; resize: none"></textarea>
					</td>
				</tr>
			</table>
			
			<input type="submit" value="등록">
			<input type="hidden" name="id" value="${sessionScope.id }">
		</form>
	</body>
</html>