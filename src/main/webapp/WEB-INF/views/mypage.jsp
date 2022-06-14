<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypage.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	
	<div class="container mypage_all">
	<h4 class="my_cheese">My 치즈</h4>
		<div class="profile_box">
			<div class="left_prf">
				<img src="images/profile.jpg" class="profile_img" alt="..."><p>
				<button type="button" class="btn btn-warning btn_prf" id="s_btn1" onclick="location.href='/mypagePrfUpdate'">프로필 수정</button>
			</div>
			<div class="right_prf">
				<span class="prf_name">${member.nickname }</span>
				<img src="images/cheese.png" class="cheese_img" alt="..."><br>
				<span class="prf_loc">서울시&nbsp&nbsp ${memberLocName }</span><br>
				나의 치즈 농도&nbsp&nbsp<span class="prf_cheeseper">${member.participation } %</span><br>
				나의 경고 횟수&nbsp&nbsp<span class="prf_warn">${member.warningcnt }</span><br>
				<div class="icon_up">
					<span class="icons_each"><a class="icon_A" href="/mypageWish"><i class="fa-solid fa-heart icon_prf"></i><br>관심목록</a></span>
					<span class="icons_each"><a class="icon_A" href="/mypageDeal"><i class="fa-solid fa-cart-shopping icon_prf icon_mycart"></i><br>구매/판매내역</a></span>
					<span class="icons_each"><a class="icon_A" href="/mypageReservation"><i class="fa-solid fa-clock icon_prf"></i><br>예약내역</a></span>
				</div>
				<div class="icon_down">
					<span class="icons_each"><a class="icon_A" href="/mypageBank"><i class="fa-solid fa-sack-dollar icon_prf"></i><br>&nbsp&nbsp가계부</a></span>
					<span class="icons_each"><a class="icon_A" href="/mypageBoard"><i class="fa-solid fa-note-sticky icon_prf icon_myboard"></i><br>내가 작성한 글</a></span>
					<span class="icons_each"><a class="icon_A" href="/mypageDealComment"><i class="fa-solid fa-envelope icon_prf"></i><br>받은 후기</a></span>
				</div>
			</div>
		</div>
	
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>