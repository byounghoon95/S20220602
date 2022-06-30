<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

</style>
<title>Cheese Market</title>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c580f887be4de17e4edf5d91282aa88&libraries=services"></script>
	<link  href="css/reservation.css?121233" rel="stylesheet"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
						$('datePicker').datepicker({
							format: "yyyy-mm-dd",
							language : "kr"
						});
					</script>
<body>
 <div>
 	<div>
 		<form action="reservation">	
 			<div class="container text-center">
 				<div class="reser_timetitle">
 					<h2 class="reser_timetitle1">약속시간(장소) 설정</h2>
 					<hr class="reser_titleLine" id="reser-up" width="100%">
 				</div>
				<input type="hidden" name="itemno" value="${reser.itemno }">
				
				<c:choose>
					<c:when test="${sessid ==reser.id}">
						<input type="hidden" name="mcd" value="502">
					</c:when>
					
					<c:otherwise>
						<input type="hidden" name="mcd" value="501">
					</c:otherwise>
				</c:choose>	
				<div class="reser_datetime">
				<!-- 달력 -->
					
				<table class="reser_datetime_table">
					<tr>
						<td>
						<h3>날짜</h3><input type="date"  id="date_dg" class="date-control" min="${sysdate }" name="resdate" value ="${reser.resdate }" placeholder="${sysdate }">
						</td>
						
						
			
						
								
					<!-- 예약시간 설정 -->
						<td>	
							<h3>시간</h3><input type="time" id="time_dg" name="restime" onclick=data() value="${reser.restime }">
							<!-- <input type="submit" value="Submit"> -->
						</td>
						<td>
							<h3>장소</h3><input type="text" id="hiddenValue" name="resloc" value="${reser.resloc }" placeholder="장소를 검색하세요!" >
						</td>
					</tr>
				</table>
				</div>
	
				<!-- 지도 AIP -->
				<div class="map_wrap">
			    	<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
			
			    	<div id="menu_wrap" class="bg_white">
			        	<div class="option">
			            	<div>
			                	<div>
			                   	 <label for="keyword">주소검색</label><input type="text" name="addressSearch"  id="searchInsert" size="15" > 
			                    	<button type="button" onclick="searchPlaces()">
			                    		<i class="fa-solid fa-magnifying-glass"></i>
			                    	</button>
			                	</div>
			            	</div>
			        	</div>
			        	<hr>
			        	<ul id="placesList"></ul>
			        	<div id="pagination"></div>
			    	</div>
				</div>
				<!-- 예약버튼 -->
	    		
	    		<div class="reser_button">
					<button type="submit" class="btn btn-warning" style="color:white">예약하기</button>
				</div>
		
				<script type="text/javascript" src="js/reservationForm.js"></script>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c580f887be4de17e4edf5d91282aa88&libraries=services">
				</script>
			</div>
		</form>
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>