<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/cartList_js.js"></script>
 <%
 	String id = (String)request.getParameter("id");
 %>

<link rel="stylesheet" href="/css/mypage.css?after">	
<h1>마이페이지</h1>
<div>
	<div id="menu">
		<nav>
			<ul>
				<li><a href="/member/passCheck.jsp">회원수정</a></li>
				<li><a href="/cart/cartList.do">장바구니</a></li>
				<li><a href="/bbs2/adoptlist.do?id=<%=session_id%>">입양신청 목록</a></li>
			</ul>
		</nav>
	</div>
	<div id="main">
	<div style="width: 100%;">
	<div style="width: 100%; text-align: center;">
		<div>add to cart</div>
		<div><%=id%>님의 장바구니 입니다. </div>
		
		<form name="checkbox01" action="" method="post" onsubmit="return send(this)">
		
		<table style="width: 100%; text-align: center;">
		
		<tr><td><input type="checkbox"  onclick="if (this.checked) all_checked(true); else all_checked(false);"></td></tr>
		<c:forEach var="list" items="${cart}">
			<tr style="width: 50%; text-align: center;">
				<td><input type="checkbox" name="check[]" value="${list.product_id}"></td>
				<td><input type="hidden" name="${list.product_id}"></td>
				<td><input type="hidden" name="<%=session_id%>"></td>
				<td><input type="hidden" name="hiddenValue" value=""></td>
				<td>상품명: ${list.product_name}</td>
				<td>상품 가격: ${list.price}</td>
				<td>상품 갯수:${list.amount}</td>
				<td>통합가격: ${list.money}</td>
				<td><a href="/cart/cartdelete.do?id=${list.product_id}&uid=<%=session_id%>">삭제</a></td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="9" style="text-align: center;">
			<a href="/cart/cartdeleteAll.do?uid=<%=session_id%>">전체 삭제 |</a>
			<input type="submit" name="btn_submit" value="선택삭제" onclick="document.min=this.value">
			<input type="submit" name="btn_submit" value="선택구매" onclick="document.min=this.value">
			</td>	
		</tr>
		
		</table>
		</form>
		<div></div>
	</div>
</div>
	</div>
</div>
 


</body>
</html>