<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD UPDATE FORM</title>
</head>
<jsp:include page="/WEB-INF/views/header/header.jsp"/>
<body>
<!--  <form id="boardForm" action="${pageContext.request.contextPath}/boards/me" method="post"> -->
<form id="boardForm" method="post">
	<input type="hidden" id="boardNo" name="boardNo">
	<input type="hidden" id="mebmerId" name="mebmerId">

	제목 : <input type="text" id="boardTitle"  name="boardTitle"> <br>
	내용 : <input type="text" id="boardContent" name="boardContent"> <br>
	<input type="submit" value="수정" ><input type="reset" value="취소" > <br>
</form>
<script>
function setDOM(){
	var boardNo = "${board.boardNo}";
	var boardTitle = "${board.boardTitle }";
	var boardContent = "${board.boardContent }";
	var memberId = "${board.memberDto.memberId }";
	var memberNo = "${board.memberNo}";
	var uri = "${pageContext.request.contextPath}/boards/me";

// 	console.log(boardNo);
// 	console.log(boardTitle);
// 	console.log(boardContent);
// 	console.log(memberId);
// 	console.log(memberNo);
// 	console.log(contextPath);

	document.getElementById("boardNo").value = boardNo;
	document.getElementById("boardTitle").value = boardTitle;
	document.getElementById("boardContent").value = boardContent;
	document.getElementById("mebmerId").value = memberId;
	document.getElementById("boardForm").action = uri;
}

window.onload = function(){
	setDOM();
}
</script>
</body>
</html>