<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<script type="text/javascript" src="/js/memberInsert.js"></script>
<script type="text/javascript" src="https://nsp.pay.naver.com/sdk/js/naverpay.min.js"></script>

<body>
	<form name="payment" action="/cart/cartpay.jsp" method="post" onsubmit="return send(this)">

		<div>
			<table style="text-align: center; width: 100%;">
				<tr align="center" style="width: 50%;">
					<td colspan="1"><%=session_name%>님의 구매하실 상품</td>
				</tr>
				<c:forEach var="cm" items="${ac}">
					<tr align="center" style="width: 50%;">
						<td colspan="2">상품이미지</td>
						<td>상품명 : ${cm.product_name}</td>
						<td><input type="hidden" name="product_id[]" value="${cm.product_id}"></td>
						<td>상품 가격 : ${cm.price}</td>
						<td>상품 선택 수량 : ${cm.amount}</td>
						<td>가격 :${cm.money}</td>
					</tr>
				</c:forEach>
				<tr align="center" style="width: 50%;">
					<td colspan="6">결제가격 :<input name="${total}" value="${total}"></td>
				</tr>
				<tr>
					<td>이름: <input id="name" name="name"></td>
					<td>이메일:<input id="email" name="email"></td>
					<td>tel:<input id="tel" name="tel"></td>
					<td>address: <input id="address" name="address"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="total" value="${total}"></td>
				</tr>
				<tr>
					<td><input type="submit" value="결제하기" onclick="document.min=this.value">
					<input type="reset" value="취소하기"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>