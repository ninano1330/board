<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD FORM</title>
</head>
<jsp:include page="/WEB-INF/views/header/header.jsp"/>
<body>
<!-- <form action="${pageContext.request.contextPath}/board/write.do" method="post"> -->
<form id="boardForm" method="post">
	제목 : <input type="text" name="boardTitle"> <br>
	내용 : <input type="text" name="boardContent"> <br>
	<input type="submit" value="글쓰기" />
</form>
<script>
function setDOM(){
	var uri = "${pageContext.request.contextPath}/boards";
	
	document.getElementById("boardForm").action = uri;
}

window.onload = function(){
	setDOM();
}
</script>
</body>
</html>