<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cheese Market</title>
<link href="css/dealComment.css?!1233"  rel="stylesheet">
</head>
<body>
	
	<form action="dealComment" method="post">
			
		<div class="container text-center">
					<hr>
			<div class="psAll">
				<input type="hidden" name="itemno" value="${reser.itemno }"/>
				
					<div class="ps_Haed">
						<div>
						<img src="images/cheese.png" alt="..." width="150" height="150" style="border:1px solid gray">
						</div>
						<div class="ps_title">
							<h2>${dealcommentsend.itemtitle}</h2>
						<%-- <span>거래한 이웃 ${item.id }</span> --%>
						</div>
					</div>
					<hr>
					<div class="ps_insertTitle">
						<div class="ps_ID">
							<h4>${nickname}님,</h4><br>
							<h4>${dealcommentsend.nickname }님과 거래가 어떠셨나요?</h4>
						</div>
					</div>
					
					<div class="radioButton">
							<input type="radio" class="likehate" name="smcd" id="s1" value="601"/>
							<label for="s1" class="label_s1">
							<img src="images/like.jpg" alt="..." width="150" height="150" /><br>
							<h4>좋아요</h4>
							</label>
							
         					<input type="radio" class="likehate" name="smcd" id="s2" value="602">
        					<label for="s2" class="label_s2">
        					<img src="images/hate.jpg" alt="..." width="150" height="150" /><br>
        					<h4>별로예요</h4>	
        					</label>
					</div>
					
					<div class="ps_Content">
						<h2>${dealcommentsend.nickname }님에게 남기실 말씀</h2>
						<div class="dealcontent_box">
	  						<textarea id="content_textarea" name="dealcontent" cols="40" rows="4" placeholder="내용을 입력하세요." value="${reser.dealcontent }"></textarea>
						</div>
					</div>
					
					<!-- 별점주기 -->
					<div class="star-rating space-x-4 mx-auto">
						<input type="radio" id="3-stars" name="score" value="3" v-model="ratings"/>
						<label for="3-stars" class="star">★</label>
						<input type="radio" id="2-stars" name="score" value="2" v-model="ratings"/>
						<label for="2-stars" class="star">★</label>
						<input type="radio" id="1-star" name="score" value="1" v-model="ratings" />
						<label for="1-star" class="star">★</label>
					</div>
					<!-- 후기등록 -->
					<div class="ps_insertButton">
						<button typy="submit" class="btn btn-warning" id="insert">후기등록</button>
					</div>
		
			</div>
			
		</div>
	</form>
<%@ include file="footer.jsp"%>

</body>
</html>
