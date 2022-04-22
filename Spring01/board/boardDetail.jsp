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
a{
text-decoration: none;
border: 1 solid black;
}
div>table>div{
width:50%
}
</style>
</head>
<body>
<div id="container">
<h2>Spring MVC2 BoardDetail</h2>
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
			<tr></tr>
			<div>
				<table>
					<tr>
						<td><a href = "B08_bgood?seq=${apple.seq}">좋아요</a>${apple.good}</td>
						<td><a href = "B08_bbad?seq=${apple.seq}">싫어요</a>${apple.bad}</td>
					</tr>
				</table>
	</c:if>
	</table>
	<br>
	<div>
		<span>
			<c:if test="${not empty Login_id}">
				<a href="boardInsertf">새 글 작성</a>
				<c:if test="${apple.id eq Login_id}">
					<a href="boardDelete?seq=${apple.seq}">게시글 삭제</a>
					<a href="updatef?seq=${apple.seq}">게시글 수정</a>
				</c:if> 	
			</c:if>
		</span>
	</div>
	<br>
	<div>
		<span>
			<a href="boardf">리스트로..</a>
			<a href="home">HOME</a>
		</span>
	</div>
</div>
</body>
</html>