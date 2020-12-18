<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "../error/error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<!-- <form action="${pageContext.request.contextPath}/login/login.do" method="post" id='form'> -->
	<form action="${pageContext.request.contextPath}/login" method="post" id='form'>
		아이디 : <input type="text" name="memberId" > <br>
		비밀번호 : <input type="password" name="memberPw"> <br>
		<input type="submit" value="확인"> <input type="reset" value="취소">
		<!-- <button onClick="login()">로그인</button> -->
	</form>
<script>
function login(){
	var url = "${pageContext.request.contextPath}/login/login.do?memberId=ADMIN&memberPw=ADMIN";
// 	var form = document.form;
// 	form.action = url;
// 	form.submit();
	console.log(url);
	var xmlHttpRequest = new XMLHttpRequest();

	// 비동기 방식으로 Request를 오픈
	xmlHttpRequest.open("POST",url);

	// Request 전송
	xmlHttpRequest.send();

	// Event Handler
	xmlHttpRequest.onreadystatechange = function(){
		// 서버 응답 완료 && 정상 응답
	    if (xmlHttpRequest.readyState !== XMLHttpRequest.DONE) return;

	    if (xmlHttpRequest.status === 200){
			var result = xmlHttpRequest.responseText;
			console.log("result : " + result);
		}else{
			alert("다시 로그인 해주세요.");
		}
	};
	
	//self.close();
}
</script>
</body>
</html>