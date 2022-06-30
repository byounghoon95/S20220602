<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header_mem.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/market.css" rel="stylesheet" />
<link href="css/reservationList.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<div class="col-lg-8 col-md-10 mx-auto"></div>
	<div id="blank"></div>
	<!-- ======= Frequenty Asked Questions Section ======= -->
	<div class="wrap">
		<div class="container">
			<section class="faq">
				<div class="container">
					<span class="mypage_title"><i class="fa-solid fa-cart-shopping icon_prf"></i>
						<h4>예약 내역</h4>
					</span>
					<hr /><br><br>
					
			
					<!-- 예약내역 -->
						<div class="container">
								<div class="mypage_itembox">
									<ul class="faq-list">
										<c:forEach var="itemList" items="${reservationList }">
											<li>
											  <a class="item_detail" href="#">
												<div class="card item" style="width: 18rem;">
										          <!-- <img src="images/cheese.png" class="card-img-top" alt="..."> -->
										          <img src="${context}/itemImgs/${itemList.itemimg1 }" class="card-img-top" width="286" height="286" >
										          <div class="card-body">
										            <h5 class="card-title"><div class="card-itemTitle">${itemList.itemtitle }</div></h5>
										            <p class="card-text">
										            	<span>${itemList.itemcost }원</span><br>
										            	<span>&nbsp&nbsp ${itemList.content }</span>
										            </p>
										           
										            <div class="item_boxbottom">
										              <a href="reservationDetail?itemno=${itemList.itemno }" class="btn btn-primary itembtn">예약상세정보</a>
										              
										              <div class="board_icon_view d-flex justify-content-start likechat">
										                <i class="fa-solid fa-heart"></i>&nbsp
										                <span id="heart_cnt">${itemList.itemwish }&nbsp&nbsp</span>
										                <i class="fa-solid fa-eye"></i>&nbsp&nbsp
										                <span id="reply_cnt">${itemList.itemview }</span>
										              </div>
										            </div>
										          </div>
										        </div>
										      </a>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							
							
							
							
							
					
					
				</div>
			</section>
		</div>
	</div>
<%@ include file="footer.jsp"%>
</body>
</html>