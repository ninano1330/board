<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login/login.do" method="post">
		아이디 : <input type="text" name="memberId" > <br>
		비밀번호 : <input type="password" name="memberPw"> <br>
		<input type="submit" value="확인"> <input type="reset" value="취소">
	</form>
<script>
</script>
</body>
</html>