<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypageBank.css" rel="stylesheet" />
<title>Cheese Market</title>
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
					
					<div class="bank_box">
						<div class="bank_left">
							${nickname }님의 치즈마켓 이용 현황입니다<br><br><br>
							<div class="bankrow"><div class="banklist">총 판매건수</div><div class="bankresult">${totalSellCount }	&nbsp</div>건</div>
							<div class="bankrow"><div class="banklist">총 판매금액</div><div class="bankresult"><fmt:formatNumber value="${totalSellCost}" pattern="#,###"/>&nbsp</div>원</div>
							
						</div>
						<div class="bank_right">
							<img id="character" alt="images/character.png" src="images/character.png">
						</div>
					</div>
					
					
				</div>
			</section>
		</div>
	</div>
	<!-- End Frequenty Asked Questions Section -->
<%@ include file="footer.jsp" %>
</body>
</html>