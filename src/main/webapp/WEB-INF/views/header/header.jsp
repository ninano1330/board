<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HEADER</title>
<style>
span{
	float:right;
}
</style>
</head>
<body>
<span>
	<button id="loginBtn" onclick='openLoginForm();'>로그인</button>
	<button id="joinBtn" onclick='openJoinForm();'>회원가입</button>
	<button id="logoutBtn" onclick='logout();'>로그아웃</button>
	<button id="extendSesBtn" onClick='extendSession();'>세션 연장</button>
	<label id="sessionTime">test</label>
</span>
<script>
function openLoginForm(){
	location.href = '${pageContext.request.contextPath}/login';
}

function logout(){
	location.href = "${pageContext.request.contextPath}/logout";
}

function chkDOM(){
	var loginBtn = document.getElementById("loginBtn");
	var joinBtn = document.getElementById("joinBtn");
	
	var logoutBtn = document.getElementById("logoutBtn");
	var extendSesBtn = document.getElementById("extendSesBtn");
	var sessionTime = document.getElementById("sessionTime");
	
	var boardSessionIdFlag = "${empty boardSessionId}";
	
	if(boardSessionIdFlag == "true"){
// 		loginBtn.style.visibility = "hidden";
// 		joinBtn.style.visibility = "hidden";
		
// 		logoutBtn.style.visibility = "visible";
// 		extendSesBtn.style.visibility = "visible";
// 		sessionTime.style.visibility = "visible";
		
		loginBtn.style.display = "none";
		joinBtn.style.display = "none";
		
		logoutBtn.style.display = "block";
		extendSesBtn.style.display = "block";
		sessionTime.style.display = "block";
	}else{	
// 		logoutBtn.style.visibility = "visible";
// 		joinBtn.style.visibility = "visible";

// 		logoutBtn.style.visibility = "hidden";
// 		extendSesBtn.style.visibility = "hidden";
// 		sessionTime.style.visibility = "hidden";
		
		logoutBtn.style.display = "block";
		joinBtn.style.display = "block";

		logoutBtn.style.display = "none";
		extendSesBtn.style.display = "none";
		sessionTime.style.display = "none";
	}
}
</script>
</body>
</html>