<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "../error/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<!-- <form id='form' action="${pageContext.request.contextPath}/login" method="post" > -->
		아이디 : <input type="text" id="memberId"  name="memberId" onkeydown="chkInput(this);"> <br>
		비밀번호 : <input type="password" id="memberPw" name="memberPw" onkeydown="chkInput(this);"> <br>
		<button onclick = "login();">로그인</button>
		<!-- <input type="submit" value="확인"> <input type="reset" value="취소"> -->
	<!--  </form> -->
	<!-- <button onclick="test()">테스트</button> -->
<script>
function chkDOM(){
	var memberId = document.getElementById("memberId");
	var memberPw = document.getElementById("memberPw");

	if(memberId.value == "" || memberId.value == null){
		alert("아이디를 입력해주세요.");
		return false;
	}	

	if(memberPw.value == "" || memberPw.value == null){
		alert("비밀번호를 입력해주세요.");
		return false;
	}

	return true;
}

function chkInput(){
	//Keyup 키보드에서 손을 땟을 때 실행
	//Keydown 키보드를 눌렀을 때 실행, 누르고 있을 때 1번만 실행
	//Keypress 키보드를 눌렀을 때 실행, 누르고 있을 떄 계속 실행됨
	// Ctrl, Alt, Shift 키 등은 keydown에서는 작동하지만 keypress에서 작동하지 않음

	//keyCode ASCII code 값
	//keydown, keyup a=A=65
	//keypress a=97, A=65  Caps Lock 여부 체크, 대소문자 구분을 통한 로직 작성 가능

// 	var keycode = event.keyCode;
// 	console.log("keycode :" + keycode);
	
	//alert(keycode);
}


function login(){
	if(!chkDOM()){
		return false;
	}

	var memberId = document.getElementById("memberId");
	var memberPw = document.getElementById("memberPw");
	
	var url = "${pageContext.request.contextPath}/login";

	var xmlHttpRequest = new XMLHttpRequest();

	//비동기 방식으로 Request를 오픈
	//메소드, URL,(비동기식 여부)
	xmlHttpRequest.open("POST",url);

	//post 전송 시 MIME type 설정
	xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	//request.setRequestHeader("Content-Type", "text/plain;charset=UTF-8"); //요청 본문 일반 텍스트
	
	//post 파라미터
	xmlHttpRequest.send("memberId="+memberId.value+"&memberPw="+memberPw.value);

	// Event Handler
	xmlHttpRequest.onreadystatechange = function(){
		// 서버 응답 완료 && 정상 응답
	    if (xmlHttpRequest.readyState !== XMLHttpRequest.DONE) return;

	    if (xmlHttpRequest.status === 200){
			var result = xmlHttpRequest.responseText;
			//console.log("result : " + result);
			if(result == 1){
				location.href = document.referrer;
				//window.close();
			}else if(result == 0){
				alert("아이디와 비밀번호를 확인해주세요.");
			}
		}else{
			alert("다시 로그인 해주세요.");
		}
	};
}

function test(){
	window.close();
}

window.onload = function(){
	//console.log(document.referrer);
}

</script>
</body>
</html>