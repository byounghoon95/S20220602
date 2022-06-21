<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/itemDetail.css" rel="stylesheet">
<title>상품 상세페이지</title>
</head>

<body>

	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="itemDetail" method="post">
		<input type="hidden" name="buyerid" value="${item.id }"> <input
			type="hidden" name="itemno" value="${item.itemno }">

		<div class="wrap">
			<!-- itemDetail 내용부분시작 -->
			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="carousel" data-interval="false">
				<!-- 상품사진 시작 -->
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="images/cheese.png" class="d-block w-40"
							id="cheesecarousel" alt="테스트">
					</div>
					<div class="carousel-item">
						<img src="images/cheese.png" class="d-block w-40"
							id="cheesecarousel" alt="...">
					</div>
					<div class="carousel-item">
						<img src="images/cheese.png" class="d-block w-40"
							id="cheesecarousel" alt="...">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			<!-- 상품사진끝 -->

			<div class="container" id="container1">
				<!-- 상품내용 시작 -->
				<hr />
				<div id="itemSeller_profile">
					<!-- 판매자 프로필정보 -->
					<span> <!-- <img src="/images/mem_profile.jpg" alt="#" id="itemSeller_photo" /> -->사진
					</span>
					<div id="profile_info">
						<div id="profile_info_detail">
							<b>${itemDetail.nickname}</b>
						</div>
						<div id="profile_info_detail">${locname}</div>
					</div>
					<div id="cheese_info">
						<span><b>${itemDetail.participation}%</b></span> <span>치즈이미지</span>
					</div>
				</div>
				<!-- 판매자 프로필정보 끝 -->
				<hr />

				<div id="margin_top_itemDetail">
					<!-- 상품 상세 내용 시작-->
					<h2 id="margin_top_itemDetail">${itemDetail.itemtitle}</h2>
				</div>
				<div>
					<span>${itemDetail.content}</span> <span>3일전</span>
				</div>
				<div id="itemDetail_top">
					<!-- 한줄에 담기해야함 예약중  가격 		하트 채팅하기 -->
					<div>
						<!-- 예약중, 가격 -->
						<h3 id="h3_inline">예약중</h3>
						<h3 id="h3_inline">${itemDetail.itemcostfilter}원</h3>
					</div>
					<!-- 예약중, 가격 -->
					<div>
						<!-- 하트, 채팅, 수정,삭제 버튼 -->
						<span> <!-- 하트 --> <%-- <span ><a href="/doWish?id=${id }&itemno=${itemno }&redirectUrl=/itemDetail?id=${id }&itemno=${itemno}" onclick="if(confirm('관심담기 하겠습니까?') == false) {return false;}">관심담기</a></span>
							 --%> <%-- <c:choose>
								<c:when test="${wishcheck eq '0' }"><!-- wishcheck가 null이면 빈하트 표시 -->
									<img class="heart_empty" src="images/heart_empty.svg" id="heart_empty" style="cursor:pointer">
								</c:when>
								<c:otherwise><!-- wishcheck가 not null이면 꽉찬하트 표시 -->
									<img class="heart_fill" src="images/heart_fill.svg" id="heart_fill" style="cursor:pointer">
								</c:otherwise>
								
							</c:choose> --%>
						</span>
						<!-- 채팅, 수정, 삭제-->
						<div id="cht_upd_del_btn">
							<div id="icon_btn_inline">
								<!-- 채팅, 수정, 삭제 if문-->
								<c:set var="buyerid" value="${item.id}" />
								<c:set var="sellerid" value="${itemDetail.id}" />
								${buyerid } ${sellerid}
								<c:if test="${buyerid ne sellerid}">
									<div id="chat_btn" class="d-flex justify-content-center">
										<button type="button" class="btn btn-yellow mx-1" onclick="location.href='/chat?itemno=${itemDetail.itemno}'">채팅하기</button>
									</div>
								</c:if>
								<c:if test="${buyerid eq sellerid}">
									<div id="chat_btn" class="d-flex justify-content-center">
										<span><button type="button" class="btn btn-yellow mx-1"
												onclick="location.href='itemUpdateForm?id=${item.id }&itemno=${itemDetail.itemno }'">수정하기</button>
										</span> <span><button type="button"
												class="btn btn-yellow mx-1"
												onclick="location.href='itemDeletePro?itemno=${itemDetail.itemno }'">삭제하기</button>
												
										</span> 
										 
											<!-- Button trigger modal -->
											<button name="itemDelete" value="${itemDetail.itemno }" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"> 삭제하기</button> 
											
											<!-- Modal -->
											<div class="modal fade" id="itemDeleteModal" tabindex="-1"
												aria-labelledby="exampleModalLabel" aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabel">상품 삭제</h5>
															<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">
															<p>정말 상품을 삭제하시겠습니까?</p>
														</div>
														<div class="modal-footer">
															<button id="modalDelete" type="button" class="btn btn-secondary">삭제하기</button>
															<button type="button" class="btn btn-primary" data-bs-dismiss="modal">취소</button>
														</div>
													</div>
												</div>
											</div>
										
									</div>
									
								</c:if>
							</div>
							<!--채팅, 수정,삭제 if문 끝 -->
						</div>
						<!-- 채팅, 수정, 삭제 끝 -->
					</div>
					<!-- 하트, 채팅, 수정,삭제 버튼 끝-->
				</div>
				<!-- 한줄에 담기해야함 예약중  가격 		하트 채팅하기 끝 -->
				<div>${itemDetail.itemcontent }</div>
				<div>
					<span>관심${itemDetail.itemwish }</span> <span>조회${itemDetail.itemview }</span>
					<span>좋아요 여부${wishcheck }</span>
				</div>
				<div>이 게시글 신고하기</div>
			</div>
			<!--container1 상품내용 끝 -->

			<div class="container">
				<!-- 판매자의 다른 상품 리스트  -->
				<div class="itemtitle font-size: large">
					<span><h2>000님의 판매상품</h2></span> <span><a href="#"
						class="btn btn-primary itembtn">모두 보기</a></span>
				</div>
				<div class="items">
					<div class="container">
						<div class="market_itembox">
							<ul class="faq-list">
								<c:forEach var="sellerItemList" items="${sellerItemList }">
									<li class="li_item">
										<div class="card item" style="width: 16rem;">
											<img src="${context }/itemImgs/${sellerItemList.itemimg1}" class="card-img-top"
												alt="..."  width="286" height="286">
											<div class="card-body">
												<h6 class="card-title">
													<div class="card-itemTitle">${sellerItemList.itemtitle }</div>
												</h6>
												<p class="card-text">
													<span>${sellerItemList.itemcostfilter }원</span><br> <span>서울시&nbsp&nbsp
														${sellerItemList.locname }</span>
												</p>
												<div class="item_boxbottom">
													<a
														href="/itemDetail?id=${item.id }&itemno=${sellerItemList.itemno}"
														class="btn btn-primary itembtn">상품보기</a>
													<div
														class="board_icon_view d-flex justify-content-start likechat">
														<i class="fa-solid fa-heart"></i>&nbsp <span
															id="heart_cnt">${sellerItemList.itemwish }&nbsp&nbsp</span>
														<i class="fa-solid fa-eye"></i>&nbsp&nbsp <span
															id="reply_cnt">${sellerItemList.itemview }</span>
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
				<hr />
			</div>
			<!-- 판매자의 다른 상품 리스트  끝-->

		</div>
		<!-- itemDetail 내용부분 끝 -->
	</form>

	<div id="blank"></div>

	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		var action = '';
		var url = '';
		var type = '';
		var itemno = 0;
		
		$(document).ready(function(){
			//삭제하기 버튼 클릭
			$("button[name='itemDelete']").click(function() {
				itemno = this.value;
				action = 'itemDelete';
				type = 'PUT';
				
				$("#itemDeleteModal").modal();
			});
			
			//Modal의 삭제하기 버튼 클릭
		})
	</script>
</body>
</html>
