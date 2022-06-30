<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cheese Market</title>
<link href="css/reservationDetail.css?!23" rel="stylesheet"/>
</head>
<body>
	<input type="hidden" name="itemno" value="${reseritem.itemno }">
	<input type="hidden" name="id" value="${reseritem.id }">
	<input type="hidden" name="dealcontent" value="${reseritem.dealcontent }">
	<input type="hidden" name="score" value="${reseritem.score }">
	<input type="hidden" name="bcd" value="${reseritem.bcd }">
	<input type="hidden" name="mcd" value="${reseritem.mcd }">
	<input type="hidden" name="sbcd" value="${reseritem.sbcd }">
	<input type="hidden" name="smcd" value="${reseritem.smcd }">
	<input type="hidden" name="resloc" value="${reseritem.resloc }" id="resloc">
	
	
	<div class="container text-center">
		<h2 class="reserDetail_title">예약상세정보</h2>
		<hr>
		<div>
				<button type="button"  id="compl_button" onclick="location.href='dealCompl?itemno=${reseritem.itemno}'" style="color:white">거래 완료</button>
			<div class="reser_content">
				<p class="reser_time">약속날짜 : ${reseritem.resdate } &nbsp&nbsp 약속시간 : ${reseritem.restime }</p>&nbsp&nbsp
				<p class="reser_loc">약속장소 : ${reseritem.resloc }</p>				
			</div>
			
		<!-- map api -->
			<div id="map" style="width:60%;height:350px; margin:0 auto;" ></div>
				<div class="reserDetail_button">
					<button type="button" class="btn btn-warning" onclick="location.href='reservationUpdateForm?itemno=${reseritem.itemno}'" style="color:white">수정하기</button> &nbsp&nbsp 
					<button type="button" class="btn btn-warning" onclick="location.href='reservationDelete?itemno=${reseritem.itemno}'" style="color:white">삭제하기</button>&nbsp&nbsp
					<button type="button" class="btn btn-warning" onclick="location.href='reservationList?id=${reseritem.id}'" style="color:white">리스트로 가기</button> 
				</div>
		</div>
	</div>	
	
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c580f887be4de17e4edf5d91282aa88&libraries=services"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/reservationDetail.js"></script>
<%@ include file="footer.jsp"%>
</body>
</html>