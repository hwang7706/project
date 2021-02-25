<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>
<form name="idsearch" action="id_search_ok.do" method="post">
	<div align="center">
		<div align="center">ID/PASS 찾기</div>
		<div>name: <input name="name"></div>
		<div>mail: <input name="mail"></div>
		<div><button onclick="idok()">ID 찾기</button></div>
	</div>
</form>

<%@include file="/include/footer.jsp" %>