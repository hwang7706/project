<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="dao.MemberDAO"/>
<% String id = request.getParameter("id");

boolean b = dao.checkId(id); 

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>id 중복 검사</title>

</head>
<script>
function idCheck(inset){
	if(inset.id.value==""){
		alert("아이디를 입력 후 중복확인 버튼을 눌러주세요.");
		inset.id.focus();
		return;
	}
	window.close();
}
function onClose() {
	
	opener.inset.idCheckResult.value="1";
	
	
	window.close();
}
</script>

<body>


<form name="idCheckForm">
<b><%=id %></b>
<%
	if(b){
%>
		는(은) 이미  사용중인 id 입니다.<p/>

		<a href="#" onclick="idCheck(idCheckForm);" style="cursor: pointer;">확인</a>
		<!-- opener : window.open으로 현재 창을 호출한 부모 페이지 -->
<%
	} else {
%>
		는(은) 사용 가능 합니다.<p/>
		<a href="#" onclick="onClose();" style="cursor: pointer;">사용</a>
<%	} %>
</form>
</body>
</html>