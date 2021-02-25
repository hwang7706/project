<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>
<link rel="stylesheet" href="/css/join.css">
<%
	String uid = request.getParameter("uid");
%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/js/memberInsert.js"></script>
<script>
function checkagain(){
	if(inset.name.value == ""){
		alert("이름을 입력하여 주십시요.");
		inset.name.focus();
		return;
	}
	if(inset.tel.value == ""){
		alert("전화번호를 입력하여 주십시요.");
		inset.tel.focus();
		return;
	}
	if(inset.addr.value == ""){
		alert("주소를 입력하여 주십시요.");
		inset.addr.focus();
		return;
	}
	if(inset.addr2.value == ""){
		alert("주소를 입력하여 주십시요.");
		inset.addr2.focus();
		return;
	}
	if(inset.addr3.value == ""){
		alert("주소를 입력하여 주십시요.");
		inset.addr3.focus();
		return;
	}
	if(inset.addr4.value == ""){
		alert("주소를 입력하여 주십시요.");
		inset.addr4.focus();
		return;
	}
	inset.submit();
}
</script>

<form name="inset" action="/bbs2/adopt.do?uid=<%=uid %>" method="post">
	<div align="center">
		<span class="join-font"><h2>입양신청서</h2></span>
	</div>
	<div class="jb-table">
	
	<div class="jb-table-row">
		<span class="jb-table-cell">입양신청자 이름</span>
		<span class="jb-table-cell"><input name="name"></span>
	</div>
	
	<div class="jb-table-row">
		<span class="jb-table-cell">전화번호</span>
		<span class="jb-table-cell"><input name="tel"></span>
	</div>
	<div class="jb-table-row">
		<span class="jb-table-cell">입양 후 다짐</span>
		<span class="jb-table-cell"><input type="textarea" id="content" name="content" placeholder="각오를 들어봅시다"></span>
	</div>
	<div class="jb-table-row">
		<span class="jb-table-cell"><input type="hidden" name="address"></span>
		<span class="jb-table-cell"><input type="text" id="sample6_postcode" name="addr" style="width: 60px;">
			<span onclick="sample6_execDaumPostcode()" style="cursor: pointer;">주소보기</span>
		</span>
	</div>
	<div class="jb-table-row">
		<span class="jb-table-cell">주소</span>
		<span class="jb-table-cell"><input type="text" id="sample6_address" name="addr2" placeholder="주소"></span>
	</div>
	<div class="jb-table-row">
	<span class="jb-table-cell"><input type="hidden" name="address2"></span>
		<span class="jb-table-cell"><input type="text" id="sample6_detailAddress" name="addr3" placeholder="상세주소"style="width:90px;">
		<input type="text" id="sample6_extraAddress" name="addr4" placeholder="참고항목" style="width: 60px;"></span>
	</div>
	<div>
		<span class="join-btn"><input style="font-size: 18px; width: 100px;" type="button" value="입양하기!!" onclick="checkagain()"></span>
	</div>
	</div>
</form>