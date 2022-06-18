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
	<link  href="css/reservationUpdateForm.css" rel="stylesheet"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
</head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

<body>
 <div>
 	<div>
 		<form action="reservationUpdate" method="post">	
 			<div class="container text-center">
 				<div class="reser_timetitle">
 					약속시간(장소)설정
 				</div>
				<hr class="reser_titleLine" id="reser-up" width="90%">
				<input type="hidden" name="itemno" value="${reser.itemno }">
				
				
				
				
					
				<div class="reser_datetime">
				<!-- 달력 -->
					
					<label>날짜</label> 
					<td>
					<input type="date" class="date-control" min="${sysdate }" name="resdate" value ="${reser.resdate }">
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
			장소<input type="text" id="hiddenValue" name="resloc" value="${reser.resloc }">
				</div>
	
				<!-- 지도 AIP -->
					<!-- 지도 AIP -->
				<div class="map_wrap">
			    	<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
			
			    	<div id="menu_wrap" class="bg_white">
			        	<div class="option">
			            	<div>
			                	<div>
			                   	 키워드 : <input type="text" id="keyword" size="15" value="${reser.resloc }"> 
			                    	<button type="button" onclick="searchPlaces(); return false;">검색하기</button>
			                    	
			                    	
			                	</div>
			            	</div>
			        	</div>
			        	<hr>
			        	<ul id="placesList"></ul>
			        	<div id="pagination"></div>
			    	</div>
				</div>
				

    			<!-- 수정버튼 -->
    			<div>
				<button type="submit">수정하기</button> &nbsp&nbsp<button type="button" onclick="history.go(-1)">뒤로가기</button>
				</div>
		
		

				<script type="text/javascript" src="js/reservationUpdateForm.js"></script>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4c580f887be4de17e4edf5d91282aa88&libraries=services">
				</script>
			</div>
		</form>
	</div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>