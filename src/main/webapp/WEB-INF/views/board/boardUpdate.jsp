<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/board/update.do" method="post">
	제목 : <input type="text" name="boardTitle" value='${board.boardTitle}'> <br>
	내용 : <input type="text" name="boardContent" value='${board.boardContent}'> <br>
	<input type="hidden" name="boardNo" value='${board.boardNo}'> 
	<input type="submit" value="수정" ><input type="reset" value="취소" >
</form>
<script>
</script>
</body>
</html>