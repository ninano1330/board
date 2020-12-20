<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<!-- <link rel="stylesheet" href="css/style.css"> -->
<style>
span{
	float:left;
}
.boardTitle{
	width:70%;
}
.boardWriter{
	width:30%;
}
</style>
</head>
<body>
<center><h1>자유게시판</h1></center>
<div id='boardList'>
</div>
<br>
<!-- <button onclick='window.open("/board/login/form.do","loginPopup","width=300,height=200")'>로그인</button>  -->
<button id="loginBtn" onclick='openLoginForm();'>로그인</button>
<!--  <a href="${pageContext.request.contextPath}/board/form.do" style="float: right;">글쓰기</a> -->
<a href="${pageContext.request.contextPath}/boards/form" style="float: right;">글쓰기</a>
<script>
function getBoardList(formData){
	//alert(formData.elements['id'].value);
	//alert(formData.elements['type'].value);
	//var id = formData.elements['id'].value;
	
	// XMLHttpRequest 객체의 생성
	var xmlHttp = new XMLHttpRequest();
	var url = '${pageContext.request.contextPath}/boards/all';
	// 비동기 방식으로 Request를 오픈
	xmlHttp.open('GET',url);

	// Request를 전송
	xmlHttp.send();

	//Event Handler
	xmlHttp.onreadystatechange = function () {
		// 서버 응답 완료 && 정상 응답
	    if (xmlHttp.readyState !== XMLHttpRequest.DONE) return;

	    if (xmlHttp.status === 200) {
		    var obj = JSON.parse(xmlHttp.responseText);
		    var boardAllList = obj.boardAllList;

			drawBoardList(boardAllList);
	    } else {
	      console.log(`[${xhr.status}] : ${xhr.statusText}`);
	    }
	};
}

function drawBoardList(boardAllList){
	var innerHtml = '';
	var boardList = document.getElementById('boardList');
	var contextPath = '${pageContext.request.contextPath}';

	innerHtml += "<div>";
	innerHtml += "<span class='boardTitle'>제 목</span>";
	innerHtml += "<span class='boardWriter'>작 성 자</span>";
	innerHtml += "</div>";
	
	for(var i=0; i<boardAllList.length; i++){
		innerHtml += "<div>";
		innerHtml += "<a href='";
		//innerHtml += contextPath + "/board/detail.do?boardNo=" + boardAllList[i].boardNo;
		innerHtml += contextPath + "/boards/" + boardAllList[i].boardNo;
		innerHtml +="'>";
		innerHtml += "<span class='boardTitle'>";
		innerHtml += boardAllList[i].boardTitle;
		innerHtml += "</span>";
		innerHtml += "</a>";
		innerHtml += "<span class='boardWriter'>";
		//innerHtml += boardAllList[i].boardWriter;
		innerHtml += boardAllList[i].memberDto.memberId;
		innerHtml += "</span>";
		innerHtml += "</div>";
		innerHtml += "<br>";
	}
	console.log(innerHtml);
	console.log(boardList);
	boardList.innerHTML = innerHtml;
}

function openLoginForm(){
	//alert("openLoginForm");
	//window.open('/board/login');
	location.href = '${pageContext.request.contextPath}/login';
}

function logout(){
	location.href = "${pageContext.request.contextPath}/logout";
}

function chkDOM(){
	var loginBtn = document.getElementById("loginBtn");
	var boardSessionId = "${boardSessionId}";
	
	if("${not empty boardSessionId}"){
		loginBtn.setAttribute("onclick", "logout();");
		loginBtn.innerText = "로그아웃";
	}else{
		//console.log("no login");
		loginBtn.setAttribute("onclick", "openLoginForm();");
		loginBtn.innerText = "로그인";
	}
}

window.onload = function(){
	chkDOM();
	getBoardList();
}
</script>
</body>
</html>