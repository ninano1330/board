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
<table border='1'>
	<tr>
		<td width='10%'>제목</td>
		<td id='boardTitle' width='90%'></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td id='mebmerId'></td>
	</tr>
	<tr>
		<td>내용</td>
		<td id='boardContent'></td>
	</tr>
</table>
<div id='btnDiv'>
	<button onclick='updateBoard()'>수정</button>
	<button onclick='deleteBoard()'>삭제</button>
</div>
<script>
window.onload = function(){
	var boardTitle = "${board.boardTitle }";
	var boardContent = "${board.boardContent }";
	var memberId = "${board.memberDto.memberId }";
	var boardWriter = "${board.boardWriter}";

	//session
	var memberNo = "${boardSessionId.memberNo}";

// 	console.log(boardWriter);
// 	console.log(memberNo);
	
	var titleTd = document.getElementById("boardTitle");
	var idTd = document.getElementById("mebmerId");
	var contentTd = document.getElementById("boardContent");

	titleTd.innerHTML = boardTitle;
	idTd.innerHTML = memberId;
	contentTd.innerHTML = boardContent;

	if(boardWriter == memberNo){
		var btnDiv = document.getElementById("btnDiv");
// 		btnDiv.innerHTML = "<button onclick='updateBoard()'>수정</button>" 
//			+ "<button onclick='deleteBoard()'>삭제</button>";
	}
}

function updateBoard(){
	console.log("updateBoard");
	
	var boardNo = "${board.boardNo }";
	var url = "${pageContext.request.contextPath}" + "/board/update.do?boardNo=" + boardNo;

	console.log(boardNo);
	console.log(url);

	var xMLHttpRequest = new XMLHttpRequest();

	xMLHttpRequest.open("GET",url,false);
	xMLHttpRequest.send();
}

function deleteBoard(){
	console.log("deleteBoard");
	
	var boardNo = "${board.boardNo }";
	var url = "${pageContext.request.contextPath}" + "/board/delete.do?boardNo=" + boardNo;

	var xMLHttpRequest = new XMLHttpRequest();

	xMLHttpRequest.open("GET",url,false);
	xMLHttpRequest.send();
}

</script>
</body>
</html>