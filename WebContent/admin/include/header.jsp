<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%
    String session_id = (String)session.getAttribute("id");
    Integer session_admin = (Integer)session.getAttribute("admin");
    %>
    관리자 페이지
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new Friend</title>
<script src="js/javaScript.js"></script>

<link rel="stylesheet" href="/css/header.css?after">
<link rel="stylesheet" href="/css/menu.css?after">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>

	$(document).ready(function() {

		//상대적인 좌표 값을 반환, .offset()가 반환 하는 객체는 left와 top 속성을 제공

		//top 속성을 이용해서 메뉴의 수직 위치를 구함

   		var menu_offset = $('.LogoMenu').offset();

   		//스크롤 바를 스크롤할 때 매개변수로 전달된 함수를 실행시킴

   		$(window).scroll(function() {

   			//문서의 스크롤바 위치와 메뉴의 수직 위치를 비교해서 

   			//문서의 스크롤바 위치가 메뉴의 수직 위치보다 크면(위치로 표현하면 아래)

     		if ($(document).scrollTop() > menu_offset.top) {

     			//메뉴에 menu-fixed 클래스를 추가해서 메뉴를 고정시킴

       			$('.LogoMenu').addClass('menu-fixed');

     		}else {

     			//메뉴에서 menu-fized 클래스를 제거해서 메뉴를 수직으로 이동할 수 있도록 처리함

       			$('.LogoMenu').removeClass('menu-fixed');

     		}

   		});

 	});

</script>

</head>
<body>
<div class="memberM">

<a href="/AdminAdopt.do">입양신청목록</a>
<a href="/admin/admin_member/adminMember_list.do">회원목록</a>
<a href="/admin/admin_member/adminjoin.jsp">회원가입</a>
<a href="/admin/admin_member/adminManageShop.jsp">상품문의</div>
</div>
	<a href="/"><img src="/img/icons9.png" width="80px" height="80px" style="text-align:left"></a>
<ul class="nav">
    <li>
        <a href="#">소개</a>
    </li>
    <li><a href="#">굿즈샵</a>
    <div>
    <ul>
        <li><a href="/bbs/cat.jsp">고양이 용품</a></li>
        <li><a href="/bbs/dog.jsp">강아지 용품</a></li>
    </ul>
        </div>
    </li>
    <li>
        <a href="#">자료</a>
    </li>
    <li><a href="#">온센터</a></li>
    <li class="nav-search">
        <form action="#">
            <input type="text" placeholder="Search...">
            <input type="submit" value="">
        </form>
    </li>
</ul>
</div>