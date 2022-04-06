<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="mvcTest.*, java.util.List" %>
<!--     page deractive -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MemberList MVC2.jsp **</title>
</head>
<body>
<h1>** MemberList MVC2.jsp **</h1>
<table width = 100% align="center" border = 1px solid black>
<tr bgcolor = "Aliceblue" align="center">
	<th>I D</th><th>Password</th><th>Name</th><th>Level</th>
	<th>Birth</th><th>Point</th><th>Weight</th>
</tr>
	<%
		List<MemberVO> list = (List<MemberVO>)request.getAttribute("banana");
	
		try {
			if(list != null) {
				for(MemberVO m:list) {
					%>
					<tr align="center">
					<td><%=m.getId() %></td><td><%=m.getPassword() %></td><td><%=m.getName() %></td>
					<td><%=m.getLev() %></td><td><%=m.getBirthd()%></td><td><%=m.getPoint() %>점</td>
					<td><%=m.getWeight() %> kg</td><td><%=m.getRank() %></td>
					</tr>
					<%
				}
			}else {
				%>
				<tr><td colspan = 7>** 출력할 자료가 없습니다. **</td></tr>
				<%
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	%>

</table>
</body>
</html>