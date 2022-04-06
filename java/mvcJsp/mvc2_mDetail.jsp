<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> **MVC2 MemberList Detail **</title>
<style>
 table tr {
 	height: 40;
 }
 table td{
 	background-color: yellow
 }
</style>
</head>
<body>
<h2>**MVC2 MemberList Detail **</h2>
<table>
	<tr><td>I D</td><td>${apple.id}</td></tr>
	<tr><td>Password</td><td>${apple.password}</td></tr>
	<tr><td>Name</td><td>${apple.name}</td></tr>
	<tr><td>level</td><td>${apple.lev}</td></tr>
	<tr><td>Birthday</td><td>${apple.birthd}</td></tr>
	<tr><td>Point</td><td>${apple.point}</td></tr>
	<tr><td>Weight</td><td>${apple.weight}</td></tr>
</table>
</body>
</html>