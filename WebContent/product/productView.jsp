<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%
	int product_id = Integer.parseInt(request.getParameter("uid"));
%>
<body>
	<div class="container" align="center">
		<div class="row">
			<form name="cartin" action="/cart/cartin.do" method="post">
			<input type="hidden" name="product_id" value="<%=product_id %>">
			<input type="hidden" name="session_id" value="<%=session_id %>">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 20px;">product_name: ${list.product_name}
							<input type="hidden" name="product_name" value="${list.product_name}">
							</th>
						</tr>
						<tr>
							<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 18px;">${list.date}</th>
						</tr>
						<tr>
							<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 18px;">${list.price}
							<input type="hidden" name="price" value="${list.price}">
							수량 : <input type="number" name="amount" ><input type="submit" name="cart" value="add to cart">
							</th>
						</tr>
							<tr>
						<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 18px;">

							카테고리 :${list.category } 
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 600px; height: 350px;">${list.description}</td>
						</tr>
					</tbody>
					<tbody>
					
						<tr>
							<td><img src="/upload/${list.file1}"></td>
						</tr>
					</tbody>
				</table>
			</form>
			
			<div style="border: 1px solid; width: 600px; padding: 5px;">
				<form name="form1" action="/bbs2/comment2.do?product_id=<%=product_id %>" method="post">
					<input type="hidden" name="benum" value="uid"/>
					<textarea name="rememo" rows="3" cols="60" maxlength="500" placeholder="댓글을 달아주세요."></textarea>
					<input type="submit" value="글쓰기">
				</form>
	
				<c:set var="uid" value="<%=product_id%>"/>
				<c:forEach var="re" items="${reply}">
        		작성자:${re.rewriter} 작성일:${re.redate}
        		<a href="/product/productdeleteComment.do?reno=${re.reno}&product_id=<%=product_id %>" style="cursor: pointer;">삭제</a>
        		<a href="/product/productreplySave.do?reno=${re.reno}&product_id=<%=product_id%>">수정</a>
        		<a href="/product/porductreplyre.do?reno=${re.reno}&product_id=<%=product_id%>">댓글</a>
        		<div id="reply<c:out value="${re.reno}"/>">${re.rememo}</div>
        		<br/>
        		
        		<c:if test="${re.reno==reno&&update==0}">
        		<div id="replyDiv" style="width: 99%;">
    				<form name="form2" action="/product/replyreupdate.do?reno=${reno}&product_id=<%=product_id %>" method="post">
	      				<input type="hidden" value="${re.brdno}" name="brdno">
	       				<input type="hidden" value="${re.reno}" name="reno">
						<textarea name="rememo" rows="3" cols="60" maxlength="500">${re.rememo}</textarea>
	        			<input type="submit" value="저장">
	        			<a href="/product/productView.do?product_id=<%=product_id%>">취소</a>
	    			</form>
				</div>
        		</c:if>
        		
        		<c:if test="${re.reno==reno&&up==1}">
    				<form name="form1" action="/product/replyreupdate.do?product_id=<%=product_id %>" method="post">
					<input type="hidden" name="brdno" value="uid"/>
					작성자:<input name="rewriter" type="hidden" size="20" maxlength="20" value="<%=session_id%>">
					<%=session_id %><br/>
					<textarea name="rememo" rows="3" cols="60" maxlength="500" placeholder="댓글을 달아주세요."></textarea>
					<input type="submit" value="글쓰기">
					<a href="/product/productView.do?product_id=<%=product_id%>">취소</a>
					</form>
        		</c:if>
				</c:forEach>
        		
				
			</div>
		</div>
	</div>
</body>
</html>