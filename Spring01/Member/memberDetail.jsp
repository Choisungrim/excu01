<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> **Spring MVC2 MemberList Detail **</title>
<style>
 table tr {
 	height: 40;
 }
 .a{
 	background-color: Lavender;
 }
</style>
</head>
<body>
<h2>**Web MVC2 MemberList Detail **</h2>
<table>
	<tr><td class = a>I D</td><td>${apple.id}</td></tr>
	<tr><td class = a>Password</td><td>${apple.password}</td></tr>
	<tr><td class = a>Name</td><td>${apple.name}</td></tr>
	<tr><td class = a>level</td><td>${apple.lev}</td></tr>
	<tr><td class = a>Birthday</td><td>${apple.birthd}</td></tr>
	<tr><td class = a>Point</td><td>${apple.point}</td></tr>
	<tr><td class = a>Weight</td><td>${apple.weight}</td></tr>
	<tr><td class = a>등급</td><td>${apple.lev1}</td></tr>
	<tr><td class = a>비밀번호 보호</td><td>${apple.password1}</td></tr>
	<tr><td class = a>생년월일 앞4자리</td><td>${apple.birthd1}</td></tr>
</table>
<hr>
<a href = "home">HOME</a>
</body>
</html>