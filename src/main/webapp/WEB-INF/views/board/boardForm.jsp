<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Form</title>
</head>
<body>
<!-- <form action="${pageContext.request.contextPath}/board/write.do" method="post"> -->
<form action="${pageContext.request.contextPath}/boards" method="post">
	제목 : <input type="text" name="boardTitle"> <br>
	내용 : <input type="text" name="boardContent"> <br>
	<input type="submit" value="글쓰기" />
</form>

</body>
</html>