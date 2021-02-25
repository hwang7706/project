<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<link rel="stylesheet" href="/css/mypage.css?after">
<h1>마이페이지</h1>
<div>
	<div id="menu">
		<nav>
			<ul>
				<li><a href="/member/passCheck.jsp">회원수정</a></li>
				<li><a href="">주문목록</a></li>
				<li><a href="/bbs2/adoptlist.do?id=<%=session_id%>">입양신청 목록</a></li>
			</ul>
		</nav>
	</div>
	<div id="main">
		<form action="/member/passCheck.do" method="post">
			비밀번호를 입력하세요:<input type="password" name="passcheck"> <input type="submit" value="입력">
		</form>
	</div>
</div>