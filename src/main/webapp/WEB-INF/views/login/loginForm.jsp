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
function open_window(url, name, width, height, feature) {
    var windowX = Math.ceil( (window.screen.width  - width) / 2 );
    var windowY = Math.ceil( (window.screen.height - height) / 2 );
    var specs = feature+",width="+width+",height="+height+",left="+windowX+",top="+windowY;
    var oWnd = goWindows[name];

    if(!oWnd || oWnd.closed) {
        if(isIE) {
            oWnd = window.open("", name, specs);
            if (!oWnd) {
                alert("hi");
            } else {
                oWnd.location.href=url;
                goWindows[name] = oWnd;
            }
        } else {
            oWnd = window.open(url, name, specs);
            goWindows[name] = oWnd;
        }
    } else {
        oWnd.location.href = url;
    }
    return oWnd;
}

function open_wnd(url, name, width, height)
{
    var oWnd = open_window(url, name, width, height, "toolbar=0,menubar=0,resizable=yes,scrollbars=no");
    return oWnd;
}

function open_wnd_check_blockpopup(url, name, width, height) {
    var oWnd = open_wnd(url, name, width, height);
    if (!oWnd) {
		alert("test.");
    }
    return oWnd;
}

// open_wnd_check_blockpopup(
// 		"https://nid.naver.com/nidlogin.login?template=plogin&mode=form&url=http://cafe.naver.com/OpenerRedirect.nhn%3Fopenerurl%3D%252Fzzang9daddy.cafe%253Femail%253D%2526iframe_url%253D%25252FCafeApplyCheck.nhn%25253Fclubid%25253D29328371%252526alreadyMemberPopup%25253Dfalse%252526redirectUrl%25253D"
// 		, "naver_login", 410, 280);

open_wnd_check_blockpopup(
		"https://nid.naver.com/nidlogin.login?template=plogin&mode=form&url=http://cafe.naver.com/OpenerRedirect.nhn%3Fopenerurl%3D%252Fzzang9daddy.cafe%253Femail%253D%2526iframe_url%253D%25252FCafeApplyCheck.nhn%25253Fclubid%25253D29328371%252526alreadyMemberPopup%25253Dfalse%252526redirectUrl%25253D"
		, "login", 410, 280);

</script>
</body>
</html>