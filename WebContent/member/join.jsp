<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<link rel="stylesheet" href="/css/join.css">
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/memberInsert.js"></script>
<script>
	function checkagain() {
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (inset.id.value == "") {
			alert("아이디를 입력하여 주십시요.");
			inset.id.focus();
			return;
		}
		if (inset.pass.value == "") {
			alert("비밀번호를 입력하여 주십시요.");
			inset.pass.focus();
			return;
		}
		if (inset.pass2.value == "") {
			alert("비밀번호확인을 입력하여 주십시요.");
			inset.pass2.focus();
			return;
		}
		if (inset.name.value == "") {
			alert("이름을 입력하여 주십시요.");
			inset.name.focus();
			return;
		}
		if (inset.tel.value == "") {
			alert("전화번호를 입력하여 주십시요.");
			inset.tel.focus();
			return;
		}
		if (inset.addr.value == "") {
			alert("주소를 입력하여 주십시요.");
			inset.addr.focus();
			return;
		}
		if (inset.addr2.value == "") {
			alert("주소를 입력하여 주십시요.");
			inset.addr2.focus();
			return;
		}
		if (inset.addr3.value == "") {
			alert("주소를 입력하여 주십시요.");
			inset.addr3.focus();
			return;
		}
		if (inset.addr4.value == "") {
			alert("주소를 입력하여 주십시요.");
			inset.addr4.focus();
			return;
		}

		if (inset.birtday.value == "") {
			alert("생년월일을 입력하여 주십시요.");
			inset.birtday.focus();
			return;
		}
		if (inset.mail.value == "") {
			alert("이메일을 입력하여 주십시요.");
			inset.mail.focus();
			return;
		}
		if (inset.idCheckResult.value == "0") {
			alert("아이디 중복체크를 해주세요");
			inset.id.focus();
			return;
		}
		inset.submit();
	}
</script>
<form name="inset" action="/member/member_insert.do" method="post">
	<input type="hidden" name="idCheckResult" value="0"> <input
		type="hidden" name="id2" value="">
	<div align="center">
		<span class="join-font"><h2>회원가입</h2></span>
	</div>
	<div class="jb-table">
		<div class="jb-table-row">
			<span class="jb-table-cell">아이디</span> <span class="jb-table-cell">
				<input name="id" style="width: 90px;" onkeyup="idCheckInit(inset)">
				<span id="btnId" onclick="idCheck(inset)"
				style="cursor: pointer; font-size: 12px; color: blue;">중복체크</span>
			</span>

		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">비밀번호</span> <span class="jb-table-cell"><input
				type="password" name="pass" id="pass"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">비밀번호 확인</span> <span
				class="jb-table-cell"><input type="password" name="pass2"
				id="pass2">
			<p id="check" onclick="check_pw()"
					style="cursor: pointer; font-size: 12px; color: blue;">비밀번호 확인</p></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">이름</span> <span class="jb-table-cell"><input
				name="name"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">전화번호</span> <span class="jb-table-cell"><input
				name="tel"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell"><input type="hidden"
				name="address"></span> <span class="jb-table-cell"><input
				type="text" id="sample6_postcode" name="addr" style="width: 60px;">
				<span onclick="sample6_execDaumPostcode()" style="cursor: pointer;">우편번호
					찾기</span> </span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">주소</span> <span class="jb-table-cell"><input
				type="text" id="sample6_address" name="addr2" placeholder="주소"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell"><input type="hidden"
				name="address2"></span> <span class="jb-table-cell"><input
				type="text" id="sample6_detailAddress" name="addr3"
				placeholder="상세주소" style="width: 90px;"> <input type="text"
				id="sample6_extraAddress" name="addr4" placeholder="참고항목"
				style="width: 60px;"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">성별</span> <span class="jb-table-cell">
				<input type="radio" value="female" name="gender">여자 <input
				type="radio" value="male" name="gender" checked="checked">남자
			</span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">생년월일</span> <span class="jb-table-cell"><input
				type="date" name="birtday"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell">이메일</span> <span class="jb-table-cell"><input
				name="mail"></span>
		</div>
		<div class="jb-table-row">
			<span class="jb-table-cell"><input type="radio"
				name="c_member" value="1">개인</span> <span class="jb-table-cell"><input
				type="radio" name="c_member" value="2" checked="checked">기업</span>
		</div>
		<div>
			<span class="join-btn"><input
				style="font-size: 18px; width: 100px; position: absolute; left: 0px;"
				type="button" value="SignUp" onclick="checkagain()"></span>
		</div>
	</div>
</form>
