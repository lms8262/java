<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="member" class="ch07.com.dao.Member" />
<jsp:setProperty property="*" name="member"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardRedirect.jsp</title>
</head>
<body>
	<%=member.result() %>
</body>
</html>