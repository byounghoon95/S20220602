<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<span class="mypage_title"><i class="fa-solid fa-envelope icon_prf"></i><h4>받은 후기</h4></span>
		</div>
		<hr>
		<div class="id_itemtitel">
			<div class="comment_nickname"><span style="font-size: 40" class="comment_nickname_color">${reseritem.nickname}</span>님에게</div><br>
			<span>따뜻한 후기를 보냈어요!</span><br>
			<span><strong>${reseritem.itemtitle }</strong>을(를) 거래했어요!</span>
		</div>
		<div class="comment_box">
			<table class="comment_table" bgcolor="ffc0cb">
				<tr>
					<td><img alt="..." src="images/comment.png" width="300" height="400" ></td>
					<td class="dealcontent">${reseritem.dealcontent }</td>
				</tr>
			</table>
		</div>	
	</div>
</div>



<%@ include file="footer.jsp"%>
</body>
</html>