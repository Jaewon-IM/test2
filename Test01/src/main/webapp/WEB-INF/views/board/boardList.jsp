<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			#menu{
				background-color: aqua;
			}
		</style>
	</head>
	<body>

		<h1>[ ${sessionScope.boardId } 님의 블로그 ]</h1> <!-- HttpSession에 추가하여 표현 -->
		
		<form action="/board/writeBoard" method="get">
			<table>
				<tr id="menu">
					<th>번호</th>
					<th width="200px">제목</th>
					<th>등록일</th>
				</tr>
				<tr>
					<c:forEach items="${boardList }" var="board">
						<tr>
							<td align="center">${board.boardNum }</td>
							<td><a href="/board/readBoard?boardNum=${board.boardNum }">${board.boardTitle }</a></td>
							<td>${board.inputDate }</td>
						</tr>
					</c:forEach>
				</tr>

			</table>
							
				<!-- 본인의 블로그일 시 글쓰기 기능 추가 -->
				<!-- 로그인 ID == 블로그 주인 ID면 글쓰기 가능 -->
				<c:if test="${sessionScope.memberId == sessionScope.boardId }">
					<input type="submit" value="글쓰기">
				</c:if>
				
		</form>
		
	</body>
</html>