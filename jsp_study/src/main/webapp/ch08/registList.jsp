<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registList.jsp</title>
</head>
<body>
	<h2>고객 목록</h2>[<a href="/jsp_study/rcontrol">새로고침</a>]
	<hr>
	<table border ="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>고객등급</th>
		</tr>
		<c:forEach var="r" items="${regists}">
			<tr>
				<td>${r.id}</td>
				<td><a href="/jsp_study/rcontrol?action=info&id=${r.id}">${r.name}</a></td>
				<td>${r.phone}</td>
				<td>${r.grade}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>고객 추가</h2>
	<hr>
	<form action="/jsp_study/rcontrol?action=insert" method="post">
		<label>이름</label><input type="text" name="name" /><br />
		<label>주소</label><input type="text" name="address" /><br />
		<label>등급</label><input type="text" name="grade" /><br />
		<label>번호</label><input type="text" name="phone" /><br />
		<button type="submit">등록</button>
	</form>
</html>