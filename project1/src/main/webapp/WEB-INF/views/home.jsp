<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>메인화면</h1>
	
		<!-- 로그인 전 화면 -->
		<c:if test="${empty sessionScope.id }">
		<ul>
			<li><a href="/member/join">회원가입</a><br></li>
			<li><a href="/member/login">로그인</a><br></li>	
			<li><a href="/board/comuList">커뮤니티</a><br></li>	
		</ul>
		</c:if>
		<!-- 로그인 후 화면 -->
		<c:if test="${not empty sessionScope.id }">
			<h2>${sessionScope.id }님</h2>
			<ul>
			<li><a href="/member/logout">로그아웃</a><br></li>
			<li><a href="/board/comuList">커뮤니티</a><br></li>
			</ul>
		</c:if>
		
		
	</body>
</html>
