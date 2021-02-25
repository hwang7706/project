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
				<li><a href="/member/orderlist.do?id=<%=session_id %>">주문내역</a></li>
				<li><a href="/bbs2/adoptlist.do?id=<%=session_id%>">입양신청 목록</a></li>
			</ul>
		</nav>
	</div>
	<div id="main">
	<c:forEach var="adopt" items="${h}" varStatus="status">
			<div style="float: left; margin: 5px;">
				<a hidden="${adopt.uid}"></a>
				<div class="saturate">
					<img style="width: 216px; height: 150px"
						src="/upload/${adopt.file1_thum}">
				</div>
				<div class="b">
					<a href="/bbs2/adoptview2.do?uid=${adopt.uid}">${adopt.subject}</a>
				</div>
				<div>${adopt.date}</div>
			</div>
		</c:forEach>
	</div>
</div>

