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
				<li><a href="/member/orderlist.do">주문내역</a></li>
				<li><a href="/bbs2/adoptlist.do?id=<%=session_id%>">입양신청 목록</a></li>
			</ul>
		</nav>
	</div>
	<div id="main">
		<form action="/member/member_update.do" method="post">
<table>
	<tr>
		<td colspan=2>회원수정 페이지</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" value="${modify.id }" readonly></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input name="pass" type="password" value="${modify.pass }"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input name="name" type="text" value="${modify.name }"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input name="tel" type="text" value="${modify.tel }"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="addr" value="${modify.addr }">
		<input type="text" name="addr2" value="${modify.addr2 }">
		<input type="text" name="addr3" value="${modify.addr3 }">
		<input type="text" name="addr4" value="${modify.addr4 }">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="mail" value="${modify.mail }"></td>
	</tr>
	<tr>
		<td colspan=2><input type="submit" value="회원수정"></td>
	</tr>
</table>
</form>
	</div>
</div>


