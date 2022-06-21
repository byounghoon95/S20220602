<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypageOther.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	
	<div class="container mypage_all">
	<h4 class="my_cheese">뽀로로님의 치즈</h4>
		<div class="prfother_all">
			<div class="prf_report_div"><a class="prf_report" href="/reportForm"><i class="fa-solid fa-circle-exclamation"></i>신고하기</a></div>
			<div class="profile_box">
				<div class="left_prf">
					<img src="images/profile.jpg" class="profile_img" alt="..."><p>
				</div>
				<div class="right_prf">
					<span class="prf_name">${member.nickname }</span>
					<img src="images/cheese.png" class="cheese_img" alt="..."><br>
					<span class="prf_loc">서울시&nbsp&nbsp ${memberLocName }</span><br>
					나의 치즈 농도&nbsp&nbsp<span class="prf_cheeseper">${member.participation } %</span><br>
					나의 경고 횟수&nbsp&nbsp<span class="prf_warn">${member.warningcnt }</span><br>
					<div class="icon_up">
						<span class="icons_each"><a class="icon_A" href="/mypageOtherDeal"><i class="fa-solid fa-cart-shopping icon_prf"></i><br>판매내역</a></span>
						<span class="icons_each"><a class="icon_A" href="/mypageOtherBoard"><i class="fa-solid fa-note-sticky icon_prf"></i><br>작성한 글</a></span>
						<span class="icons_each"><a class="icon_A" href="/mypageOtherComment"><i class="fa-solid fa-envelope icon_prf"></i><br>받은 후기</a></span>
					</div>
				</div>
			</div>
		</div>
	
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>