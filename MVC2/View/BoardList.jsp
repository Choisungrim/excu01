<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web MVC2 BoardList</title>
<Style>
body {
margin: 0 auto;
background-color: aliceblue;
display: flex;
align-items: center;
flex-direction: column;
}
#table {
width: 80%;
border-radius: 1.2em;
border:3px solid black;
text-align: center;
}
td {
border: 1px solid red;
}
#head {
background-color: gray;
height: 30px;
}
span {
font-weight: bold;
color: red;
}
a{
text-decoration: none;
}
</Style>
</head>
<body>
<h2>Web MVC2 BoardList</h2>
<div id="container">
	<c:if test="${not empty message}">
		<span>=> Message ${message}</span>
	</c:if>
</div>
<table id = "table" class = "table">
	<tr id = "head" class = "head">
		<th>번호</th><th> 제      목 </th><th>I D</th><th>작 성 일 자</th><th>조회수</th>
	</tr>
	<c:if test="${not empty apple}">
		<c:forEach var="m" varStatus="list_vs" items="${apple}">
		<tr align="center">
			<td>${m.seq}</td><td><a href = "/Web02/boardDetail?seq=${m.seq}">${m.title}</a></td><td>${m.id}</td><td>${m.regdate}</td><td>${m.cnt}</td>
		</tr>
	</c:forEach>
</c:if>
	<c:if test="${empty apple}">
		<tr height="30"><td colspan=6> ** 출력할 자료가 1건도 없습니다.
	</c:if>	
</table>
<Br>
<a href="/Web02/index.jsp">HOME</a>
</body>
</html>
