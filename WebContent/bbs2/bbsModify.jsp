<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>
<%
int uid = Integer.parseInt(request.getParameter("uid"));
%>
	<!-- 게시판 -->
	<div class="container" align="center">
		<div class="row">
			<form method="post" action="/bbs2/bbsmodify2.do?uid=<%=uid %>" enctype="multipart/form-data">
				<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"	style="background-color: #eeeeee; text-align: center; font-size: 20px;">게시판 글 수정</th>
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
							<td>
							첨부파일 | <input type="file" name="file1"></td>
						</tr>
					</tbody>
				</table>	
				<input type="submit" value="글쓰기" />
			</form>
		</div>
	</div>