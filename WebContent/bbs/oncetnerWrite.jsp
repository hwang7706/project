<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<div>
<form action="/bbs/oncenterWrite.do" method="post">
	<div>제목:<input type="text" name="title"></div>
	<div>내용:<input type="text" name="content"></div>
	<input type="submit" value="작성하기">
</form>
</div>