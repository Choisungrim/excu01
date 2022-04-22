<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC2 memberList</title>
</head>
<body>
<table width = 100% align="center" border = 1>
	<tr bgcolor = "Aliceblue" align="center" height="30">
		<th>I D</th><th>비밀번호</th><th>이름</th><th>lev</th><th>Birthd</th>
		<th>Point</th><th>Weight</th>
	</tr>
	<c:if test="${not empty apple}">
		<c:forEach var="m" varStatus="list_vs" items="${apple}">
		<tr align="center">
			<td>${m.id}</td><td>${m.password}</td><td>${m.name}</td>
			<td>${m.lev}</td><td>${m.birthd}</td><td>${m.point}</td><td>${m.weight}</td>
		</tr>
	</c:forEach>
</c:if>
	<c:if test="${empty apple}">
		<tr height="30"><td colspan=7> ** 출력할 자료가 1건도 없습니다.
	</c:if>
	</table>	
	<br>
<a href = "home">Home</a>
</body>
</html>