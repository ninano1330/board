<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail</title>
</head>
<body>
<form id="boardForm" method="post">
	<input type="hidden" id="boardNo" name="boardNo">
	<input type="hidden" id="boardTitle" name="boardTitle">
	<input type="hidden" id="memberId" name="memberId">
	<input type="hidden" id="boardContent" name="boardContent">
	
	<table border='1'> 		
		<tr>
			<td width='10%'>제목</td>
			<td id='boardTitleTd' width='90%'></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td id='memberIdTd'></td>
		</tr>
		<tr>
			<td>내용</td>
			<td id='boardContentTd'></td>
		</tr>
	</table>
</form>
<div id='btnDiv'></div>
<script>
function updateBoard(){
	var uri = "${pageContext.request.contextPath}/boards/me/form";
	document.getElementById("boardForm").action = uri;

	document.getElementById("boardForm").submit();	
}

function deleteBoard(){
	var boardNo = document.getElementById("boardNo").value;
	var uri = "${pageContext.request.contextPath}/boards/me/"+boardNo;
	document.getElementById("boardForm").action = uri;

	document.getElementById("boardForm").submit();	
}

function setDOM(){
	var boardNo = "${board.boardNo}";
	var boardTitle = "${board.boardTitle }";
	var boardContent = "${board.boardContent }";
	var memberId = "${board.memberDto.memberId }";
	var memberNo = "${board.memberNo}";
	
	//session
	var sessionMemberNo = "${boardSessionId.memberNo}";

	document.getElementById("boardTitleTd").innerHTML = boardTitle;
	document.getElementById("memberIdTd").innerHTML = memberId;
	document.getElementById("boardContentTd").innerHTML = boardContent;

	document.getElementById("boardNo").value = boardNo;
	document.getElementById("boardTitle").value = boardTitle;
	document.getElementById("boardContent").value = boardContent;
	document.getElementById("memberId").value = memberId;

	if(sessionMemberNo == memberNo){
		var btnDiv = document.getElementById("btnDiv");
		btnDiv.innerHTML = "<button onclick='updateBoard()'>수정</button>" 
						+ "<button onclick='deleteBoard()'>삭제</button>";
	}
}

function getRequestInfor(){
	var contextPath = "${pageContext.request.contextPath}";
	var requestURL = "${pageContext.request.requestURL}";
	var requestURI = "${pageContext.request.requestURI}";
	var servletPath = "${pageContext.request.servletPath}";
	var serverName = "${pageContext.request.serverName}";

	console.log("contextPath : " + contextPath);
	console.log("requestURL : " + requestURL);
	console.log("requestURI : " + requestURI);
	console.log("servletPath : " + servletPath);
	console.log("serverName : " + serverName);
}

window.onload = function(){
	setDOM();
}
</script>
</body>
</html>