<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset ="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" type ="text/css" href = "resources/myLib/myStyle.css">
<style>
a { 
color: gray;
text-decoration: none; 
font-weight:bold;
}
a:hover{
	color: Dimgray;
	font-size: 1.2em;
}	 
a:active{
	color: green;
}
</style>
</head>
<body>
<div id = "container">
&nbsp;&nbsp;<h2>Rim Site</h2>
<p> ${serverTime}</p>
<br>
<div>
	<b><c:if test ="${empty Login_id}">
		로그인 후 이용하세요~~
	</c:if>
	<c:if test ="${not empty Login_id}">
		${Login_id} ,${Login_Name} 님 안녕하세요~~<br>
	</c:if></b>
</div>
<Br>
<img src="resources/image/siba.png" width="400" height="300">
<br>
<div>
	<c:if test="${not empty Login_id}">
		<a href = "mDetail">MyInfo</a>
		<a href = "mDetail?jcode=U">Update</a>
		<a href = "logout">Logout</a>
		<a href = "mDelete">탈퇴</a>
	</c:if>
	<c:if test ="${empty Login_id }">
		<a href = "loginf">Login</a>
		<a href = "joinf">Join</a>
	</c:if>
</div>
<br>
<div>
	<a href = "mList"> MList</a>
	<a href = "boardf"> BList</a>
</div>
<br>
<div>
	<c:if test ="${not empty message}">
		= > Message : ${message}
		
	</c:if>
</div>
</div>
</body>
</html>
