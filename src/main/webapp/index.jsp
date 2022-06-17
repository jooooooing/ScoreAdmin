<%@page import="java.util.List"%>
<%@page import="ScoreAdmin.service.ScoreItemServiceImpl"%>
<%@page import="ScoreAdmin.service.ScoreItemService"%>
<%@page import="ScoreAdmin.dao.ScoreItemDao"%>
<%@page import="ScoreAdmin.dao.ScoreItemDaoImpl"%>
<%@page import="ScoreAdmin.domain.ScoreItem"%>
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
	ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();	
	ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	scoreItemService.setScoreItemDao(scoreItemDao);
	List<ScoreItem> scoreItems = scoreItemService.selectAll(1,2);
	%>
	test
</body>
</html>