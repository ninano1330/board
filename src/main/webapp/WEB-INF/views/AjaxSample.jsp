<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<script>
function drawTodoList(formData){
	//alert(formData.elements['id'].value);
	//alert(formData.elements['type'].value);
	var id = formData.elements['id'].value;
	var type = formData.elements['type'].value;
	var url = '${pageContext.request.contextPath}/todoType?id=' + id + '&type=' + type;
	
	// XMLHttpRequest 객체의 생성
	var xmlHttp = new XMLHttpRequest();

	// 비동기 방식으로 Request를 오픈
	xmlHttp.open('POST',url);

	// Request를 전송
	xmlHttp.send();

	//Event Handler
	xmlHttp.onreadystatechange = function () {
		// 서버 응답 완료 && 정상 응답
	    if (xmlHttp.readyState !== XMLHttpRequest.DONE) return;

	    if (xmlHttp.status === 200) {
	      //console.log(xmlHttp.responseText);
	      //document.getElementById('content').innerHTML = xhr.responseText;
	    	document.getElementById('grid').innerHTML = xmlHttp.responseText;
	    } else {
	      console.log(`[${xhr.status}] : ${xhr.statusText}`);
	    }
	};
}

</script>
</head>
<body>
	<input type="button" value="새로운 TODO 등록" onclick="location.href='${pageContext.request.contextPath}/todoForm';"/>
	
	<div class="grid" id="grid">
		<div class="grid_item first" style="float:left">
			<div>TODO</div>
			<c:forEach var="todoList" items="${todoList}">
				<c:if test= "${todoList.type eq 'TODO' }">
					<!--  <form method="post" action="${pageContext.request.contextPath}/main"> -->
					<form method="post" onsubmit="return drawTodoList(this);">
							<c:out value="${todoList.title}"/><br>
							등록일짜 : <c:out value="${todoList.regdate}" escapeXml="false" /> &nbsp; 
							<c:out value="${todoList.name}" escapeXml="false" />  &nbsp;
							우선순위 <c:out value="${todoList.sequence}" escapeXml="false" />
							<input type="submit" value= "+"/>
							<input type="hidden" name="id" value="<c:out value="${todoList.id}"/>" />
							<input type="hidden" name="type" value="<c:out value="${todoList.type}"/>" />
					</form>
				</c:if>
			</c:forEach>
		</div>
		<div class="grid_item two" style="float:left">
			<div>DOING</div>
			<c:forEach var="todoList" items="${todoList}">
				<c:if test= "${todoList.type eq 'DOING' }">
						<form method="post" onsubmit="return drawTodoList(this);">
								<c:out value="${todoList.title}"/><br>
								등록일짜 : <c:out value="${todoList.regdate}" escapeXml="false" /> &nbsp; 
								<c:out value="${todoList.name}" escapeXml="false" />  &nbsp;
								우선순위 <c:out value="${todoList.sequence}" escapeXml="false" />
								<input type="submit" value= "+"/>
								<input type="hidden" name="id" value="<c:out value="${todoList.id}"/>" />
								<input type="hidden" name="type" value="<c:out value="${todoList.type}"/>" />
						</form>
				</c:if>
			</c:forEach>
		</div>
		<div class="grid_item third" style="float:left">
			<div>DONE</div>
			<c:forEach var="todoList" items="${todoList}">
				<c:if test= "${todoList.type eq 'DONE' }">
						<form method="post" onsubmit="return drawTodoList(this);">
								<c:out value="${todoList.title}"/><br>
								등록일짜 : <c:out value="${todoList.regdate}" escapeXml="false" /> &nbsp; 
								<c:out value="${todoList.name}" escapeXml="false" />  &nbsp;
								우선순위 <c:out value="${todoList.sequence}" escapeXml="false" />
								<input type="hidden" name="id" value="<c:out value="${todoList.id}"/>" />
								<input type="hidden" name="type" value="<c:out value="${todoList.type}"/>" />
						</form>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<br>
</body>
</html>