<%@page import="ScoreAdmin.ScoreItemService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	ScoreItemService scoreItemService = new ScoreItemService();
	int n = scoreItemService.add(1, 2);
	out.println(n);
	%>
	aasafasf
	<%= n %>
	a


</body>
</html>