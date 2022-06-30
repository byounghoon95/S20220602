<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Amain.css?123" rel="stylesheet" />
<title>Cheese Market Admin</title>
</head>
<body>

   
   <div class="container mypage_all">
      <h4 class="my_cheese">관리자</h4>
      <div class="profile_box">
         <div class="left_prf">
            <img src="images/adm_profile.jpg" class="profile_img" alt="..."><p>
   
         </div>
         
         <div class="right_prf">
            <span class="prf_name">치커리</span>
            <img src="images/cheese.png" class="cheese_img" alt="..."><br>
            
            당신이 있기에 오늘도 치즈 창고가 풍요로워요<br>
            오늘 하루도 화이팅!&nbsp&nbsp<br>
            <div class="icon_up">
				<span class="icons_each">
					<a class="icon_A" href="A_Mlist">
						<i class="fa-regular fa-user icon_prf"></i>
						<p>회원관리</p>
					</a>
				</span>
				<span class="icons_each">
					<a class="icon_A" href="adminCatList">
						<i class="fa-solid fa-cart-shopping icon_prf"></i>
						<p>카테고리관리</p>
					</a>
				</span>
				<span class="icons_each">
					<a class="icon_A" href="adminWarList">
						<i class="fa-solid fa-circle-exclamation icon_prf"></i>
						<p>신고관리</p>
					</a>
				</span>   
            </div>
            <div class="icon_down">
				<span class="icons_each">
					<a class="icon_A" href="adminNotice">
						<i class="fa-regular fa-clipboard icon_prf" ></i>
						<p>공지사항관리</p>
					</a>
				</span>
				<span class="icons_each">
					<a class="icon_A" href="adminList11">
						<i class="fa-regular fa-comments icon_prf"></i>
						<p>1:1문의</p>
					</a>
				</span>
				<span class="icons_each">
					<a class="icon_A" href="adminQList">
						<i class="fa-solid fa-circle-question icon_prf"></i>
						<p>자주묻는 질문</p>
					</a>
				</span>
            </div>
         </div>
      </div>
   
   </div>


<%@ include file="adminfooter.jsp" %>
</body>
</html>