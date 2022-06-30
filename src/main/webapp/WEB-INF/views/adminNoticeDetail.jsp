<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/adminNoticeDetail.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form>
		<input type="hidden" name='boardno' value="${adminnotice.boardno }">
		<input type="hidden" name='id' value="${adminnotice.id }"> <input
			type="hidden" name='boardtitle' value="${adminnotice.boardtitle }">
		<div class="wrap">
			<h4>공지 사항</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="revise"
					onclick="location.href='adminNoticeUpdateForm?boardno=${adminnotice.boardno}'">
					수정</button>
				<button type="button" class="btn btn-warning mx-1" id="delete"
					onclick="location.href='adminNoticeDelete?boardno=${adminnotice.boardno}'">
					삭제</button>
			</div>
			<h6>${adminnotice.nickname }</h6>
			<hr>
			<br>
			<p>${adminnotice.boardcontent }</p>
			<hr />
			<div>
				<button type="button" class="btn btn-warning" id="first_btn"
					onclick="location.href='adminNotice'">목록</button>
			</div>
		</div>
		<div id="blank"></div>
	</form>
	<div id="blank"></div>
	<%@ include file="adminfooter.jsp"%>
</body>
</html>