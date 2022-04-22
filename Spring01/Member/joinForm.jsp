<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02 MVC JoinForm **</title>
<style>
#container {
    width: 100vw;
    height: 80vh;
    display: flex;
    flex-direction: column;
    align-content: center;
    align-items: center;
    justify-content: center;
}
table{
	width:30%;
	height:30%;
}
form{
	display:flex;
	justify-content:center;
	width:100%;
}
.tr1{
	height: 60px;
	width: 50%;
	text-align-last: center;
}
.tr1 > td
{
	width: 50%;
}
.tr1 > td > td
{
	width: 50%;
}
#btn{
display: grid;	
}
</style>
</head>
<body>
<div id = container>
<h2>회원가입</h2>
<form action = "join" method=post >
<table>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=id>I D</label></td>
 	<td><input type="text" name=id id=id size = 20></td>
<!--  	disabled="disabled" -->
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=password>password</label></td>
	<td><input type="password" name=password id=password size = 20></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=name>Name</label></td>
	<td><input type="text" name=name id=name size = 20></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=lev>lev</label></td>
	<td><select name=lev id=lev>
		<option value="A"> 관리자 </option>
		<option value="B"> 나무 </option>
		<option value="C"> 잎새 </option>
		<option value="D"> 새싹 </option>
		
	</select></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=birthd>Birthday</label></td>
	<td><input type="date" name=birthd id=birthd></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=point>Point</label></td>
	<td><input type="text" name=point id=point size = 20></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=weight>weight</label></td>
	<td><input type="text" name=weight id=weight size = 20></td>
</tr>
<tr><td></td>	
	<td><br>
	</td>
</tr>	
</table>
<div id = btn>
		<input type="submit" value=회원가입>&nbsp;&nbsp;
		<input type="reset" value="취소">
</div>
</form>
<hr>
	<c:if test = "${not empty message}">
		${message}
	</c:if><br>
<a href = "home">HOME</a>
</div>
</body>
</html>