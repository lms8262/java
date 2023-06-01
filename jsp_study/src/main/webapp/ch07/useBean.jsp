<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="gugudan" class="ch07.com.dao.GuGuDan" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBean.jsp</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<%=gugudan.process(5)%>
</body>
</html>