<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script type="text/javascript">
			// 삭제 버튼을 눌렀을 때
			function deleteCheck(){
				var result = confirm("정말 삭제하시겠습니까?");
				
				if(result){
					// 폼객체.submit() : 폼객체를 제출한다.
					document.getElementById("deleteForm").submit();
				} else{
					
				}
			}
			
			// 추천하기 버튼을 눌렀을 때
			function updateLikeCnt(){
				document.getElementById("updateLike").submit();
			}
		</script>
		
		<style type="text/css">
			.menu{
				background-color: aqua;
			}
			
			#boardContentId{
			width : 500px;
			height : 200px;
			vertical-align : top;
		    }
		</style>
	</head>
	<body>
		<h1>[ ${sessionScope.boardId } 님의 블로그 ]</h1>
		
			<table border="1">
				<tr>
					<td class="menu">제목</td>
					<td>
						${board.boardTitle }
					</td>
				</tr>
				<tr>
					<td class="menu">작성일</td>
					<td>
						${board.inputDate }
					</td>
				</tr>
				<tr>
					<td class="menu">내용</td>
					<td id="boardContentId">
						<!-- div style="white-space: pre"를 사용하여 개행을 표현 -->
						<div style="white-space: pre">${board.boardContent }</div>
					</td>
				</tr>
			</table>
			

			<span>추천수</span>
			<span>${board.likeCnt }</span>
			<input type="button" value="추천하기" id="likeCnt" onclick="updateLikeCnt();">
			<br>
			<c:if test="${sessionScope.memberId == sessionScope.boardId }">
				<input type="button" value="수정" onclick="location.href='updateBoard?boardNum=${board.boardNum }';">
				<input type="button" value="삭제" onclick="deleteCheck();">
			</c:if>
		
		
		<form id="deleteForm" action="/board/deleteBoard" method="post">
			<input type="hidden" name="boardNum" value="${board.boardNum }">
		</form>
		
		<form id="updateLike" action="/board/readBoard" method="post">
			<input type="hidden" name="boardNum" value="${board.boardNum }">
		</form>
		
	</body>
</html>