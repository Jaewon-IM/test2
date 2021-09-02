<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>중복검사</title>
		
		<script type="text/javascript" src="/resources/js/jquery-3.6.0.min.js"></script>
		
		<script type="text/javascript" src="/resources/js/idCheck.js"></script>
		
	</head>
	<body>
		<table>
			<tr>
				<td>
					<input type="text" name="idCheck" id="idCheck">
					<input type="button" value="중복검사" onclick="idCheck();">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="useBtn" value="사용하기" onclick="useId();" style="display:none;">
					<input type="button" id="resetBtn" value="다시 검색하기" onclick="resetId();" style="display:none;">
				</td>
			</tr>
		</table>
	</body>
</html>