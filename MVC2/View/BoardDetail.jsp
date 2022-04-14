<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web MVC2 BoardDetail</title>
<style>
body{
margin: 0 auto;
}
#container{
width: 100%;
height: 3vh;
display: flex;
align-items: center;
flex-direction: column;
}
table{
border: 1px;
}
tr{
height: 40px;
}
td{
border: 1px solid black;
}
.line {
background-color: GreenYellow;
}
</style>
</head>
<body>
<div id="container">
<h2>Web MVC2 BoardList</h2>
	<c:if test="${not empty message}">
		<span>=> Message ${message}</span>
	</c:if>
<table id = "table" class = "table">
	<c:if test="${not empty apple}">
		<tr>
			<td class="line">번호</td><td class = "content">${apple.seq}</td></tr>
		<tr>
			<td class="line">제목</td><td class = "content">${apple.title}</td></tr>
		<tr>
			<td class="line">작성자</td><td class = "content">${apple.id}</td></tr>
		<tr>
			<td class="line">제목</td><td class = "content"><textarea rows="5" cols="50" readonly>${apple.content}</textarea></td></tr>
		<tr>
			<td class="line">작성일자</td><td class = "content">${apple.regdate}</td></tr>
		<tr>
			<td class="line">조회수</td><td class = "content">${apple.cnt}</td>
		</tr>
</c:if>
</table>
<Br>
<span>
<a href="/Web02/B01_bList">리스트로..</a>
<a href="/Web02/index.jsp">HOME</a>
</span>
</div>
</body>
</html>
