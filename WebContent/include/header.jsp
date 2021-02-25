<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    
    String session_id = (String)session.getAttribute("id");
    Integer session_level = (Integer)session.getAttribute("level");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new Friend</title>
<link rel="stylesheet" href="/css/header.css?after">
<link rel="stylesheet" href="/css/menu.css?after">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>

<div class="divparent">
	<div class="LogoMenu">
		<div class="memberM">
			<a href="/">Home |</a>
			<%if(session_id == null){ %>
			<a href="/member/join.jsp">Sign up |</a> <a href='/member/login.jsp' onclick="window.open(this.href,'login','width=450px,height=450px');return false;">Login</a>
			<%}else if(session_level == 3){ %>
			<a href="/admin/admin.jsp">Admin |</a> <a href="/member/logout.do">logout</a>
			<%}else{ %>
			<a href="/member/mypage.jsp">Mypage |</a>
			<a href="/cart/cartList.do?id=<%=session_id%>"><img style="width: 20px;height: 20px;" src="/img/cart.png">    |</a>
			<a href="/member/logout.do">Logout</a>
			<%} %>
		</div>
		
		<a href="/"><img src="/img/icons9.png" width="80px" height="80px"
			style="text-align: left"></a>
		<ul class="nav">
			<li><a href="/member/aboutUs.jsp">About us</a></li>
			<li><a href="/product/productList.do">Shop</a>
				
			<li><a href="#">Data</a></li>
			<li><a href="/bbs2/list2.do">Adopt</a>
				
		</ul>
		<div class="headercat">
			<img src="/img/fluffy_cat.png">
		</div>
	</div>
</div>		