<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypageBank.css" rel="stylesheet" />
<title>Cheese Bank</title>
</head>
<body>

	<div class="col-lg-8 col-md-10 mx-auto"></div>
	<div id="blank"></div>
	<!-- ======= Frequenty Asked Questions Section ======= -->
	<div class="wrap">
		<div class="container">
			<section class="faq">
				<div class="container">
					<span class="mypage_title"><i class="fa-solid fa-sack-dollar icon_prf"></i><h4>가계부</h4></span>
					<hr /><br><br>
					
					<span class="banklist"><h5>총 판매건수</h5><div class="bankresult">${totalSellCount }	&nbsp&nbsp	건</div></span>
					<span class="banklist"><h5>총 판매금액</h5><div class="bankresult">${totalSellCost }	&nbsp&nbsp	원</div></span>
					
					
				</div>
			</section>
		</div>
	</div>
	<!-- End Frequenty Asked Questions Section -->
<%@ include file="footer.jsp" %>
</body>
</html>