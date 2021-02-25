<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/admin/include/header.jsp" %>

<table border=1>
	<tr>
		<td colspan=9 align=center><b>회원목록</b></td>
	</tr>
	<tr>
		<td>No</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>전화번호</td>
		<td>주소</td>
		<td>성별</td>
		<td>생일</td>
		<td>메일</td>
		<td>권한</td>
		<td>수정/삭제</td>
	</tr>
	<c:forEach var="list" items="${v}">
	<tr>
		<td>${number }</td>
		<td>${list.id }</td>
		<td>${list.pass }</td>
		<td>${list.name }</td>
		<td>${list.tel }</td>
		<td>${list.addr }&nbsp ${list.addr2 }&nbsp ${list.addr3 }&nbsp ${list.addr4 }</td>
		<td>${list.gender }</td>
		<td>${list.birtday }</td>
		<td>${list.mail }</td>
		<td>${list.level }</td>
		<td>
			<a href="/admin/admin_member/adminMemberModify.do?id=${list.id}">[수정]</a>
			<a href="/admin/admin_member/admin_memberdelete.do?id=${list.id}">[삭제]</a>
		</td>
	</tr>
	</c:forEach>
</table>
<%@include file="/admin/include/footer.jsp" %>