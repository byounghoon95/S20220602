<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/boardDetail.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	
	<div id="blank"></div>
	<div id="blank_5vh"></div>
	
	<form action="reply">
		<input type="hidden" name='boardno' value="${board.boardno }">
		<input type="hidden" name='id' value="${board.id }">
		<input type="hidden" name='boardtitle' value="${board.boardtitle }">
		<input type="hidden" name='ref' value="${board.ref }">
		<input type="hidden" name='ref_step' value="${board.ref_step }">
		<input type="hidden" name='ref_level' value="${board.ref_level }">
		<div class="wrap">
			<h4>치즈 일상</h4>
			<hr /><br>
			
			<h6>${board.nickname } <a href="A_Mdetail?id=${board.id}"> (${board.id })  </a></h6>
			<hr><br>
			<p>${board.boardcontent }</p>
			<p id="view">조회&nbsp${board.boardview }</p>
			<hr />
				<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="revise" onclick="history.go(-1)">
					이전</button>
				<button type="button" class="btn btn-warning mx-1" id="delete" 
				        onclick="location.href='A_BoardDeletePro?boardno=${board.boardno}&warno=${warno}'">
					삭제</button>
			</div>
		
		</div>
		<div id="blank"></div>
	</form>
	<div id="blank"></div>
<%@ include file="adminfooter.jsp"%>
</body>
</html>