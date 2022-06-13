<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypagePrfUpdate.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>

	
	<div class="container mypage_all">
	<h4 class="my_cheese">My 치즈</h4>
		<div class="profile_box">
			
				<div class="left_prf">
					<img src="images/profile.jpg" class="profile_img" alt="..."><p>
					<a class="prfimgUpd_A" href="#">프로필 이미지 수정</a>
				</div>
				
				<div class="right_prf">
					<div class="update_box">
						<span class="prf_name">이치돌 &nbsp&nbsp @cheedolee</span>
						<img src="images/cheese.png" class="cheese_img" alt="..."><p>
						<span class="prfUd_list">닉네임 <input type="text" class="input" name="nickname" required="required"> </span><p>
						<span class="prfUd_list">내 지역 <input type="text" class="input" name="locname" required="required"> </span><p>
						<span class="prfUd_list">email <input type="text" class="input" name="email" required="required"> </span><p>
						<span class="prfUd_list">휴대번호 <input type="text" class="input" name="phone" required="required"> </span><p>
						<span class="prfUd_list">비밀번호 <input type="password" class="input" name="pw" required="required"> </span><p>
						<span class="prfUd_list">비밀번호 확인 <input type="password" class="input" name="pw" required="required"> </span><p>
						<button type="button" class="btn btn-warning btn_prf" id="s_btn1" onclick="location.href='/mypagePrfUpdate'">수정 완료</button>
					</div>
				</div>
				
			
		</div>
	
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>