<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cheese Market</title>
<link href="css/dealCommentDetail.css?123"  rel="stylesheet">
</head>
<body>
	<input type="hidden" name="itemno" value="${reseritem.itemno }">
	<input type="hidden" name="itemtitle" value="${reseritem.itemtitle }">
	<input type="hidden" name="dealcontent" value="${reseritem.dealcontent }">
	<input type="hidden" name="nickname" value="${reseritem.nickname }">
	
	
	
	
	
<div class="container text-center">
	<div class="dc_All">
		<div class="dealCommentDetail_title">
			<!-- <h2>구매 후기</h2> -->
			<span class="mypage_title"><i class="fa-solid fa-envelope icon_prf"></i><h4>보낸 후기</h4></span>
		</div>
		<hr>
		
		<c:choose>
		<c:when test="${reseritem.dealcontent == null}">
				<div class="comment_box">
					<table class="comment_table" bgcolor="FFE4C4">
						<tr>
							<td><img alt="..." src="images/comment.png" width="300" height="400" ></td>
							<td class="dealcontent" style="font-size:18px">받은 후기가 없습니다</td>
						</tr>
					</table>
				</div>	
		</c:when>
		<c:otherwise>
			
			<div class="id_itemtitel">
					<h4>${reseritem.nickname}님에게</h4>
					<h4>따뜻한 후기를 보냈어요!</h4>
					<div>${reseritem.itemtitle }를 거래했어요!</div>
				</div>
				<div class="comment_box">
					<table class="comment_table" bgcolor="FFE4C4">
						<tr>
							<td><img alt="..." src="images/comment.png" width="300" height="400" ></td>
							<td class="dealcontent" style="font-size:18px">${reseritem.dealcontent }</td>
						</tr>
					</table>
				</div>	
			
			
		</c:otherwise>
		</c:choose>
		
	</div>
</div>



<%@ include file="footer.jsp"%>
</body>
</html>