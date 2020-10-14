<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/write.do" method="post">
	제목 : <input type="text" name="boardTitle"> <br>
	내용 : <input type="text" name="boardContent"> <br>
	<input type="submit" value="글쓰기" />
</form>

</body>
</html>