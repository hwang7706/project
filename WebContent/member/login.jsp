<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/css/login.css">
<%@page import="java.sql.*"%>

<script>
	function send(){
		var lo = login_ok;
	}
</script>
<form name="login_ok" action="login_ok.do" method="post">	
	<div align="center" class="join-font">
		<span>Login</span>
	</div>
	<div class="jb-table">
		<div class="jb-table-row">
			<span class="jb-table-cell">ID</span>
			<span class="jb-table-cell"><input name="id"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">PASS</span>
			<span class="jb-table-cell"><input type="password" name="pass"></span>
		</div>
	</div>
	<div>
	<div class="join-btn">
		<input style="font-size: 13px; width: 60px;" type="submit" value="로그인">
			<input style="font-size: 13px; width: 60px;" type="button" value="회원가입" onclick="send()">
			
			<a href="/member/idPass.jsp">아이디</a>
			<a href="/member/passOk.jsp">| 비밀번호 찾기</a>
		</div>
	</div>
</form>
