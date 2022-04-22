<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring MVC UpdateForm **</title>
</head>
<body>
<h2>** Web02 MVC UpdateForm **</h2>
<form action = "mUpdate" method=post >
<table>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=id>I D</label></td>
 	<td><input type="text" name=id id=id size = 20 value = "${apple.id}" readonly="readonly"></td>
</tr>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=password>password</label></td>
	<td><input type="text" name=password id=password size = 20 value = "${apple.password}"></td>
</tr>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=name>Name</label></td>
	<td><input type="text" name=name id=name size = 20 value = "${apple.name}"></td>
</tr>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=lev>lev</label></td>
   <%-- ${apple.lev} 에 따라서 해당되는 option 을 selected 
        DAO 의 sql 구문에서 CONCAT~등을 적용했기때문에 lev 의 값은 'A 관리자' 
        -> 그러므로 이것에 대한 처리가 필요 -> EL 의 function 적용 
            ${fn:substring(message,0,1)}
            
         <c:when test="${fn:substring(apple.lev,0,1)=='A'}">
         <option value="A" selected>관리자</option>
         <option value="B">나무</option>
         <option value="C">잎새</option>
         <option value="D">새싹</option>
        </c:when>
    --%>
	<td><select name=lev id=lev>
	<c:choose>
		<c:when test="${fn:substring(apple.lev,0,1)=='A'}">
         <option value="A" selected>관리자</option>
         <option value="B">나무</option>
         <option value="C">잎새</option>
         <option value="D">새싹</option>
        </c:when>
		<c:when test="${fn:substring(apple.lev,0,1)=='B'}">
			<option value="A" > 관리자 </option>
			<option value="B" selected> 나무 </option>
			<option value="C" > 잎새 </option>
			<option value="D" > 새싹 </option>
		</c:when>
		<c:when test="${fn:substring(apple.lev,0,1)=='C'}">
			<option value="A" > 관리자 </option>
			<option value="B" > 나무 </option>
			<option value="C" selected> 잎새 </option>
			<option value="D" > 새싹 </option>
		</c:when>
		<c:when test="${fn:substring(apple.lev,0,1)=='D'}">
			<option value="A" > 관리자 </option>
			<option value="B" > 나무 </option>
			<option value="C" > 잎새 </option>
			<option value="D" selected> 새싹 </option>
		</c:when>
	</c:choose>
	</select></td>
</tr>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=birthd>Birthday</label></td>
	<td><input type="date" name=birthd id=birthd value = "${apple.birthd}"></td>
</tr>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=point>Point</label></td>
	<td><input type="text" name=point id=point size = 20 value = "${apple.point}"></td>
</tr>
<tr height=30>
	<td bgcolor="SlateBlue"><label for=weight>weight</label></td>
	<td><input type="text" name=weight id=weight size = 20 value = "${apple.weight}"></td>
</tr>
<tr><td></td>	
	<td><br>
		<input type="submit" value=수정하기>&nbsp;&nbsp;
		<input type="reset" value="취소">
	</td>
</tr>	
</table>
</form>
<hr>
	<c:if test = "${not empty message}">
		${message}
	</c:if><br>
<a href = "home">HOME</a>
</body>
</html>