<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/adminNoticeWriteForm.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>
	
	<form action="adminCatWrite" method="post">
	<div class="wrap">
		<h4>
			<i class="fa-solid fa-cart-shopping icon_prf icon_mycart"></i>&nbsp카테고리등록   
		</h4>
		<hr />
		
				<select id="category_input" name="bcd" required="required">
	             <option value="" selected disabled hidden>카테고리분류를 선택해주세요.</option>
	             <c:forEach var="common" items="${adminCatList }" >
	              <option value="${common.bcd}">${common.content}</option>
	             </c:forEach>
      			</select> 
			<hr />
			<input type="text" id="title_input" name="content" placeholder="카테고리이름"" />
			<br>
			<div id="reg_btn" class="d-flex justify-content-center">
				<button type="button" class="btn btn-gray mx-1"
					onclick="history.go(-1)">뒤로가기</button>
				<button type="submit" class="btn btn-blue mx-1">카테고리등록</button>
			</div>
	</div>
	</form>
	<div id="blank"></div>
	<%@ include file="adminfooter.jsp"%>
</body>
</html>