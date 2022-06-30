<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<link href="css/mypageComment.css" rel="stylesheet" />
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
					<span class="mypage_title"><i class="fa-solid fa-envelope icon_prf"></i><h4>받은 후기</h4></span>
					<hr /><br><br>
					
					<ul class="faq-list">
						<c:forEach var="cList" items="${mypageOtherCommentList }">
							<li><a class="text-start" id="board_title">${cList.dealcontent }</a>
							<p class="text-start" id="board_txt">${cList.nickname }</p>
						</c:forEach> 
					</ul>
					
				</div>
			</section>
		</div>
	</div>
	<!-- End Frequenty Asked Questions Section -->
<%@ include file="footer.jsp" %>
</body>
</html>