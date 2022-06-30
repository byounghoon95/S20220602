<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- header -->
<c:choose>
<c:when test="${id == null}">
	<%@ include file="header.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="header_mem.jsp"%>
</c:otherwise>
</c:choose>

<link href="css/boardDetail.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="reply">
		<input type="hidden" name='boardno' value="${footer_notice.boardno }">
		<input type="hidden" name='id' value="${footer_notice.id }">
		<input type="hidden" name='boardtitle' value="${footer_notice.boardtitle }">

		<div class="wrap">
			<h4>공지사항</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="delete" onclick='history.go(-1)'>목록</button>
			</div>
			<h6>${notice.nickname }</h6>
			<hr><br>
			<p>${notice.boardcontent }</p>
			<hr />

		</div>
		<div id="blank"></div>
		
	</form>
	<div id="blank"></div>
<%@ include file="footer.jsp"%>
</body>
</html>