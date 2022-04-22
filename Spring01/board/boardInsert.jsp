<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web MVC2 Board InsertForm</title>
</head>
<body>
<h2>Web MVC2 Board InsertForm</h2>
<form action="boardInsert" method="get">
<table>
	<tr height="40" bgcolor = LightGreen><td>I D</td>
		<td><input type="text" name="id" value="${Login_id}" readonly></td>
	</tr>
	<tr height="40" bgcolor = LightGreen><td>Title</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr  bgcolor = LightGreen><td>content</td>
		<td><textarea rows = 5 cols = 50 name = content></textarea></td>
	</tr>
	<tr>
		<td>
			<input type ="submit" value ="글등록">
			<input type = "reset" value ="취소">
 		</td>
	</tr>
	
</table>
</form>
<c:if test="${not empty message }">
	<B>=> ${message}</B>
</c:if>
<hr>
<span>
<a href="boardf">리스트로..</a>&nbsp;&nbsp;
<a href="home">HOME</a>
</span>
</body>
</html>