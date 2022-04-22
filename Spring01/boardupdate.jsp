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
td:not(#td1){
border: 1px solid black;
}
.line {
background-color: GreenYellow;
}
a{
text-decoration: none;
border: 1 solid black;
}
.pointline{
background-color: yellow;
}
</style>
</head>
<body>
<div id="container">
<h2>Web MVC2 UpdateForm</h2>
<hr>
<form action="boardUpdate" method="get">
<table id = "table" class = "table">
	<c:if test="${not empty apple}">
		<tr>
			<td class="line">번호</td>
			<td><input type ="text" name ="seq" value ="${apple.seq}" readonly></td></tr>
		<tr>
			<td class="line">제목</td>
			<td><input type="text" name ="title" value ="${apple.title}"></td></tr>
		<tr>
			<td class="line">작성자</td>
			<td>${apple.id}</td></tr>
		<tr>
			<td class="line">제목</td>
			<td ><textarea rows="5" cols="50" name = content>${apple.content}</textarea></td></tr>
		<tr>
			<td class="line">작성일자</td>
			<td>${apple.regdate}</td></tr>
		<tr>
			<td class="line">조회수</td>
			<td>${apple.cnt}</td>
		</tr>
		<td id = td1></td>
			<td id =td1><input type = "submit" value ="수정"> &nbsp;&nbsp;
				<input type = "submit" value ="취소"> 
				</td>
</c:if>
</table>
</form>
<Br>
<hr>
<span>
<c:if test="${not empty Login_id}">
	<a href="boardInsertf">새 글 작성</a>	&nbsp;&nbsp;
</c:if>
<a href="boardf">리스트로..</a> &nbsp;&nbsp;
<a href="home">HOME</a>
</span>
<c:if test="${not empty message }">
	=> ${message }
</c:if>
</div>
</body>
</html>