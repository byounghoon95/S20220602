<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- header -->
<c:choose>
<c:when test="${id == null}">
	<%@ include file="header.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="header_mem.jsp"%>
</c:otherwise>
</c:choose>
<link href="css/mypageOther.css" rel="stylesheet" />
<title>Cheese Market</title>
</head>
<body>
	
	<div class="container mypage_all">
	<h4 class="my_cheese">${member.nickname }님의 치즈</h4>
		<div class="prfother_all">
			<div class="prf_report_div"><a class="prf_report" href="/warningForm?warnid=${member.id }"><i class="fa-solid fa-circle-exclamation"></i>신고하기</a></div>
			<div class="profile_box">
				<div class="left_prf">
					<!-- <img src="images/profile.jpg" class="profile_img" alt="..."><p> -->
					<img src="${context}/itemImgs/${member.userImg }" class="profile_img" width="200" height="200" ><p>
				</div>
				<div class="right_prf">
					<span class="prf_name">${member.nickname }</span>
					<img src="images/cheese.png" class="cheese_img" alt="..."><br>
					<span class="prf_loc">서울시&nbsp&nbsp ${memberLocName }</span><br>
					치즈 농도&nbsp&nbsp<span class="prf_cheeseper">${member.participation } %</span><br>
					경고 횟수&nbsp&nbsp<span class="prf_warn">${member.warningcnt }</span><br>
					<div class="icon_up">
						<span class="icons_each"><a class="icon_A" href="/mypageOtherDeal?id=${member.id }"><i class="fa-solid fa-cart-shopping icon_prf"></i><br>판매내역</a></span>
						<span class="icons_each"><a class="icon_A" href="/mypageOtherBoard?id=${member.id }"><i class="fa-solid fa-note-sticky icon_prf"></i><br>작성한 글</a></span>
						<span class="icons_each"><a class="icon_A" href="/mypageOtherComment?id=${member.id }"><i class="fa-solid fa-envelope icon_prf"></i><br>받은 후기</a></span>
					</div>
				</div>
			</div>
		</div>
	
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>