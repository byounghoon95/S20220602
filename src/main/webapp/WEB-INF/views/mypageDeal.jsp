<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypageDeal.css" rel="stylesheet" />
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
						<h4>구매/판매 내역</h4>
					</span>
					<hr /><br><br>
					
				<!-- 구매내역 -->
						<div class="container">
							<h4>구매 내역</h4>
								<div class="mypage_itembox">
									<ul class="faq-list">
										<c:forEach var="buyList" items="${mypageBuyList }">
											<li>
												<div class="card item" style="width: 18rem;">
										          <img src="images/cheese.png" class="card-img-top" alt="...">
										          <div class="card-body">
										            <h5 class="card-title"><div class="card-itemTitle">${buyList.itemtitle }</div></h5>
										            <p class="card-text">
										            	<span>${buyList.itemcost }</span><br>
										            	<span>서울시&nbsp&nbsp ${buyList.content }</span>
										            </p>
										           
										            <div class="item_boxbottom">
										            
										            	<c:choose>
														<c:when test="${buyList.dealcontent == null}">
															<a href="#" class="btn btn-primary itembtn">후기 보내기</a>
														</c:when>
														<c:otherwise>
															<a href="#" class="btn btn-primary itembtn">보낸 후기보기</a>
														</c:otherwise>
														</c:choose>
										            
										            
										              <!-- <a href="#" class="btn btn-primary itembtn">후기 보내기</a> -->
										              
										              <div class="board_icon_view d-flex justify-content-start likechat">
										                <i class="fa-solid fa-heart"></i>&nbsp
										                <span id="heart_cnt">${buyList.itemwish }&nbsp&nbsp</span>
										                <i class="fa-solid fa-eye"></i>&nbsp&nbsp
										                <span id="reply_cnt">${buyList.itemview }</span>
										              </div>
										            </div>
										          </div>
										        </div>
											</li>
										</c:forEach>
									</ul>
								</div>
							</div>
							
					<!-- 판매 내역 -->
						<div class="container">
							<h4>판매 내역</h4>
								<div class="mypage_itembox">
									<ul class="faq-list">
										<c:forEach var="sellList" items="${mypageSellList }">
											<li>
												<div class="card item" style="width: 18rem;">
										          <img src="images/cheese.png" class="card-img-top" alt="...">
										          <div class="card-body">
										            <h5 class="card-title"><div class="card-itemTitle">${sellList.itemtitle }</div></h5>
										            <p class="card-text">
										            	<span>${sellList.itemcost }</span><br>
										            	<span>서울시&nbsp&nbsp ${sellList.content }</span>
										            </p>
										           
										            <div class="item_boxbottom">
										              <a href="#" class="btn btn-primary itembtn">후기 보러가기</a>
										              
										              <div class="board_icon_view d-flex justify-content-start likechat">
										                <i class="fa-solid fa-heart"></i>&nbsp
										                <span id="heart_cnt">${sellList.itemwish }&nbsp&nbsp</span>
										                <i class="fa-solid fa-eye"></i>&nbsp&nbsp
										                <span id="reply_cnt">${sellList.itemview }</span>
										              </div>
										            </div>
										          </div>
										        </div>
											</li>
										</c:forEach>
									</ul>
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