<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	<body>
		<h1>로그인</h1>
		
		<form action="/member/login" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="memberId" id="memberId">
					</td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td>
						<input type="password" name="memberPw" id="memberPw">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="Login">
					</td>
				</tr>
			</table>
		</form>
		
	</body>
</html>