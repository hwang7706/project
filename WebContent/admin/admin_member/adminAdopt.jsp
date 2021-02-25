<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<link rel="stylesheet" href="/css/mypage.css?after">	

	<div id="main">
	<c:forEach var="adopt" items="${h}" varStatus="status">
			<div style="float: left; margin: 5px;">
				<a hidden="${adopt.uid}"></a>
				<div class="saturate">
					<img style="width: 216px; height: 150px"
						src="/upload/${adopt.file1_thum}">
				</div>
				<div class="b">
					<a href="/adminAdoptview.do?uid=${adopt.uid}">${adopt.subject}</a>
				</div>
				<div>${adopt.date}</div>
			</div>
		</c:forEach>
	</div>
