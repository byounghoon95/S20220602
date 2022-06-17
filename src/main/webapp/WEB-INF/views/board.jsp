<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/board.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Cheese Board</title>
</head>
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
							<button type="button" class="btn btn-warning" id="first_btn" onclick="location.href='boardWriteForm'">
								글 작성하기</button>
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
				</div>
				<ul class="faq-list">
					<c:forEach var="bList" items="${boardList }">
						<li><a class="text-start" id="board_title" href="boardDetail?boardno=${bList.boardno }">${bList.boardtitle }</a>
						<p class="text-start" id="board_txt">${bList.boardcontent }</p>
						<div class="board_icon_view d-flex justify-content-start">
							<i class="fa-solid fa-heart"></i>&nbsp <span id="heart_cnt">5&nbsp&nbsp</span>
							<i class="fa-solid fa-comments"></i>&nbsp <span id="reply_cnt">5</span>
						</div></li>
					</c:forEach> 
				</ul>
				<!-- pagination -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${pg.startPage > pg.pageBlock }">
							<li class="page-item"><a class="page-link" href="board?currentPage=${pg.startPage-pg.pageBlock}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
							<li class="page-item"><a class="page-link" href="board?currentPage=${i}"
								id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${pg.endPage < pg.totalPage }">
							<li class="page-item"><a class="page-link" href="board?currentPage=${pg.startPage+pg.pageBlock}"
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