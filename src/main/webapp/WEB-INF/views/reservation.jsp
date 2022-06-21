<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

</style>
<title>Insert title here</title>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c580f887be4de17e4edf5d91282aa88&libraries=services"></script>
	<link  href="css/reservation.css?123" rel="stylesheet"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	
<body>
 <div>
 	<div>
 		<form action="reservation">	
 			<div class="container text-center">
 				<div class="reser_timetitle">
 					<h2 class="reser_timetitle1">약속시간(장소) 설정</h2>
 				</div>
				<hr class="reser_titleLine" id="reser-up" width="90%">
				
				<c:choose>
				<c:when test="${sessid } ==${reser.id }">
					<input type="hidden" name="mcd" value="502">
				</c:when>
				
				<c:otherwise>
					<input type="hidden" name="mcd" value="501">
				</c:otherwise>
				</c:choose>	
				<div class="reser_datetime">
				<!-- 달력 -->
					
					<label>날짜</label> 
					<td>
					<input type="date" class="date-control" min="${sysdate }" name="resdate" value ="${resdate }">
					</td>
					
					
					
				
					<script type="text/javascript">
						$('datePicker').datepicker({
							format: "yyyy-mm-dd",
							language : "kr"
						});
					</script>
		
					
							
				<!-- 예약시간 설정 -->
				
			시간<input type="time" name="restime" onclick=data() value="${reser.restime }">
				<!-- <input type="submit" value="Submit"> -->
			장소<input type="text" id="hiddenValue" name="resloc" value="${reser.resloc }" placeholder="장소를 검색하세요!">
				</div>
	
				<!-- 지도 AIP -->
				<div class="map_wrap">
			    	<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
			
			    	<div id="menu_wrap" class="bg_white">
			        	<div class="option">
			            	<div>
			                	<div>
			                   	 주소검색  <input type="text" id="keyword" size="15" > 
			                    	<button type="button" onclick="searchPlaces(); return false;">
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
					<button type="submit" class="btn btn-warning" >예약하기</button>
				</div>
		
				<script type="text/javascript" src="js/reservation.js"></script>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c580f887be4de17e4edf5d91282aa88&libraries=services">
				</script>
			</div>
		</form>
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>