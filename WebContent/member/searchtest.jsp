<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="board-search" method="post">
    <select name="searchCategory">
        <option value="1">작성자</option>
        <option value="2">글제목</option>
        <option value="3">글제목 + 내용</option>
    </select>
    <input type="text" name="searchKeyword" 
        placeholder="키워드" required />
    <input type="submit" value="검색" />
</form>
</body>
</html>