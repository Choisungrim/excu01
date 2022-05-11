<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02 MVC JoinForm **</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src = "resources/myLib/jquery-3.2.1.min.js"></script>
<script src = "resources/myLib/inCheck.js"></script>
<script>
let iCheck = false;
let pCheck = false;
let lCheck = false;
let nCheck = false;
let bCheck = false;
let poCheck = false;
let wCheck = false;

$(function(){
	$('#id').focus();
	// enterKey 누르면 다음으로 이동 -> keydown()사용
	$('#id').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			// => form 에 submit 이 있는경우
     		// => enter 누르면 자동 submit 발생되므로 이를 제거함
			$('#password').focus();
		}
	}).focusout(()=>{
		iCheck = idcheck();		
	});//id
		
	$('#password').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			$('#name').focus();
		}
	}).focusout(()=>{
		pCheck = pwcheck();
	}) //password
	
	$('#name').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			$('#lev').focus();
		}
	}).focusout(()=>{
		nCheck = namecheck();
	}) //name
	
	$('#lev').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			$('#birthd').focus();
		}
	}).focusout(()=>{
		lCheck = levcheck();
	}); // lev
	
	$('#birthd').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			$('#point').focus();
		}
	}).focusout(()=>{
		bCheck = birthdcheck();
	}) //birthday
	
	$('#point').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			$('#weight').focus();
		}
	}).focusout(()=>{
		poCheck = pointcheck();

	}) //point
	
	$('#weight').keydown((e)=>{
		if(e.which == 13){
			e.preventDefault();
			$('#submit').focus();
		}
	}).focusout(()=>{
		wCheck = weightcheck();
	}) //weight
})// ready
function incheck() {
	 // 모든 항목에 오류 없음을 확인 : switch 변수
	if(iCheck == false){$('#iMessage').html('아이디 확인하세요').css('color','red');}
	if(pCheck == false){$('#pMessage').html('비밀번호 확인하세요').css('color','red');}
	if(nCheck == false){$('#nMessage').html('이름 확인하세요').css('color','red');}
	if(bCheck == false){$('#bMessage').html('생일 확인하세요').css('color','red');}
	if(poCheck == false){$('#poMessage').html('점수 확인하세요').css('color','red');}
	if(wCheck == false){$('#wMessage').html('몸무게 확인하세요').css('color','red');}
	if(iCheck && pCheck && nCheck && bCheck && poCheck && wCheck && lCheck){
		// => submit 확인
		if ( confirm("~~ 정말 가입 하십니까 ? (Yes:확인 / No:취소)")==false ) {
			 alert('~~ 가입이 취소 되었습니다 ~~');
			 return false; 
		}else  // submit 진행 -> 404
			 return true;
			// JS : document.getElementById('myForm').submit(); 
	}else{
		return false;
	}
}

//중복확인
//=> id 옆에 button을 추가 type = button
//=> 처음 submit => disabled , 중복확인 후 => enabled
//=> 아이디 무결성 확인 후 서버로 전송 결과는 새창으로 처리
function iddupcheck() {
	const id = $('#id').val()
	let url = "";
	if(iCheck == false) {
		iCheck = idcheck();
	}else{
		url = 'idDupCheck?id='+$('#id').val();
		window.open(url,'_blank',
		'toolbar=no, menubar=yes, scrollbars=yes, resizable=yes, width=400, height=300');
	}
}
</script>
<style>
.eMessage{
		color: red;
		font-size: small;
		font-style: oblique;
	}
	.td1{
		background-color: aquamarine;
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
 	<td><input type="text" name=id id=id size = 20>&nbsp;&nbsp;
 	<button type ="button" id = "iddup" onclick = "iddupcheck()">중복확인</button>
 	<br>
	<span id = "iMessage" class = "eMessage"></span></td>
<!--  	disabled="disabled" -->
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=password>password</label></td>
	<td><input type="password" name=password id=password size = 20>
	<br>
	<span id = "pMessage" class = "eMessage"></span></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=name>Name</label></td>
	<td><input type="text" name=name id=name size = 20>
	<br>
		<span id = "nMessage" class = "eMessage"></span></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=lev>lev</label></td>
	<td><select name=lev id=lev>
		<option value="A"> 관리자 </option>
		<option value="B"> 나무 </option>
		<option value="C"> 잎새 </option>
		<option value="D"> 새싹 </option>
		
	</select>
	<br>
		<span id = "lMessage" class = "eMessage"></span></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=birthd>Birthday</label></td>
	<td><input type="date" name=birthd id=birthd>
	<br>
		<span id = "bMessage" class = "eMessage"></span></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=point>Point</label></td>
	<td><input type="text" name=point id=point size = 20>
	<br>
		<span id = "poMessage" class = "eMessage"></span></td>
</tr>
<tr class = tr1>
	<td bgcolor="aliceblue"><label for=weight>weight</label></td>
	<td><input type="text" name=weight id=weight size = 20>
	<br>
		<span id = "wMessage" class = "eMessage"></span></td>
</tr>
<tr><td></td>	
	<td><br>
	</td>
</tr>	
</table>
<div id = btn>
		<input type="submit" value=회원가입  id="submit" onclick="return incheck()" disabled>&nbsp;&nbsp;
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