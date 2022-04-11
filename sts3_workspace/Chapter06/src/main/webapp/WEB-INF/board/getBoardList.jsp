<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>


<body>
<center>
<h1>게시글 목록</h1>
<table th:align="center" border="1" th:cellpadding="0" th:cellspacing="0" th:width="700">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="200">제목</th>
	<th bgcolor="orange" width="150">작성자</th>
	<th bgcolor="orange" width="150">등록일</th>
	<th bgcolor="orange" width="100">조회수</th>
</tr>
<tr th:each="board : ${boardList}">
	<td th:text="${board.seq}">
	<td th:text="${board.title}">
	<td th:text="${board.writer}">
	<td th:text="${board.createDate}">
	<td th:text="${board.cnt}">
</tr>

</table>
<br>
<a th:href="insertBoard">새글 등록 </a>
<br>

</center>
</body>
</html>