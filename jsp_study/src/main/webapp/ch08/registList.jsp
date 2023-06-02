<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registList.jsp</title>
<style>
	table, th, td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<h2>고객 목록</h2>
	<hr>
	<table>
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
</body>
</html>