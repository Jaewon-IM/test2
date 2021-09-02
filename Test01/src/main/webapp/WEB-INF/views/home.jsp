<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		[ SES BLOG ]  
	</h1>
	
	<c:if test="${empty sessionScope.memberId }">
		<ul>
			<li><a href="/member/join">회원가입</a><br></li>
			<li><a href="/member/login">로그인</a><br></li>
			<li><a href="/member/memberList">블로그를 개설한 회원 목록 보기</a></li>		
		</ul>
	</c:if>
	<c:if test="${not empty sessionScope.memberId }">
		<!-- a테그는 GET방식만 사용가능 -->
		<h2>${sessionScope.memberId }님 환영합니다 !!!</h2>
		<ul>
		<li><a href="/member/logout">로그아웃</a><br></li>
		<li><a href="/member/memberList">블로그를 개설한 회원 목록 보기</a></li>
		</ul>
	</c:if>
	
</body>
</html>
