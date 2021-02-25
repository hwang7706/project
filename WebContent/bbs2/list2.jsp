<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<link rel="stylesheet" href="/css/shop.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap')
	;

.b {
	white-space: nowrap;
	overflow: hidden;
	width: 200px;
	text-overflow: ellipsis;
}

.saturate {
	position: relative;
}

.saturate1 img {
	width: 216px;
	height: 150px;
}

.absolute {
	position: absolute;
	top: 50px;
	left: 15px;
	font-size: 29px;
	font-family: 'Nanum Pen Script', cursive;
}

.b img {
	width: 50px;
	height: 50px;
}

.saturate img {
	filter: blur(5px);
	width: 216px;
	height: 150px;
}

.float {
	float: right;
	padding: 0;
	font-size: 12px;
}

.margin {
	position: absolute;
}

h1 {
	width: 100%;
	text-align: center;
}
</style>
<div class="main">
<h1>입양목록</h1>
	<div style="width: 1500px;">
		

		<div style="height: 50px; width: 50%; margin-left: 500px;">
			<c:choose>
				<c:when test="${word == 1}">
					<div>총 게시물 수:${totalList}</div>
				</c:when>
				<c:otherwise>
					<div>총 게시물 수:${count}</div>
				</c:otherwise>

			</c:choose>
	</div>

	<div style="width: 1000px; position: absolute; left: 450px">
		<c:choose>

			<c:when test="${count == 0}">
				<div class="byzero">게시물이 없네에에에~~~?</div>
			</c:when>
			<c:otherwise>
				<c:if test="${word != 1}">
					<c:forEach var="m" items="${m}" varStatus="status">
						<div style="float: left; margin: 5px;">
							<a hidden="${m.uid}"></a>
							<div class="saturate1">
								<img src="/upload/${m.file1_thum}">
							</div>
							<div class="b">
								<a href="/bbs2/view2.do?uid=${m.uid}">${m.subject}</a>
								<div class="float">${m.city }</div>
							</div>
							<div>${m.date}</div>
						</div>
					</c:forEach>
					<c:forEach var="v" items="${v}" varStatus="status">
						<c:forEach var="g" items="${g}" varStatus="status">
							<c:if test="${g.uid == v.uid}">
								<div style="float: left; margin: 5px;">
									<a hidden="${v.uid}"></a>
									<div class="saturate">
										<img src="/upload/${v.file1_thum}">
										<div class="absolute">입양 준비중인 아이입니다</div>
									</div>
									<div class="b">
										<a href="/bbs2/View1.do?uid=${v.uid}">${v.subject}</a>
										<div class="float">${v.city}</div>
									</div>
									<div>${v.date}</div>
								</div>
							</c:if>
						</c:forEach>
					</c:forEach>
				</c:if>
				<c:if test="${word == '1'}">
					<c:forEach var="bbsm" items="${bbsm}" varStatus="status">
						<div style="float: left; margin: 5px;">
							<a hidden="${bbsm.uid}"></a>
							<div class="saturate1">
								<img src="/upload/${bbsm.file1_thum}">
							</div>
							<div class="b">
								<a href="/bbs2/view2.do?uid=${bbsm.uid}">${bbsm.subject}</a>
								<div class="float">${bbsm.city }</div>
							</div>
							<div>${bbsm.date}</div>
						</div>
					</c:forEach>
				</c:if>
			</c:otherwise>
		</c:choose>

	</div>
	</div>
	<div class="searchsection">
		<form name="search_ok" method="post" action="/bbs2/bbs_search.do">
			<select name="search">
				<option value="all">전체</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="category">카테고리</option>
			</select> <input type="text" name="word">
			<button>검색</button>
		</form>
	</div>
	
	<div class="write">
		<input type="submit" onclick="location.href='/bbs2/write2.jsp'"
			value="글작성"> <input type="submit"
			onclick="location.href='/bbs2/bbsModify.jsp'" value="글수정">
	</div>


<div style="width: 1500px;">
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

<a style="display: scroll; position: fixed; bottom: 10px; right: 10px;"
	href="#" title=”맨위로">맨 위로</a>

