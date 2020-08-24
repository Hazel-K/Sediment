<%@page import="com.sun.org.apache.xpath.internal.operations.Div"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="blog.hyojin4588.pjt.vo.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
	<style>
		span {
			cursor: pointer;
			margin-right: 10px;
		}
	</style>
</head>
<body>
	<div>${login_user.getUser_nm()}님 환영합니다.</div>
	<div><span onclick="location.href='regmod'">글쓰기</span><span onclick="location.href='logout'">로그아웃</span></div>
	<h1>게시판</h1>
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>게시일</th>
		</tr>
		<c:if test="${empty data}">
			<tr>
				<td colspan=5 style="text-align: center;">작성된 게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach items="${data}" var="item">
			<tr onclick="location.href='detail?i_board=${item.i_board}'">
				<td>${item.i_board}</td>
				<td>${item.u_nm}</td>
				<td>${item.title}</td>
				<td>${item.hits}</td>
				<td>${item.r_dt}</td>
			</tr>
		</c:forEach>
		<!-- jstl1.2 -->
	</table>
</body>
</html>