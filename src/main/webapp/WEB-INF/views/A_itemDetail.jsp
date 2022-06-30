<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link href="css/itemDetail.css" rel="stylesheet">
<title>Cheese Market</title>
</head>
<%
	String context = request.getContextPath();
%>
<script src="https://kit.fontawesome.com/00220d5400.js" crossorigin="anonymous"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<body>

	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="itemDetail" method="post">
		<input type="hidden" name="sessionId" value="${item.sessionId }"> 
		<input type="hidden" name="itemno" value="${item.itemno }">

		<div class="wrap">
			<!-- itemDetail 내용부분시작 -->
			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<c:forEach var="img" items="${imgList }">
					<c:set var = "i" value="${i+1 }"></c:set>
						<c:if test="${not empty img}">
							<button type="button" data-bs-target="#carouselExampleIndicators"
								data-bs-slide-to="${i-1 }" class="active" aria-current="true"
								aria-label="Slide 1"></button>
						</c:if>
					</c:forEach>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${context}/itemImgs/${itemDetail.itemimg1}"
							class="d-block w-40" id="cheesecarousel" alt="테스트"
							style="width: 800px;  height: 700px; border-radius: 5%">
					</div>
					<c:forEach var="img" begin="1" items="${imgList }">
						<c:if test="${not empty img}">
							<div class="carousel-item">
								<img src="${context}/itemImgs/${img}" class="d-block w-40 "
									id="cheesecarousel" alt="상품사진" style="width: 800px;  height: 700px; border-radius: 5%">
							</div>
						</c:if>
					</c:forEach>
					
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
					<div id="incoming_msg_img">
						<img src="${context}/itemImgs/${itemDetail.userimg}"
							class="img-circle" width="50px" height="50px"
							id="itemSeller_photo" onclick="location.href='mypageOther?id=${itemDetail.id}'" />
					</div>
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
					<span>${itemDetail.content}</span> ∙ <span>${itemDetail.itemdate }</span>
				</div>
				<div id="itemDetail_top">
					<!-- 한줄에 담기해야함 예약중  가격 		하트 채팅하기 -->
					<div>
						<!-- 예약중, 가격 -->
						<h3 id="h3_inline">예약중</h3>
						<h3 id="h3_inline">${itemDetail.itemcostfilter}원</h3>
					</div>
					<!-- 예약중, 가격 -->
					<div id="heart_cht_up_del"><!-- 하트, 채팅, 수정,삭제 버튼 -->
						<c:set var="sessionId" value="${item.sessionId}" />
						<c:set var="sellerId" value="${itemDetail.id}" />
						
						<!-- 채팅, 수정, 삭제-->
						<div id="cht_upd_del_btn">
							<div id="icon_btn_inline">
								<!-- 채팅, 수정, 삭제 if문-->
								
							
									<div id="chat_btn" class="d-flex justify-content-center">
										<span><button type="button"
												class="btn btn-yellow mx-1"
												onclick="location.href='A_itemDeletePro?itemno=${itemDetail.itemno }'">삭제하기</button>
										</span>
									</div>

							</div>
							<!--채팅, 수정,삭제 if문 끝 -->
						</div>
						<!-- 채팅, 수정, 삭제 끝 -->
					</div>
					<!-- 하트, 채팅, 수정,삭제 버튼 끝-->
				</div>
				<!-- 한줄에 담기해야함 예약중  가격 		하트 채팅하기 끝 -->
				<div>
					<pre>${itemDetail.itemcontent }</pre>
				</div>
				<div id="subview">
					<span>관심${itemDetail.itemwish }</span> ∙ <span>조회${itemDetail.itemview }</span>
				</div>
				<hr />
			</div>
			<!--container1 상품내용 끝 -->
			

		</div>
		<!-- itemDetail 내용부분 끝 -->
	</form>

	<div id="blank"></div>

	<%@ include file="adminfooter.jsp" %>	
</body>
</html>
