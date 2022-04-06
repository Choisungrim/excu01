<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="mvcTest.*, java.util.List" %>
<!--     page deractive -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MemberList MVC2_JSTL, EL**</title>
</head>
<body>
<h1>** MemberList MVC2_JSTL, EL **</h1>
<table width = 100% align="center" border = 1px solid black>
	<tr bgcolor = "Aliceblue" align="center">
		<th>I D</th><th>Password</th><th>Name</th><th>Level</th>
		<th>Birth</th><th>Point</th><th>Weight</th>
	</tr>
	<c:if test="${not empty banana}">
		<c:forEach var="m" varStatus="list_vs" items="${banana}">
		<tr align="center">
			<td>${m.id}</td><td>${m.password}</td><td>${m.name}</td>
			<td>${m.lev}</td><td>${m.birthd}</td><td>${m.point}</td>
			<td>${m.weight}</td><td>${m.rank}</td>
		</tr>
	</c:forEach>
</c:if>
	<c:if test="${empty banana}">
		<tr><td colspan=7> ** 출력할 자료가 1건도 없습니다.
	</c:if>	
</table>
</body>
</html>