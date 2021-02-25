<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@include file="/include/header.jsp" %>
	<!-- 게시판 -->
	
<script type="text/javascript">
 function send(){
	 if(post.product_name.value == ""){
			alert("제목을 입력하세요");
			post.product_name.focus();
			return;
		}
		if(post.price.value == ""){
			alert("상품 가격을 입력하세요.");
			post.price.focus();
			return;
		}
		if(post.description.value == ""){
			alert("상품 설명을 입력하세요.");
			post.description.focus();
			return;
		}
		post.submit();
 }
</script>
	<div class="container" align="center">
		<div class="row">
			<form name="post" method="post" action="ProductWrite.do" enctype="multipart/form-data">
				<input type="hidden" name="id">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 20px;">상품게시판 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>제목 | <input type="text" class="form-control" placeholder="상품 이름" name="product_name" maxlength="50"/></td>
						</tr>
						<tr>
							<td>가격 | <input type="text" class="form-control" placeholder="상품가격" name="price"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="상품설명" name="description" style="width:400px; height: 350px;"></textarea></td>
						</tr>
						<tr>
							<td>할인 |<input type="text" class="form-control" placeholder="할인" name="percentage"></td>
						</tr>
					</tbody>
					<tbody>
						<tr>
							<td><input type='file' id='file1' name="file1" multiple /></td>
						</tr>
						<Tr>
							<td>
							카테고리:
							<select name="category">
								<option value="장난감">장난감</option>
								<option value="핸드메이드 굿즈">핸드메이드 굿즈</option>
								<option value="화장실">화장실</option>
								<option value="캐리어">캐리어</option>
								<option value="사료 및 간식">사료 및 간식</option>
							</select>
							</td>
						</Tr>
					</tbody>
				</table>	
				<input type="button" onclick="send()" value="글쓰기" />
			</form>
		</div>
	</div>