/*
**  입력값의 무결성 확인
** member 무결성 확인사항
// ID : 길이(4이상), 영문자,숫자 로만 구성
// password : 길이(4이상), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Level : select 를 이용 (X)
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 정수의 범위  ( 숫자이면서, '.'이 없어야함 )
// Weight: 구간 (20 ~ 200)

** 작성 규칙
   => JavaScript function 으로 정의 하고 
      결과를 true or false 로 return
*/
function idcheck(){
	var id = $('#id').val(); // id=$(this).val()
		if(id.length<4){
			$('#iMessage').html('ID의 길이가 4 이상입니다.').css('color','red');
			$('#id').focus();
			return false;
		}else if(id.replace(/[a-z.0-9]/gi,'').length>0){
			$('#iMessage').html('ID는 영문자, 숫자로만 입력하세요.!!').css('color','red');
			$('#id').focus();
			return false;
		}else {
			$('#iMessage').html('ID 가 정상적으로 입력 되었습니다.').css('color','green');
			return true;
		};
	}; // idCheck


//function ppwcheck(){
//	var password = $('#password').val();
//		var ppassword = $('#ppassword').val();
//		if(password != ppassword ){
//            $('#ppMessage').html('입력한 비밀번호가 다릅니다.').css('color','red');
//            $('#password').focus();
//            return false;
//        }else{
//			$('#ppMessage').html('입력한 비밀번호가 같습니다.').css('color','green');
//			return true;
//		}
//}

function pwcheck(){
	var password= $('#password').val();
		if(password.length < 4){
            $('#pMessage').html('비밀번호의 길이는 4이상 이여야 합니다.').css('color','red');
            $('#password').focus();
			return false;
        }else if (password.replace(/[~!@#$%^&*()_+|<>?:{}\.]/gi,'').length >= password.length){ 
            $('#pMessage').html('비밀번호에는 특수문자가 들어가야 합니다.').css('color','red');
            $('#password').focus();
			return false;

        }else if ( password.replace(/[a-z.0-9.~!@#$%^&*()_+|<>?:{}\..]/gi,'').length > 0){
            $('#pMessage').html('비밀번호에는 영문자,숫자,특수문자로만 작성해주세요.').css('color','red');
            $('#password').focus();
			return false;
        }else {
			$('#pMessage').html('비밀번호가 정상적으로 입력 되었습니다.').css('color','green');
			return true;
		}
}

function namecheck(){
	var name = $('#name').val();
            if(name.length<2){
                $('#nMessage').html('이름의 길이는 2 이상 이여야 합니다.').css('color','red');
				$('#name').focus();		
                return false;
            }else if(name.replace(/[a-z.ㄱ-ㅎ.가-힣]/gi,'').length > 0){
                $('#nMessage').html('이름은 영문 또는 한글로만 입력해주세요.').css('color','red');
				$('#name').focus();
                return false;
            }else{
				$('#nMessage').html('정상적인 이름이 입력되었습니다.').css('color','green');
				return true;
			}
}

function levcheck(){
	var lev = $('#lev').val();
	console.log(lev);
	if(lev == 'A'){
		$('#lMessage').html('등급은 관리자입니다.').css('color','green');
		return true;
		}else if(lev == 'B'){
		$('#lMessage').html('등급은 나무입니다..').css('color','green');
		return true;
		}else if(lev == 'C'){
		$('#lMessage').html('등급은 잎새입니다..').css('color','green');
		return true;
		}else{
		$('#lMessage').html('등급은 새싹입니다..').css('color','green');
		return true;
		}
}

function birthdcheck(){
	var birthday = $('#birthd').val()
            if(birthday.length != 10 || birthday == ''){
                $('#bMessage').html('길이는 10 이거나 NULL이 아니여야 합니다.').css('color','red');
				$('#birthd').focus();
                return false;
            }else{
				$('#bMessage').html('생일이 정상적으로 입력되었습니다.').css('color','green');
				return true;
			}
}

function pointcheck(){
	var point = $('#point').val();
            if( $.isNumeric(point)==false ||
			 point.replace(/[.]/g,'').length < point.length ){
                $('#poMessage').html('점수는 정수만 입력하세요!!').css('color','red');
				$('#point').focus();
                return false;
            }else {
				$('#poMessage').html('정수가 정상적으로 입력되었습니다.').css('color','green');
				return true;
			}
}

function weightcheck(){
	var weight = $('#weight').val();
			if($.isNumeric(weight)==false 
			|| weight.replace(/[\.]/gi,'').length>=weight.length){
                $('#wMessage').html('몸무게는 실수로만 입력하세요 !').css('color','red');
				$('#weight').focus();
				return false;
            }else if (parseFloat(weight)<20 || parseFloat(weight)>200){
				$('#wMessage').html('weight 의 범위를 벗어납니다. (20~200)').css('color','red');
				$('#weight').focus();
				return false;
			}else{
				$('#wMessage').html('정상적으로 입력되었습니다.').css('color','green');
				return true;
			}
}