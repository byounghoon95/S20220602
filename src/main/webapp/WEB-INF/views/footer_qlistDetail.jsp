<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

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
</head>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="reply">
		<input type="hidden" name='boardno' value="${footer_qlist.boardno }">
		<input type="hidden" name='id' value="${footer_qlist.id }">
		<input type="hidden" name='boardtitle' value="${footer_qlist.boardtitle }">

		<div class="wrap">
			<h4>자주묻는질문</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="delete" onclick='history.go(-1)'>목록</button>
			</div>
			<h6>${qlist.nickname }</h6>
			<hr><br>
			<p>${qlist.boardcontent }</p>
			<hr />
		
		</div>
		<div id="blank"></div>
		
	</form>
	<div id="blank"></div>
<%@ include file="footer.jsp"%>
</body>
</html>