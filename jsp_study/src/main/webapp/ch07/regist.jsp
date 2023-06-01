<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist.jsp</title>
</head>
<body>
	<form method="post" action="regist_action.jsp">
		<div>
			<label>이메일</label>
			<input type="email" name="email"><br>
			<label>전화번호</label>
			<input type="tel" name="tel"><br>
		</div>
		<input type="submit" value="확인">
	</form>
</body>
</html>