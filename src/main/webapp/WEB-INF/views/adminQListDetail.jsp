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
		<input type="hidden" name='boardno' value="${adminqlist.boardno }">
		<input type="hidden" name='id' value="${adminqlist.id }"> <input
			type="hidden" name='boardtitle' value="${adminqlist.boardtitle }">
		<div class="wrap">
			<h4>자주묻는질문</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="revise"
					onclick="location.href='adminQListUpdateForm?boardno=${adminqlist.boardno}'">
					수정</button>
				<button type="button" class="btn btn-warning mx-1" id="delete"
					onclick="location.href='adminQListDelete?boardno=${adminqlist.boardno}'">
					삭제</button>
			</div>
			<h6>${adminqlist.nickname }</h6>
			<hr>
			<br>
			<p>${adminqlist.boardcontent }</p>
			<hr />
			<div>
				<button type="button" class="btn btn-warning" id="first_btn"
					onclick="location.href='adminQList'">목록</button>
			</div>
		</div>
		<div id="blank"></div>
	</form>
	<div id="blank"></div>
	<%@ include file="adminfooter.jsp"%>
</body>
</html>