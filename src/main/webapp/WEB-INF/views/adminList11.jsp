<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="adminHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cheese QList</title>
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
					<h2>1 : 1 문의관리</h2>
				</div>
				<ul class="faq-list">

					<c:forEach var="bList" items="${List11 }">
						<li><a class="text-start" id="board_title"
							href="adminList11Detail?inqno=${bList.inqno }">${bList.inqtitle }</a>
							<p class="text-start" id="board_txt">${bList.inqcontent }</p>
							<div class="board_icon_view d-flex justify-content-start">
									<c:choose>
										<c:when test="${bList.inqstatus == 'N'}">
											<i class="fa-solid fa-comments"></i>&nbsp <span
												id="reply_cnt1">답변대기</span>
										</c:when>
										<c:otherwise>
											<i class="fa-solid fa-comments" style="color:#ffc107"></i>&nbsp <span
												id="reply_cnt2" style="color:#ffc107">답변완료</span>
										</c:otherwise>
									</c:choose>
							</div></li>
					</c:forEach>

				</ul>
				<!-- pagination -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${pg.startPage > pg.pageBlock }">
							<li class="page-item"><a class="page-link"
								href="adminList11?currentPage=${pg.startPage-pg.pageBlock}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
							<li class="page-item"><a class="page-link"
								href="adminList11?currentPage=${i}" id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${pg.endPage < pg.totalPage }">
							<li class="page-item"><a class="page-link"
								href="adminList11?currentPage=${pg.startPage+pg.pageBlock}"
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
	<%@ include file="adminfooter.jsp"%>
</body>
</html>