<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>${requestScope.id } 회원님의 비밀번호는 ${requestScope.pass }입니다</div>
		<div><button onclick = "location.href = '/member/login.jsp' ">로그인 하기</button></div>
		<div><button onclick = "location.href = '/member/idPass.jsp' ">아이디 찾기</button></div>
	</div>
</body>
</html>