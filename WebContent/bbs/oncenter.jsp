<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<link rel="stylesheet" href="/css/shop.css?after">
<style>
.b {
	white-space: nowrap;
	overflow: hidden;
	width: 120px;
	text-overflow: ellipsis;
}
</style>


<div style="width: 100%;">
	<div
		style="width: 954px; height: 440px; background-color: #f9f3e1; margin-left: 284px;"></div>
	<div style="height: 50px; width: 50%; margin-left: 284px;">
		<div>total:${count }</div>
		<div style="float: left;">NO.</div>
		<div style="float: left;">제목</div>
		<div style="float: left;">날자</div>
	</div>
</div>
<c:forEach var="oncenter" items="${v}" varStatus="status">
	<div style="float: left; margin: 5px;">
		<a hidden="${oncenter.uid}"></a>
		<div style="width: 216px; height: 150px;">
			<img style="width: 216px; height: 150px"
				src="/upload/${oncenter.file1_thum}">
		</div>
		<div class="b">
			<a href="/bbs2/view2.do?uid=${oncenter.uid}">${oncenter.title}</a>
		</div>
		<div>${oncenter.date}</div>
	</div>
</c:forEach>
<div class="sidebar">
	<div class="margin">
		<ul>
			<li><a href="">장난감</a></li>
			<li><a href="">사료 및 간식</a></li>
			<li><a href="">핸드메이드 굿즈</a></li>
			<li><a href="">화장실</a></li>
			<li><a href="">캐리어</a></li>
			<a href=""><img src="/img/sidebar_img.png"
				style="width: 200px; height: 300px;"></a>
		</ul>
	</div>
</div>

</div>
</div>
<form name="search_ok" method="post" action="/bbs2/bbs_search.do">
	<select name="search">
		<option value="all">전체</option>
		<option value="subject">제목</option>
		<option value="content">내용</option>
	</select> <input type="text" name="word">
	<button>검색</button>
</form>
<div style="width: 100%;">
	<div>
		<div>
			<c:if test="${count<0}">
				<%-- <c:if test="${startPage > pageCount }">
			<a href="/bbs2/List2.do?pageNum=${startPage - pageCount }">[이전]</a>
		</c:if> --%>
				<div
					style="width: 50%; margin-left: 283px; text-align: center; right: 0px;">
					<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
						<a href="/bbs2/list2.do?pageNum=${i}">[${i}]</a>
					</c:forEach>
				</div>
				<%-- <c:if test="${endPage < pageCount}">
			<a href="/bbs2/List2.do?pageNum=${startPage + pageCount}">[다음]</a>
		</c:if> --%>
			</c:if>
		</div>
	</div>
</div>


<div style="width: 50%; margin-left: 284px; right: 0px;">
	<input type="submit" onclick="location.href='/bbs2/write2.jsp'"
		value="글작성"> <input type="submit"
		onclick="location.href='/bbs2/bbsModify.jsp'" value="글수정">
</div>