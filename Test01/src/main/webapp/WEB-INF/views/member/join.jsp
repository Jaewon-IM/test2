<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style type="text/css">
			table{
				border : 1px solid #444444;
			}
		</style>
		<script type="text/javascript" src="/resources/js/memberJoin.js"></script>
	</head>
	<body>
		<!-- 유효성 검사만 해결하기 -->
		<h1>[ SES Blog 회원가입 ]</h1>

		<form action="/member/join" method="post" onsubmit="return formCheck();">
			<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId" id="memberId">
					</td>
				</tr>
	
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="memberPw" id="memberPw">
					</td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="memberName" id="memberName">
					</td>
				</tr>
					
				<tr>
					<td>사진 선택</td>
					<td>
						<input type="radio" name="memberPhoto" id="photo1" value=1 checked="checked">
						<img src="/resources/img/photo1.png">
						
						<input type="radio" name="memberPhoto" id="photo2" value=2>
						<img src="/resources/img/photo2.png">
						
						<input type="radio" name="memberPhoto" id="photo3" value=3>
						<img src="/resources/img/photo3.png">
						
						<input type="radio" name="memberPhoto" id="photo4" value=4>
						<img src="/resources/img/photo4.png">
					</td>
				</tr>	
				
				<tr>
					<td colspan="5" align="center"><input type="submit" value="가입" ></td>
				</tr>		
			</table>
		</form>
	</body>
</html>