<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN FORM</title>
<style>
</style>
</head>
<jsp:include page="/WEB-INF/views/header/header.jsp"/>
<body>
<form class="joinForm" action='${pageContext.request.contextPath }/members/join' method="post">
	아이디 : <input type="text" id="memberId" name="memberId" /> <br>
	비밀번호 : <input type="password" id="memberPw" name="memberPw"/> <br>
	이름 : <input type="text" id="memberName" name="memberName"/> <br>
	연락처 : <input type="text" id="memberPhone" name="memberPhone"/> <br>
	이메일 : <input type="text" id="memberEmail" name="memberEmail"/> @ 
	<select id="emailDomain" name="emailDomain">
		<option value="gmail.com">gmail.com</option>
		<option value="naver.com">naver.com</option>
	</select>
	<br>
	<input type="submit" value="가입" />
</form>
</body>
</html>