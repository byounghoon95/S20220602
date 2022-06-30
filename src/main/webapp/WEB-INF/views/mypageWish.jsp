<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypageWish.css" rel="stylesheet" />
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
					<span class="mypage_title"><i class="fa-solid fa-heart icon_prf"></i><h4>관심상품</h4></span>
					<hr /><br><br>
						<div class="container">
							<div class="mypage_itembox">
								<ul class="faq-list">
									<c:forEach var="wList" items="${mypageWishList }">
										<li>
										  <a class="item_detail" href="itemDetail?itemno=${wList.itemno }">
											<div class="card item" style="width: 18rem;">
									          <!-- <img src="images/cheese.png" class="card-img-top" alt="..."> -->
									          <img src="${context}/itemImgs/${wList.itemimg1 }" class="card-img-top" width="286" height="286" >
									          <div class="card-body">
									            <h5 class="card-title"><div class="card-itemTitle">${wList.itemtitle }</div></h5>
									           
									           
									            <div class="item_boxbottom">
										            <p class="card-text">
										            	<span>${wList.itemcost }원</span><br>
										            	<span>서울시&nbsp&nbsp ${wList.content }</span>
										            </p>
									              
									                <div class="board_icon_view d-flex justify-content-start likechat">
										                <i class="fa-solid fa-heart"></i>&nbsp
										                <span id="heart_cnt">${wList.itemwish }&nbsp&nbsp</span>
										                <i class="fa-solid fa-eye"></i>&nbsp&nbsp
										                <span id="reply_cnt">${wList.itemview }</span>
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
	<!-- End Frequenty Asked Questions Section -->


<%@ include file="footer.jsp" %>
</body>
</html>