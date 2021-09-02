<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Blog 목록</title>
	</head>
	<body>
		<h1>[ SES Blog 목록 ]</h1>
		
		<table>
			<c:forEach items="${memberList }" var="member">
				<tr>
					<c:if test="${member.memberPhoto == 1}">
						<td><img src="/resources/img/photo1.png"></td>
					</c:if>	
					<c:if test="${member.memberPhoto == 2}">
						<td><img src="/resources/img/photo2.png"></td>
					</c:if>
					<c:if test="${member.memberPhoto == 3}">
						<td><img src="/resources/img/photo3.png"></td>
					</c:if>	
					<c:if test="${member.memberPhoto == 4}">
						<td><img src="/resources/img/photo4.png"></td>
					</c:if>	
					
					<td><a href="/board/boardList?memberId=${member.memberId }">${member.memberName }(${member.memberId })님의 블로그 보러 가기</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>