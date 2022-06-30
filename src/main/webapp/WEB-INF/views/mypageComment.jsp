<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
							<c:forEach var="cList" items="${mypageCommentList }">
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