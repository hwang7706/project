<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@include file="/include/header.jsp" %>
<style>
.file1_class{
	width:150px;
}
</style>
	<!-- 게시판 -->
	<div class="container" align="center">
		<div class="row">
			<form method="post" action="wirteAction2.do" enctype="multipart/form-data">
			<input type="hidden" name="id" value="<%=session_id %>">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 20px;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>subject | <input type="text" class="form-control" placeholder="글 제목" name="subject" maxlength="50"/></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="content" style="width:400px; height: 350px;"></textarea></td>
						</tr>
					</tbody>
					<tbody>
						<tr>
							<td class="file1_class"><input type="hidden" name="<%=session_id %>">
							첨부파일 | <input type="file" name="file1"></td>
							<td>지역:
							<select name="city">
								<option value="서울">서울</option>
								<option value="울산">울산</option>
								<option value="대구">대구</option>
								<option value="부산">부산</option>
								<option value="인천">인천</option>
								<option value="광주">광주</option>
								<option value="제주">제주</option>
								<option value="LA">LA</option>
								<option value="캐리비안의 해적">캐리비안의 해적</option>
							</select>
							
						
							</td>
						</tr>
					</tbody>
				</table>	
				<input type="submit" value="글쓰기" />
			</form>
		</div>
	</div>