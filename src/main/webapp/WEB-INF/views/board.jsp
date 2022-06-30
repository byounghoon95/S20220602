<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<script type="text/javascript"
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"> /* 창현추가(게시물검색) */
$(function() {
   $('#search_bd').click(function() {
      var bdkeyword =  $('#bdkeyword').val();
      if (!bdkeyword) {
         alert("검색어를 입력하세요")
         return false;
      }
      var sendData = 'bdkeyword='+bdkeyword;
      /* alert('sendData-->'+sendData) */
      location.href="board?"+sendData;
   });
});
$(document).ready(function() {
   // 모달창 
   // 모달창id얻기
    var modal = document.getElementById('dtsch_modal1');
    // 클릭id얻기
    var btn = document.getElementById("first_btn");
    // 닫기
    var close = document.getElementsByClassName("modal_close")[0];                                          
    //검색버튼클릭시 모달창 block
    btn.onclick = function() {
        modal.style.display = "block";
    }
    // close_btn클릭시 모달창none
    close.onclick = function() {
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
<head>
<meta charset="UTF-8">
<title>Cheese Market</title>
</head>

<%
	String id = (String) session.getAttribute("id");
%>

<!-- header -->
<c:choose>
<c:when test="${id == null}">
	<%@ include file="header.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="header_mem.jsp"%>
</c:otherwise>
</c:choose>

<link href="css/board.css?abc" rel="stylesheet" />

<body>
	<!-- Content section 1-->
	<section id="scroll">
		<div class="container px-5" id="first_body">
			<div class="row gx-5 align-items-center">
				<div class="col-lg-6 order-lg-1">
					<div class="p-5">
						<div>
							<img class="img-fluid" src="images/character.png" alt="..."
								id="character" />
						</div>
						<div>
							<c:choose>
		                        <c:when test="${empty id }" >
		                              <button type="button" class="btn btn-warning" id="first_btn">글 작성하기</button>
		                              <div id="dtsch_modal1" class="dtsch_modal modal">
		                                 <div class="modal-cnt">
		                                     <span class="modal_close">&times;</span>                                                               
		                                      <p class="tit">로그인 후 이용하세요</p>
		                                      <p class="m-content"><a class="modal-btn" href="login">로그인</a> &nbsp하러가기 </p>
		                                 </div>
		                              </div>
		                        </c:when>
		                        <c:otherwise>
		                           <button type="button" class="btn btn-warning" id="second_btn" onclick="location.href='boardWriteForm'">글 작성하기</button>
		                        </c:otherwise>
		                   </c:choose>
						</div>
					</div>
				</div>
				<div class="col-lg-6 order-lg-2">
					<div class="p-5">
						<h3 class="display-4">치즈 일상</h3>
						<p>일상 속 다양한 이야기를 함께 나누어요 !</p>
						<p>궁금한 것 질문하기, 분실물 찾기, 동네 모임까지~!</p>
						<p>따뜻한 이야기를 같이 만들어 나가요:)</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="col-lg-8 col-md-10 mx-auto"></div>
	<div id="blank"></div>
	<!-- ======= Frequenty Asked Questions Section ======= -->
	<div class="container">
		<section class="faq">
			<div class="container">
				<div class="section-title">
					<h2>일상 게시판</h2>
					<div class="search">
               <input type="text" id="bdkeyword" class="search_board"
                     placeholder="찾고 싶은 게시글 검색"/>
                    <button  class="btn-outline-secondary" type="button" value="검색" id="search_bd">
                        <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </div>
				</div>
				<ul class="faq-list">
					<c:forEach var="bList" items="${boardList }">
						<li><a class="text-start" id="board_title" href="boardDetail?boardno=${bList.boardno }">${bList.boardtitle }</a>
						<p class="text-start" id="board_txt">${bList.boardcontent }</p>
						<div class="board_icon_view d-flex justify-content-start">
							<i class="fa-solid fa-eye"></i>&nbsp <span id="heart_cnt">${bList.boardview }&nbsp&nbsp</span>
							<!-- <i class="fa-solid fa-comments"></i>&nbsp <span id="reply_cnt">0</span> -->
						</div></li>
					</c:forEach> 
				</ul>
				<!-- pagination -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${pg.startPage > pg.pageBlock }">
							<li class="page-item"><a class="page-link" href="board?currentPage=${pg.startPage-pg.pageBlock}&bdkeyword=${bdkeyword}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
							<li class="page-item"><a class="page-link" href="board?currentPage=${i}&bdkeyword=${bdkeyword}"
								id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${pg.endPage < pg.totalPage }">
							<li class="page-item"><a class="page-link" href="board?currentPage=${pg.startPage+pg.pageBlock}&bdkeyword=${bdkeyword}"
								aria-label="Next" id="page_btn"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
				<!-- pagination end-->
			</div>
		</section>
	</div>
	<!-- End Frequenty Asked Questions Section -->
<%@ include file="footer.jsp" %>
</body>
</html>