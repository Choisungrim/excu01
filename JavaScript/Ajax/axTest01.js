/**
 * Spring01 Ajax Test
 * => axLogin, axJoin, MousePointer
 * => form의 input data 처리
 * => JSON -> JavaScript 가 인식할 수 있는 데이터 포맷형태

 ** Ajax에서 input Data (Value) 처리방법
 1) Form 의 serialize()
 => input Tag 의 name 과 id 가 같아야 함.   
 => 직렬화 : multipart 타입은 전송안됨. 
           처리하지 못하는 값(예-> file Type) 은 스스로 제외시킴 
 => 제외컬럼 지정하기
    var formData = $('#myForm:not(#rid)').serialize();
    rid 만 제외시키는 경우 (보류:적용안됨)

 2) 객체화   
 => 특정 변수 (객체형) 에 담기      
 => 특별한 자료형(fileType: UpLoadFilef) 적용안됨.   

 3) FormData 객체 활용
 => 모든 자료형의 특성에 맞게 적용가능하여 이미지등의 file 업로드가 가능한 폼데이터 처리 객체
 => IE10부터 부분적으로 지원되며, 크롬이나 사파리, 파이어폭스같은 최신 브라우져에서는 문제 없이 동작
 => 3.1) append 메서드 또는 3.2) 생성자 매개변수 이용

 ** 관련속성   
 => form Tag 의 enctype 속성: 'multipart/form-data', // 생략 가능
 => ajax 속성
      enctype: 'multipart/form-data', // form Tag 에서 지정하므로 생략 가능
      processData:false, // false로 선언시 formData를 string으로 변환하지 않음
      contentType:false, // false로 선언시 content-type 헤더가 multipart/form-data로 전송되게 함

// $.ajax({
// 	url:"joinck",
// 	type:"post",
// 	data :{id:id},
// 	success: (result)=>{
// 		if(result != 'fall'){
			
// 		}else {
			
// 		}		
// 	};

// => axLogin
//    로그인 성공 or 실패에 따른 다른 처리가 필요함
//    서버로 부터 결과값을 전달받을 필요성 
//    서버의 결과는 Java 의 Data -> JS 가 이를 이용해서 코딩
//    그러므로 Java의 Data를 JS가 인식가능한 Data형식(JSON 포맷)으로 변환 해야함  

 */


$(function(){
	// ** MousePointer
	// ~~.hover(f1,f2)
	$('.textLink').hover(() => {
		$('.textLink').css({
			fontSize :'1.2em',
			fontWeight : 'bold',
			color : 'deepskyblue',
			cursor : 'pointer'
		}); // css
	}, 	() => {
		$('.textLink').css({
			fontSize :'',
			fontWeight : 'bold',
			color : 'gray',
			cursor : 'default'
		}); // css
	}); // hover
	
	// ** axLogin
	// => axLoginf
	$('#axloginf').click(() => {
		$.ajax({
		url : 'loginf',
		type : 'Get',
		success : (result) => {
			$('#result_Area').html(result);
		},
		error : () => {
			alert('서버와 연결에 실패하였습니다.');
		}
		}); // ajax
	}) // axloginf click
	
	
	// => axLogin
	$('#axlogin').click(() => {
		$.ajax({
			url : 'login',
			type : 'Post',
			data : {
				id : $('#id').val(), // vo 안에 접근되기위한객체는 id 가된다 // $('#id').val()가 아님.
				password : $('#password').val()
			},
			success : () => {
				// => result_Area는 clear , home : 새로고침
				$('#result_Area').html('');
				location.reload();
			},
			error : () => {
				alert('서버와 연결에 실패 하였습니다.');
			}
		}) // ajax
	}); // click
	
	// ** AjaxJoin
	// => AjaxJoinF
	$('#axjoinf').click(() => {
		$.ajax({
			url : 'joinf',
			type : 'get',
			success : (result) => {
				$('#result_Area1').html(result);
			},
			error : () => {
				alert('서버와 연결에 실패하였습니다.');
			}
		}) // ajax
	}) // click
	
	// => AjaxJoin
	// => Serialize (직렬화)
//	id : $('#id').val(),
//	password : $('#password').val(),
//	name : $('#name').val(),
//	lev : $('#lev').val(),
//	birthd : $('#birthd').val(),
//	point : $('#point').val(),
//	weight : $('#weight').val()		
	$('#axjoin').click(() => {
		// 1)
		//var formData = $('#myform').serialize();//Serialize
		//data : formData,
		
		// 2) 
// var formData ={	id : $('#id').val(),
//	password : $('#password').val(),
//	name : $('#name').val(),
//	lev : $('#lev').val(),
//	birthd : $('#birthd').val(),
//	point : $('#point').val(),
//	weight : $('#weight').val() }

		// 3) FormData() 객체
   // ** 관련속성   
   // => enctype: 'multipart/form-data', // 생략 가능
   // => processData:false, // false로 선언시 formData를 string으로 변환하지 않음
   // => contentType:false, // false로 선언시 content-type 헤더가 multipart/form-data로 전송되게 함
//		var formData = new FormData();
//		formData.append('id',$('#id').val());
//		formData.append('password',$('#password').val());
//		formData.append('name',$('#name').val());
//		formData.append('lev',$('#lev').val());
//		formData.append('birthd',$('#birthd').val());
//		formData.append('point',$('#point').val());
//		formData.append('weight',$('#weight').val());
		// 4) FormData() 객체 2 : all append ...
	// 4.1) 생성시 인자로 form 사용
		var formData = new FormData(document.getElementById("myform")); 
		// form 태그의 타입을 multipart로 변환하여 전송하는 객체를 담는다
		// 사용하기 위해 controller 에서도 request하는 라이브러리가 필요.
		
		
		alert('성공'+formData);
		$.ajax({
			url : 'join',
			type : 'Post',
			processData:false,
			contentType:false, 
			charset : "UTF-8",
			data : formData,
			success : (result) => {
				$('#result_Area1').html(result);
			},
			error : () => {
				alert('서버와 연결에 실패하였습니다.');
			}
		}); // ajax
	}); // click
}); // ready 