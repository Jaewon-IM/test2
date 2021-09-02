<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
	</head>
	
	<script type="text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
		
	<script type="text/javascript">

	</script>
	<body>
		<h1>로그인</h1>
		
		<form action="/member/login" method="post">
			<table>
				<tr>
					<td>
						<input type="text" name="id" id="id" placeholder="아이디">
					</td>
				</tr>
				<tr>
					<td>
						<input type="password" name="password" id="password" placeholder="비밀번호">
					</td>
					<td>
						<div id="errMsg" style="color:red"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
					</td>
				</tr>			
			</table>
		</form>
	</body>
</html>