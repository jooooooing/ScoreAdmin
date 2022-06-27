<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="ScoreAdmin.dto.Pagination"%>
<%@page import="ScoreAdmin.domain.ScoreItem"%>
<%@page import="ScoreAdmin.service.ScoreItemServiceImpl"%>
<%@page import="ScoreAdmin.service.ScoreItemService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 조회</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<%
		ScoreItemDao scoreItemDao = new ScoreItemDaoImpl();
		ScoreItemService scoreItemService = new ScoreItemServiceImpl();
	
		List<ScoreItem> scoreItems = scoreItemService.selectAll(request.getParameter("cPage"));
		Pagination pagination = scoreItemService.getPagination(currentPage, countPerPage, pageSize, totalCount);	
	%>
	
	<jsp:include page="menu.jsp"></jsp:include>

<div class="container mt-3">
  <h2>전체 성적 조회</h2>          
  <table class="table table-striped text-center">
    <thead>
      <tr>
        <th>이름</th>
        <th>학번</th>
        <th>국어</th>
        <th>영어</th>
        <th>수학</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="scoreItem" items="${scoreItems}">
		<c:url var="url" value = "/selectByName.jsp">
		  <c:param name = "name" value = "${scoreItem.name}"/>
		</c:url>
		  <tr height=80px align=center>
			<td><a href= <c:out value="${url}"/>><c:out value= "${scoreItem.name}"/></a></td>
			<td><c:out value="${scoreItem.studentId}"/></td>
			<td><c:out value="${scoreItem.kor}"/></td>
			<td><c:out value="${scoreItem.eng}"/></td>
			<td><c:out value="${scoreItem.mat}"/></td>
		  <tr>
      </c:forEach>  
    </tbody>
  </table>
  
<br>	
	<div class="text-center">
		<c:url var="urlppPage" value="/selectAllScoreItem.jsp" >
			<c:param name="cPage" value="${pagination.ppPage}"/>
		</c:url>
		
		<c:url var="urlpPage" value="/selectAllScoreItem.jsp">
			<c:param name="cPage" value="${pagination.pPage}"/>
		</c:url>
		
		<c:url var="urlnnPage" value="/selectAllScoreItem.jsp">
			<c:param name="cPage" value="${pagination.nnPage}"/>
		</c:url>
		
		<c:url var="urlnPage" value="/selectAllScoreItem.jsp">
			<c:param name="cPage" value="${pagination.nPage}"/>
		</c:url>
		
		
		<c:if test="${ppPage ne 0 && pPage ne 0}">
		  <a href=<c:out value="${urlppPage}"/>><c:out value="<<"/></a>
		  <a href=<c:out value="${urlppPage}"/>><c:out value="<"/></a>
		</c:if>
		
		<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.lastPage}">
		  <b><a href = 'selectAllScoreItem.jsp?cPage=${i}'>${i}</a></b>
		</c:forEach>
		      
		<c:if test="${nnPage ne 0 && nPage ne 0}">
			<a href=<c:out value="${urlnPage}"/>><c:out value=">"/></a>
			<a href=<c:out value="${urlnnPage}"/>><c:out value=">>"/></a>
		</c:if>
	</div>
</div>



</body>
</html>