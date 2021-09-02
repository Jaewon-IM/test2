<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		
		<script type="text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
		<script type="text/javascript" src="/resources/js/memberJoin.js"></script>		
	</head>
	<body>
		<h1>회원가입</h1>
	
		<form action="/member/join" method="post" onsubmit="return formCheck();" name="form">
			<table>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" id="id" readonly="readonly">
						<input type="button" value="ID중복검사" onclick="idCheck()">
					</td>

				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password" id="password">
					</td>
				</tr>
				<tr>
					<th>비밀번호 재확인</th>
					<td>
						<input type="password" name="checkPw" id="checkPw">
					</td>
				</tr>	
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" id="name">
					</td>
				</tr>
				<tr>
					<!-- birth를 year+month+day합쳐서 표현하기 -->
					<th>생년월일</th>
					<td>
						<input type="text" name="birth" id="birth" placeholder="ex)19990101">
						<!-- <input type="text" name="year" id="year" placeholder="년">
						<select name="month" id="month">
							<option value="none">월</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
						<input type="text" name="day" id="day" placeholder="일"> -->
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="M">남
						<input type="radio" name="gender" value="F">여
					</td>
				</tr>
				<tr>
					<th>휴대전화</th>
					<td>
						<input type="text" name="phone" id="phone" placeholder="- 빼고 입력해주세요.">
						<input type="button" value="인증번호 받기" >
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<input type="text" name="certified" id="certified" placeholder="인증번호를 입력하세요">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<input type="submit" value="가입하기">
					</td>
				</tr>
			</table>
			
		</form>
	</body>
</html>