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
<frameset cols ="200px,*" border="1"> <!--프레임 설정 310px,flex, frameborder 1, border 1 -->
<frame src="./menu.html"> <!--1프레임 menu.html로 설정-->
</frameset>
</head>
<body>
	<%
	ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();	
	ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	scoreItemService.setScoreItemDao(scoreItemDao);
	List<ScoreItem> scoreItems = scoreItemService.selectAll(1,2);
	%>
</body>
</html>


