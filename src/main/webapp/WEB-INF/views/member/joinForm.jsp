<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN FORM</title>
<style>
</style>
</head>
<jsp:include page="/WEB-INF/views/header/header.jsp"/>
<body>
<!-- <form id= "joinForm" class="joinForm" action='${pageContext.request.contextPath }/members/join' method="post" onsubmit="return join();"> -->
<form id= "joinForm" class="joinForm" name="joinForm">
	아이디 : <input type="text" id="memberId" name="memberId" /> <br>
	비밀번호 : <input type="password" id="memberPw" name="memberPw"/> <br>
	이름 : <input type="text" id="memberName" name="memberName"/> <br>
	연락처 : <input type="text" id="memberPhone" name="memberPhone"/> <br>
	이메일 : <input type="text" id="memberEmail" name="memberEmail"/> @ 
	<select id="emailDomain" name="emailDomain">
		<option value="gmail.com">gmail.com</option>
		<option value="naver.com">naver.com</option>
	</select>
	<br>
	<!--  <input type="submit" value="가입" /> -->
</form>
	<button onclick="join();">가입</button>
	<button onclick="formToParams();">가입2</button>
<script>



function join(){
	var form = document.getElementById("joinForm");
	
	
	var formData = new FormData(form);
	var params = formToParams(formData);

	//console.log(params);

	var xmlHttpRequest = new XMLHttpRequest;
	var uri = '${pageContext.request.contextPath }/members/join';

	xmlHttpRequest.open("POST", uri);
	xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xmlHttpRequest.send(params);

	xmlHttpRequest.onreadystatechange = function(){
		// 서버 응답 완료 && 정상 응답
		console.log("xmlHttpRequest.readyState : " + xmlHttpRequest.readyState);
	    if (xmlHttpRequest.readyState !== XMLHttpRequest.DONE) return;

	    if (xmlHttpRequest.status === 200) {
	    	 //var obj = JSON.parse(xmlHttpRequest.responseText);
	    	 var obj = xmlHttpRequest.responseText;

	    	 console.log("xmlHttpRequest.status : " + xmlHttpRequest.status);
	    	 console.log(obj);
	    	 console.log(obj.codes);
	    	 //console.log(obj.memberDto.codes);
	    } else {
	      console.log("xmlHttpRequest.status : " + xmlHttpRequest.status);
	      console.log(`[${xmlHttpRequest.status}] : ${xmlHttpRequest.statusText}`);
	    }
	};
}

function formToParams(formData){
	//var form = document.getElementById("joinForm");
	//var formData = new FormData(form);

	var params = "";
	//console.log(formData.getAll());
	for(var key of formData.keys()){
		params += key + "=" + formData.get(key);
		params += "&";
	}

	params = params.slice(0,-1);

	//console.log(params);
	return params;
}

document.addEventListener("DOMContentLoaded", function(){
});
</script>
</body>
</html>