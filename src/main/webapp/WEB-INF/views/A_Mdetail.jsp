<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html><head>
<meta charset="UTF-8">

<title>Member Detail</title></head>
<link href="css/boardDetail.css" rel="stylesheet" />
<body>
<div id="blank"></div>
<div class="container">
<div class="wrap">
<h4>회원정보</h4> 
 
 <table class="table">
	<tr><th>아이디</th><td>${member.id}</td></tr>
	<tr><th>이름</th><td>${member.name}</td></tr>
	<tr><th>참여</th><td>${member.participation}</td></tr>
	<tr><th>경고횟수</th><td>${member.warningcnt}</td></tr>
	<tr><th>회원상태</th><td>${member.content }</td></tr>
</table>	
	
		<div id="reg_btn" class="d-flex justify-content-end">
				<!-- <button type="button" class="btn btn-warning mx-1" id="revise" onclick="history.go(-1)">
					이전</button> -->
				<button type="button" class="btn btn-warning mx-1" id="revise" onclick="location.href='A_MupdateForm?id=${member.id}'">
					수정</button>
				<button type="button" class="btn btn-warning mx-1" id="delete" onclick="location.href='delete?id=${member.id}'">
					탈퇴</button>
		</div>
	</div>
</div>
<div id="blank"></div>
<div id="blank"></div>

<%@ include file="adminfooter.jsp" %>
</body>
</html>