<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<!-- <link rel="stylesheet" href="css/style.css"> -->
<style>
span{
	float:left;
}
.boardTitle{
	width:70%;
}
.boardWriter{
	width:30%;
}
</style>
</head>
<body>
<center><h1>자유게시판</h1></center>
<div id='boardList'>
</div>
<br>
<!-- <button onclick='window.open("/board/login/form.do","loginPopup","width=300,height=200")'>로그인</button>  -->
<button onclick='open_wnd_check_blockpopup()'>로그인</button>
<a href="${pageContext.request.contextPath}/board/form.do" style="float: right;">글쓰기</a>
<script>
function getBoardList(formData){
	//alert(formData.elements['id'].value);
	//alert(formData.elements['type'].value);
	//var id = formData.elements['id'].value;
	
	// XMLHttpRequest 객체의 생성
	var xmlHttp = new XMLHttpRequest();
	var url = '${pageContext.request.contextPath}/boards';
	// 비동기 방식으로 Request를 오픈
	xmlHttp.open('GET',url);

	// Request를 전송
	xmlHttp.send();

	//Event Handler
	xmlHttp.onreadystatechange = function () {
		// 서버 응답 완료 && 정상 응답
	    if (xmlHttp.readyState !== XMLHttpRequest.DONE) return;

	    if (xmlHttp.status === 200) {
		    var obj = JSON.parse(xmlHttp.responseText);
		    var boardAllList = obj.boardAllList;

			drawBoardList(boardAllList);
	    } else {
	      console.log(`[${xhr.status}] : ${xhr.statusText}`);
	    }
	};
}

function drawBoardList(boardAllList){
	var innerHtml = '';
	var boardList = document.getElementById('boardList');
	var contextPath = '${pageContext.request.contextPath}';

	innerHtml += "<div>";
	innerHtml += "<span class='boardTitle'>제 목</span>";
	innerHtml += "<span class='boardWriter'>작 성 자</span>";
	innerHtml += "</div>";
	
	for(var i=0; i<boardAllList.length; i++){
		innerHtml += "<div>";
		innerHtml += "<a href='";
		innerHtml += contextPath + "/board/detail.do?boardNo=" + boardAllList[i].boardNo;
		innerHtml +="'>";
		innerHtml += "<span class='boardTitle'>";
		innerHtml += boardAllList[i].boardTitle;
		innerHtml += "</span>";
		innerHtml += "</a>";
		innerHtml += "<span class='boardWriter'>";
		//innerHtml += boardAllList[i].boardWriter;
		innerHtml += boardAllList[i].memberDto.memberId;
		innerHtml += "</span>";
		innerHtml += "</div>";
		innerHtml += "<br>";
	}
	console.log(innerHtml);
	console.log(boardList);
	boardList.innerHTML = innerHtml;
}

var goWindows = {};

function open_window(url, name, width, height, feature) {
    var windowX = Math.ceil( (window.screen.width  - width) / 2 );
    var windowY = Math.ceil( (window.screen.height - height) / 2 );
    var specs = feature+",width="+width+",height="+height+",left="+windowX+",top="+windowY;
    var oWnd = goWindows[name];

    if(!oWnd || oWnd.closed) {
        if(true) {
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
	var url = "/board/login/form.do";
	var name= "loginPopup";
	var width = 300;
	var height= 200;
	
    var oWnd = open_wnd(url, name, width, height);
    if (!oWnd) {
		alert("test.");
    }
    return oWnd;
}

// open_wnd_check_blockpopup(
// 		"https://nid.naver.com/nidlogin.login?template=plogin&mode=form&url=http://cafe.naver.com/OpenerRedirect.nhn%3Fopenerurl%3D%252Fzzang9daddy.cafe%253Femail%253D%2526iframe_url%253D%25252FCafeApplyCheck.nhn%25253Fclubid%25253D29328371%252526alreadyMemberPopup%25253Dfalse%252526redirectUrl%25253D"
// 		, "naver_login", 410, 280);

// open_wnd_check_blockpopup(
// 		"https://nid.naver.com/nidlogin.login?template=plogin&mode=form&url=http://cafe.naver.com/OpenerRedirect.nhn%3Fopenerurl%3D%252Fzzang9daddy.cafe%253Femail%253D%2526iframe_url%253D%25252FCafeApplyCheck.nhn%25253Fclubid%25253D29328371%252526alreadyMemberPopup%25253Dfalse%252526redirectUrl%25253D"
// 		, "login", 410, 280);


getBoardList();

</script>
</body>
</html>