<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자유게시판</title>
		
		<script type="text/javascript">
			function writeBoard(){
				location.href="writeFreeBoard";
			}
			
		</script>
	</head>
	<body>
		<h1>자유게시판</h1>
		
		<table border="1">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>작성일</td>
				<td>조회</td>
				<td>추천</td>
			</tr>
			<tr>
				<c:forEach items="${freeBoardList }" var="board">
					<tr>
						<td>${board.boardNum }</td>
						<td><a href="/board/readBoard?boardNum=${board.boardNum }">${board.boardTitle }</a></td>
						<td>${board.id }</td>
						<td>${board.indate }</td>
						<td>${board.cnt }</td>
						<td>${board.likes }</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		
		<input type="button" value="글쓰기" onclick="writeBoard();">
		
	</body>
</html>