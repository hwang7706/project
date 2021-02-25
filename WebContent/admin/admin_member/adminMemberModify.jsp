<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/admin/include/header.jsp" %>

<form action="/admin/admin_member/adminMemberUpdate.do" method="post">
<table>
	<tr>
		<td colspan=2>회원수정 페이지</td>
	</tr>
	<tr>
		<td>id</td>
		<td><input type="text" name="id" value="${bean.id }" readonly></td>
	</tr>
	<tr>
		<td>pass</td>
		<td><input name="pass" type="password" value="${bean.pass }"></td>
	</tr>
	<tr>
		<td>name</td>
		<td><input name="name" type="text" value="${bean.name }"></td>
	</tr>
	<tr>
		<td>telephone</td>
		<td><input name="tel" type="text" value="${bean.tel }"></td>
	</tr>
	<tr>
		<td>address</td>
		<td><input type="text" name="addr" value="${bean.addr }">
		<input type="text" name="addr2" value="${bean.addr2 }">
		<input type="text" name="addr3" value="${bean.addr3 }">
		<input type="text" name="addr4" value="${bean.addr4 }">
		</td>
	</tr>
	<tr>
		<td>mail</td>
		<td><input type="text" name="mail" value="${bean.mail }"></td>
	</tr>
	<tr>
		<td>AccountType</td>
		<td>
		<input type="radio" name="admin" value="1" checked>Personal
		<input type="radio" name="admin" value="2">Company
		</td>
	</tr>
	<tr>
		<td colspan=2><input type="submit" value="회원수정"></td>
	</tr>
</table>
</form>
<%@include file="/admin/include/footer.jsp" %>