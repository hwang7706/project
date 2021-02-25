<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp" %>

<style>

	div{
		border:1px solid black;
	}
		.b {
  white-space: nowrap; 
  overflow: hidden;
  width:120px;
  text-overflow: ellipsis; 
  border: 1px solid #000000;
}

</style>
<div style="width: 100%;">
	<div style="width: 954px;height: 440px; background-color: #f9f3e1; margin-left: 284px;"></div>
	<div style="height: 50px; width:50%; margin-left: 284px;">
		<div>total:${count }</div>
		<div style="float: left;">NO.</div>
		<div style="float: left;">제목</div>
		<div style="float: left;">날자</div>	
	</div>
</div>

<div style="width: 100%; height: 1050px;">
	<div  style="width: 50%; margin-left: 284px;" >
<c:forEach var="list" items="${v}">
	<div style="float: left; margin: 5px ">
		<div style="width: 216px; height: 150px;"></div>
		<div class="b">${list.subject}</div>
		<div>${list.date}</div>
	</div>
</c:forEach>
	</div>
</div>
<div style="width: 100%;">
	<div>
		<div>
			<div style="width: 50%;  margin-left: 284px; text-align: center;">
			<c:forEach begin="${pageNum}" end="${lastList}" step="1" var="i">
				<a href="/bbs/list.do?page=${pageNum}">
				${i}
				</a>
			</c:forEach>
			</div>
		</div>
		<div style="width: 50%; margin-left: 284px; right: 0px;">
		<input type="submit" onclick="location.href='/bbs/write.jsp'" value="글작성">
		</div>
	</div>
</div>

<div style="height: 50px;"></div>