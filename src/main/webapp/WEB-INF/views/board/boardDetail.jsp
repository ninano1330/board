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
<%-- <form action='${pageContext.request.contextPath}/board/update.do' method='get'> --%>
	<table border='1'>
<%-- 		<input type='hidden' name='boardNo' value='${board.boardNo }'> --%>
		<tr>
			<td width='10%'>제목</td>
			<td id='boardTitle' name='boardTitle' width='90%'></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td id='mebmerId' name='mebmerId'></td>
		</tr>
		<tr>
			<td>내용</td>
			<td id='boardContent' name='boardContent'></td>
		</tr>
	</table>
<!-- 	<input type="submit" value="수정"> -->
<!-- </form> -->
<div id='btnDiv'>
	<button onclick='updateBoard()'>수정</button>
	<button onclick='deleteBoard()'>삭제</button>
</div>
<script>
window.onload = function(){
	var boardTitle = "${board.boardTitle }";
	var boardContent = "${board.boardContent }";
	var memberId = "${board.memberDto.memberId }";
	var memberNo = "${board.memberNo}";

	//session
	var sessionMemberNo = "${boardSessionId.memberNo}";

// 	console.log(boardWriter);
// 	console.log(memberNo);
	
	var titleTd = document.getElementById("boardTitle");
	var idTd = document.getElementById("mebmerId");
	var contentTd = document.getElementById("boardContent");

	titleTd.innerHTML = boardTitle;
	idTd.innerHTML = memberId;
	contentTd.innerHTML = boardContent;

	if(sessionMemberNo == memberNo){
		var btnDiv = document.getElementById("btnDiv");
// 		btnDiv.innerHTML = "<button onclick='updateBoard()'>수정</button>" 
//			+ "<button onclick='deleteBoard()'>삭제</button>";
	}
}

function updateBoard(){
	console.log("updateBoard");
	
	var boardNo = "${board.boardNo }";
	var url = "${pageContext.request.contextPath}" + "/board/update.do?boardNo=" + boardNo;

	window.location.href = url;
// 	var xMLHttpRequest = new XMLHttpRequest();

// 	xMLHttpRequest.open("GET",url);
// 	xMLHttpRequest.send();
}

function deleteBoard(){
	console.log("deleteBoard");
	
	var boardNo = "${board.boardNo }";
	var url = "${pageContext.request.contextPath}" + "/board/delete.do?boardNo=" + boardNo;

	window.location.href = url;
// 	var xMLHttpRequest = new XMLHttpRequest();

// 	xMLHttpRequest.open("GET",url);
// 	xMLHttpRequest.send();
}

function test(){
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

test();
</script>
</body>
</html>