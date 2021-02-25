<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
.category {
	background-color: white;
	width:1920px;
	height:50px;
	position:absolute;
}


.sidebar ul {
	padding: 0px;
}

.main {
	width: 1920px;
	height: 1050px;
	position: absolute;
}

.margin {
	font-size:40px;
	font-family: 'Nanum Pen Script', cursive;
	text-align:center;
}

.searchsection {
	position: absolute;
	bottom: 0px;
}

.write {
	width: 1500px;
	margin-left: 284px;
	bottom: 0px;
	position: absolute;
	bottom: 0px;
}

.b {
	white-space: nowrap;
	overflow: hidden;
	width: 120px;
	text-overflow: ellipsis;
	font-size: 12px;
	padding-bottom: 5px;
}

.price {
	font-size: 17px;
	font-weight: bold;
}

.orgprice {
	text-decoration: line-through;
	font-size: 14px;
}

.originprice {
	font-size: 17px;
	font-weight: bold;
}

.thumbnail {
	position: relative;
	overflow: hidden;
	width: 230px;
	height: 205px;
	
}


.thumbnail-img {
	max-width: 100%;
	height: 205px;
	position:absolute;
	left:4px;
}
.absolute {
	position: absolute;
	top: 0px;
	left: 0px;
	font-size: 19px;
	font-family: 'Nanum Pen Script', cursive;
}
.discount{
	position:absolute;
	top:10px;
	left:0px;
	width:90px;
	border:1px solid #9a9a9a;
	border-top:1px solid black;
	background-color:white;
}
.page{
	position:absolute;
	left:750px;
	bottom:0px;
	width:50%;
}


</style>

<div class="category">
			<div class="margin">
				<div class="">
					<a href="/product/productList.do" style="padding-right:20px; border-right:1px solid black;">All</a>
					<a href="/product/productList.do?search=장난감&word=1" style="padding-right:20px; border-right:1px solid black;">Toy</a>
					<a href="/product/productList.do?search=사료 및 간식&word=1" style="padding-right:20px; border-right:1px solid black;">Food and Snack</a>
					<a href="/product/productList.do?search=핸드메이드 굿즈&word=1" style="padding-right:20px; border-right:1px solid black;">Handmade Goods</a>
					<a href="/product/productList.do?search=화장실&word=1" style="padding-right:20px; border-right:1px solid black;">Toilet</a>
					<a href="/product/productList.do?search=캐리어&word=1">Carrier</a>
				</div>
			</div>
		</div>
		<div align="center">
<c:choose>
	<c:when test="${word == 1}">
		<div>총 상품수:${searchCount}</div>
	</c:when>
	<c:otherwise>
		<div>총 상품수:${count}</div>
	</c:otherwise>
</c:choose>
</div>

	
		<c:choose>
			<c:when test="${searchCount == 0}">
				<div>There's nothing on this category</div>
			</c:when>
			<c:otherwise>
				<c:forEach var="pro" items="${v}" varStatus="status">

					<div style="float: left; margin: 5px;">
						<a hidden="${pro.product_id}"></a>
						<div class="thumbnail">
							<div class="thumbnail-centered">
								<img class="thumbnail-img" src="/upload/${pro.file1_thum}">
								<div class="absolute">
								<c:choose>
									<c:when test="${pro.discount == ''}">
									
									</c:when>
									<c:otherwise>
									<div class="box">
									<div class="discount">${pro.discount}% 할인중!</div>
									</div>
									</c:otherwise>
								</c:choose>
								</div>
							</div>
						</div>
						<div class="b">
							<a href="/product/productView.do?uid=${pro.product_id}">${pro.product_name}</a>
						</div>
						<c:choose>
							<c:when test="${pro.discount == ''}">
								<div class="originprice">
									<fmt:formatNumber value="${pro.price}" pattern="#,###" />
									원
								</div>
							</c:when>
							<c:otherwise>
								<div class="orgprice">
									<fmt:formatNumber value="${pro.price}" pattern="#,###" />
								</div>
								<div class="price">
									<fmt:formatNumber value="${pro.price * (1-pro.discount / 100)}"
										pattern="#,###" />
									원
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
				<c:forEach var="pro" items="${v2}" varStatus="status">
					<div style="float: left; margin: 5px;">
						<a hidden="${pro.product_id}"></a>
						<div style="width: 216px; height: 150px;">
							<img src="/upload/${pro.file1_thum}">
						</div>
						<div class="b">
							<a href="/product/productView.do?uid=${pro.product_id}">${pro.product_name}</a>
							<c:choose>
								<c:when test="${pro.discount == ''}">
									<div class="originprice">
										<fmt:formatNumber value="${pro.price}" pattern="#,###" />
										원
									</div>
								</c:when>
								<c:otherwise>
									<div class="orgprice">
										<fmt:formatNumber value="${pro.price}" pattern="#,###" />
									</div>
									<div class="price">
										<fmt:formatNumber
											value="${pro.price * (1-pro.discount / 100)}" pattern="#,###" />
										원
									</div>
								</c:otherwise>
							</c:choose>
						</div>
						<div>${product.date}</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	
		<div class="page">
		
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<a href="/product/productList.do?pageNum=${i}">[${i}]</a>
			</c:forEach>
			<c:set var="session_id" value="<%=session_id %>"/>
				<c:if test="${session_id == 'admin'}">
		<input type="button"
				onclick="location.href='/product/product_write.jsp?id=<%=session_id%>'"
				value="글작성">
				</c:if>
		</div>