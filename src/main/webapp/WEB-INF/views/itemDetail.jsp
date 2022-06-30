<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

<link href="css/itemDetail.css" rel="stylesheet">
<title>상품 상세페이지</title>
</head>
<%
   String context = request.getContextPath();
%>
<script src="https://kit.fontawesome.com/00220d5400.js" crossorigin="anonymous"></script>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
function changeHeart(itemno, id) {
    $.ajax(
         {
            url:'<%=context%>/changeHeart',
            type:"post",
            data:{"sessionId" :id, "itemno" : itemno},
            dataType:'text',
            success:function(data){
               if(data == "1"){
                  $('#heart').css('color','red');
               }else{
                  $('#heart').css('color','rgb(204, 204, 204)');
               }
            }
         }
      );
}

$(document).ready(function() {
	   // 모달창 
	   // 모달창id얻기
	    var modal = document.getElementById('dtsch_modal1');
	    // 클릭id얻기
	    var btn = document.getElementById("first_btn");
	    // 닫기
	    var close  = document.getElementsByClassName("modal_close")[0];  
	    var close2 = document.getElementById("modal_close");
	    //검색버튼클릭시 모달창 block
	    btn.onclick = function() {
	        modal.style.display = "block";
	    }
	    // close_btn클릭시 모달창none
	    close.onclick = function() {
	        modal.style.display = "none";
	    }
	    close2.onclick = function() {
	        modal.style.display = "none";
	    }
	    // 모달창외 클릭시 모달 닫힘
	    window.onclick = function(event) {
	        if (event.target == modal) {
	            modal.style.display = "none";
	        }
	    }
	});
	
	
</script>

<body>

   <div id="blank"></div>
   <div id="blank_5vh"></div>

   <form action="itemDetail" method="post">
      <input type="hidden" name="id" value="${id }"> 
      <input type="hidden" name="itemno" value="${itemDetail.itemno }">

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
               		<c:if test="${itemDetail.itemimg1 ne null }">
	                  <img src="${context}/itemImgs/${itemDetail.itemimg1}"
	                     class="d-block w-40" id="cheesecarousel" alt="테스트"
	                     style="width: 800px;  height: 700px; border-radius: 5%">
	                </c:if>
	                <c:if test="${itemDetail.itemimg1 eq null }">
	                  <img src="images/no-image-icon.png"
	                     class="d-block w-40" id="cheesecarousel" alt="등록된 이미지 없음"
	                     style="width: 300px;  height: 300px; border-radius: 5%">
	                </c:if>      
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
                  <c:set var = "participation" value="${itemDetail.participation }"></c:set>
                  <c:if test="${participation >=0 && participation < 25}">
                     <span><h6 class="font_color_blue h6_inline">${itemDetail.participation}%</h6></span> <span><img src="images/cheese.png" id="cheeseImg"></span>
                     <div class="progress">
                       <div class="progress-bar" role="progressbar" aria-valuenow="${itemDetail.participation }"
                       aria-valuemin="0" aria-valuemax="100" style="width:${itemDetail.participation }%;  background: #5bc0de;">
                       </div>
                     </div>
                  </c:if>   
                  <c:if test="${participation >=25 && participation < 50}">
                     <span><h6 class="font_color_green h6_inline">${itemDetail.participation}%</h6></span> <span><img src="images/cheese.png" id="cheeseImg"></span>
                     <div class="progress">
                       <div class="progress-bar" role="progressbar" aria-valuenow="${itemDetail.participation }"
                       aria-valuemin="0" aria-valuemax="100" style="width:${itemDetail.participation }%; background: #5cb85c;">
                       </div>
                     </div>
                  </c:if>
                  <c:if test="${participation >=50 && participation < 75}">   
                     <span><h6 class="font_color_yellow h6_inline">${itemDetail.participation}%</h6></span> <span><img src="images/cheese.png" id="cheeseImg"></span>
                     <div class="progress">
                       <div class="progress-bar" role="progressbar" aria-valuenow="${itemDetail.participation }"
                       aria-valuemin="0" aria-valuemax="100" style="width:${itemDetail.participation }%; background: rgb(253, 201, 0);">
                       </div>
                     </div>
                  </c:if>
                  <c:if test="${participation >=75 && participation <= 100}">   
                     <span><h6 class="font_color_red h6_inline">${itemDetail.participation}%</h6></span> <span><img src="images/cheese.png" id="cheeseImg"></span>
                     <div class="progress">
                       <div class="progress-bar" role="progressbar" aria-valuenow="${itemDetail.participation }"
                       aria-valuemin="0" aria-valuemax="100" style="width:${itemDetail.participation }%; background: #d9534f;">
                       </div>
                     </div>
                  </c:if>
               </div>
            </div>
            <!-- 판매자 프로필정보 끝 -->
            <hr />

            <div id="margin_top_itemDetail">
               <!-- 상품 상세 내용 시작-->
               <h2 id="margin_top_itemDetail">${itemDetail.itemtitle}</h2>
            </div>
            <div>
               <span>${itemDetail.content}</span> ∙ <span>${itemDetail.itemdatefilter }</span>
            </div>
            <div id="itemDetail_top">
               <!-- 한줄에 담기해야함 예약중  가격       하트 채팅하기 -->
               <div>
                  <!-- 예약중, 가격 -->
                  <c:if test="${itemDetail.smcd == 201}">
                  <h3 id="h3_inline" class="font_color_blue">${resstat}</h3>         
                  </c:if>
                  <c:if test="${itemDetail.smcd == 202}">
                  <h3 id="h3_inline" class="font_color_green">${resstat}</h3>         
                  </c:if>
                  <c:if test="${itemDetail.smcd == 203}">
                  <h3 id="h3_inline" class="font_color_red">${resstat}</h3>         
                  </c:if>
                  <h3 id="h3_inline">${itemDetail.itemcostfilter}원</h3>
               </div>
               <!-- 예약중, 가격 -->
               <div id="heart_cht_up_del"><!-- 하트, 채팅, 수정,삭제 버튼 -->
                  <div > <!-- 하트 -->
                     <c:choose>
                        <c:when test="${wishCheck == 0 }">
                           <i class="fa-solid fa-heart fa-2x" id="heart" style="cursor: pointer; color: rgb(204, 204, 204); "
                              onclick="changeHeart(${itemDetail.itemno}, '${id }')"></i>
                        </c:when>
                        <c:when test="${wishCheck != 0 }">
                           <i class="fa-solid fa-heart fa-2x" id="heart" style="cursor: pointer; color: red;"
                              onclick="changeHeart(${itemDetail.itemno}, '${id }')"></i>
                        </c:when>   
                     </c:choose>
                  </div>
                  <!-- 채팅, 수정, 삭제-->
                  <div id="cht_upd_del_btn">
                     <div id="icon_btn_inline">
                        <!-- 채팅, 수정, 삭제 if문-->
                        <c:set var = "sellerId" value="${itemDetail.id}"></c:set>
                        <c:choose>
	                        <c:when test="${id eq sellerId}">
	                        	<div id="chat_btn" class="d-flex justify-content-center">
	                              <span><button type="button" class="btn btn-yellow mx-1"
	                                    onclick="location.href='itemUpdateForm?id=${id }&itemno=${itemDetail.itemno }'">수정하기</button>
	                              </span> <span><button type="button" id="first_btn"
	                                    class="btn btn-yellow mx-1">삭제하기</button>
	                              </span>
	                              <!-- 삭제 모달창 -->
	                              <div id="dtsch_modal1" class="dtsch_modal modal">
							         <div class="modal-cnt">
							             <span class="modal_close">&times;</span>                                                               
							              <p class="tit">삭제 확인</p>
							              <div class="m-content">
							              	<p>정말 삭제하시겠습니까?</p>
							                <p><input type="button"  class="modal-btn" value="확인" onclick="location.href='itemDeletePro?itemno=${itemDetail.itemno }'"> 
							                   <input type="button"  class="modal-btn" id="modal_close" value="취소"></p>
							            </div>
							         </div>
							      </div>
	                           </div>
	                        </c:when>
	                        <c:otherwise >
	                        	<div id="chat_btn" class="d-flex justify-content-center">
		                        	<c:choose>
					                     <c:when test="${empty id }" >
					                           <button type="button" class="btn                           sellbtn chatbtn" id="first_btn">채팅하기</button>
						                           <div id="dtsch_modal1" class="dtsch_modal modal">
						                              <div class="modal-cnt">
						                                  <span class="modal_close">&times;</span>                                                               
						                                   <p class="tit">로그인 후 이용하세요</p>
						                                   <p class="m-content"><a class="modal-btn itemmodalbtn" href="login">로그인</a> &nbsp하러가기 </p>
						                              </div>
						                           </div>
					                     </c:when>
					                     <c:otherwise>
											<button type="button" class="btn btn-yellow mx-1"
	                                 			onclick="location.href='chat?id=${id }&itemno=${itemDetail.itemno }'">채팅하기</button>
					                     </c:otherwise>
					                </c:choose>	
	                           </div>
	                        </c:otherwise>   
                    	</c:choose>
                     </div>
                     <!--채팅, 수정,삭제 if문 끝 -->
                  </div>
                  <!-- 채팅, 수정, 삭제 끝 -->
               </div>
               <!-- 하트, 채팅, 수정,삭제 버튼 끝-->
            </div>
            <!-- 한줄에 담기해야함 예약중  가격       하트 채팅하기 끝 -->
            <div>
               ${itemDetail.itemcontent }
            </div>
            <div id="subview">
               <span>관심${itemDetail.itemwish }</span> ∙ <span>조회${itemDetail.itemview }</span>
            </div>
            <div>
            <c:choose>
                  <c:when test="${id eq null}">
                        <p id="view"><a id="report">신고</a></p>
                  </c:when>
                  <c:otherwise>
                     <p id="view"><a id="report" href="warningForm?itemno=${itemDetail.itemno }">신고</a></p>
                  </c:otherwise>
               </c:choose>
            </div>
            <hr />
         </div>
         <!--container1 상품내용 끝 -->
         
         <div class="container">
            <!-- 판매자의 다른 상품 리스트  -->
            <div class="itemtitle bothpadding font-size: large">
               <div id="otherItem" ><h4>${itemDetail.nickname }님의 판매상품</h4></div> 
               <div id="otherItemBnt"><a  href="mypageOtherDeal?id=${itemDetail.id }" class="itemViewAll">모두 보기</a></div>
            </div>
            <div class="items">
               <div class="container">
                  <div class="market_itembox">
                     <ul class="faq-list">
                        <c:forEach var="sellerItemList" items="${sellerItemList }">
                           <li class="li_item">
                           		<a class="item_detail" href="/itemDetail?itemno=${sellerItemList.itemno}">
                           
		                              <div class="card item" style="width: 16rem;">
		                                 <img src="${context}/itemImgs/${sellerItemList.itemimg1 }"
		                                    class="card-img-top" width="286" height="286">
		                                 <div class="card-body">
		                                    <h6 class="card-title">
		                                       <div class="card-itemTitle">${sellerItemList.itemtitle }</div>
		                                    </h6>
		                                    
		                                    	<div class="item_boxbottom">
				                                    <p class="card-text">
				                                       <span>${sellerItemList.itemcostfilter }원</span><br> <span>서울시&nbsp&nbsp
				                                          ${sellerItemList.locname }</span>
				                                    </p>
				                                    <div class="item_boxbottom">
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
		                              </div>
		                              
                              </a>
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
</body>
</html>