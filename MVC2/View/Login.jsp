<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02 LoginForm **</title>
</head>
<body>
<h2>** Web02 LoginForm **</h2>
<br>
<form action = "/Web02/C01_Login" method=get>
<table>
<tr height=30>
	<td bgcolor="aqua"><label for=id>I D</label></td>
 	<td><input type="text" name=id id=id></td>
</tr>
<tr height=30>
	<td bgcolor="aqua"><label for=password>Password</label></td>
	<td><input type="password" name=password id=password></td>
</tr>
<tr><td></td>	
	<td><br>
		<input type="submit" value=로그인>&nbsp;&nbsp;
		<input type="reset" value="취소">
	</td>
</tr>	
</table>
</form>
<hr>
	<c:if test = "${not empty message}">
		${message}
	</c:if><br>
<a href = "/Web02/index.jsp">Home</a>
</body>
</html>
