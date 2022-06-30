<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cheese adminNotice</title>
</head>
<body>
	<!-- Content section 1-->

	<div class="col-lg-8 col-md-10 mx-auto"></div>
	<div id="blank"></div>
	<!-- ======= Frequenty Asked Questions Section ======= -->
	<div class="container">
		<section class="faq">
			<div class="container">
				<div class="section-title">
					<h2>공지사항관리</h2>
				</div>
				<ul class="faq-list">
					<c:forEach var="bList" items="${adminNoticeList }">
						<li><a class="text-start" id="board_title"
							href="adminNoticeDetail?boardno=${bList.boardno }">${bList.boardtitle }</a>
							<p class="text-start" id="board_txt">${bList.boardcontent }</p>
							<div class="board_icon_view d-flex justify-content-start">
							</div></li>
					</c:forEach>
					<div>
						<button type="button" class="btn btn-warning" id="first_btn"
							onclick="location.href='adminNoticeWriteForm'">글쓰기</button>
					</div>
				</ul>

				<!-- pagination -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${pg.startPage > pg.pageBlock }">
							<li class="page-item"><a class="page-link" href="adminNotice?currentPage=${pg.startPage-pg.pageBlock}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
							<li class="page-item"><a class="page-link" href="adminNotice?currentPage=${i}"
								id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${pg.endPage < pg.totalPage }">
							<li class="page-item"><a class="page-link" href="adminNotice?currentPage=${pg.startPage+pg.pageBlock}"
								aria-label="Next" id="page_btn"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
				<!-- pagination end-->
			</div>

		</section>

	</div>
	<%@ include file="adminfooter.jsp"%>
</body>
</html>