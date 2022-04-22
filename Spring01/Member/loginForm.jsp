<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> RIM 로그인</title>
<style>
body{
	margin: 0 auto;
	background-color: aliceblue;
}
#container{
	width: 100%;
	height: 80vh;
	display: flex;
	flex-direction: column;
    align-content: center;
    align-items: center;
    justify-content: center;
}
tr{
	height: 30%;
}
td:not(.input1){
	border: 1px solid black;
}
.input {
	background-color: snow;
	font-size: 20px;
    font-weight: bold;
    text-align: center;
}
form{
	height: 25%;
}
.input1{
	border: none;
}
a{
	text-decoration: none;
	color: black;
}
input {
	height: 30px;
}
</style>
</head>
<body>
<div id = container>
<h2><a>Rim Page LOGIN</a></h2>
<br>
<form action = "login" method=get>
<table>
<tr>
	<td class = input><label for=id>I D</label></td>
 	<td class = input1><input type="text" name=id id=input1></td>
</tr>
<tr>
	<td class = input><label for=password>Password</label></td>
	<td class = input1><input type="password" name=password id=input1></td>
</tr>
	<tr><td class = input1></td>
		<td class = input1><br>
			<input type="submit" value=로그인>&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
	<c:if test = "${not empty message}">
		<b style = "color: red">${message}</b>
	</c:if><br>
<a href = "home">Home</a>
</div>
</body>
</html>