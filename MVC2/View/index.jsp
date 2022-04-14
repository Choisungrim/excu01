<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web Test **</title>
<link rel="styleSheet" type="text/css" href ="./myLib/myStyle.css">
</head>
<body>
&nbsp;&nbsp;<h2>** Web Test **</h2>
<br><hr>
	<c:if test ="${empty Login_id}">
		로그인 후 이용하세요~~
	</c:if>
	<c:if test ="${not empty Login_id}">
		${Login_id} ,${Login_Name} 님 안녕하세요~~<br>
	</c:if>
<hr>
<img src="./image/tulips.png" width="400" height="300">
<hr>
	<c:if test="${not empty Login_id}">
		<a href = "/Web02/C03_mDetail">MyInfo</a>
		<a href = "/Web02/C03_mDetail?jcode=U">Update</a>
		<a href = "/Web02/C02_Logout">Logout</a>
		<a href = "/Web02/C07_mDelete">Delete</a>
	</c:if>
	<c:if test ="${empty Login_id }">
		<a href = "/Web02/member/loginForm.jsp">Login</a>
		<a href = "/Web02/member/joinForm.jsp">Join</a>
	</c:if>
<hr>
	<a href = "/Web02/mList"> MList</a>
	<a href = "/Web02/B01_bList"> BList</a>
<hr>
	<c:if test ="${not empty message}">
		= > Message : ${message}
	</c:if>
</body>
</html>
