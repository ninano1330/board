<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HEADER</title>
<style>
.headerSpan {
	float:right;
}

.logo {
	text-align: center;
	font-size: 40px;
}
</style>
</head>
<body>
<p class="logo"><a href='${pageContext.request.contextPath}/main'>MGComm</a></p>
<span class="headerSpan">
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

function openJoinForm() {
	location.href = '${pageContext.request.contextPath}/members/join';
}

function logout(){
	location.href = "${pageContext.request.contextPath}/logout";
}



function chkHeaderDOM(){
	var loginBtn = document.getElementById("loginBtn");
	var joinBtn = document.getElementById("joinBtn");
	
	var logoutBtn = document.getElementById("logoutBtn");
	var extendSesBtn = document.getElementById("extendSesBtn");
	var sessionTime = document.getElementById("sessionTime");
	
	var hasBoardSessionId = "${not empty boardSessionId}";
	
	if(hasBoardSessionId == "true"){
		loginBtn.style.display = "none";
		joinBtn.style.display = "none";
		
		logoutBtn.style.display = "inline";
		extendSesBtn.style.display = "inline";
		sessionTime.style.display = "inline";
	}else{	
// 		logoutBtn.style.visibility = "visible";
// 		logoutBtn.style.visibility = "hidden";

		
		logoutBtn.style.display = "inline";
		joinBtn.style.display = "inline";

		logoutBtn.style.display = "none";
		extendSesBtn.style.display = "none";
		sessionTime.style.display = "none";
	}
}
</script>
</body>
</html>