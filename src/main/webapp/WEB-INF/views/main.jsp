<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/main.css" rel="stylesheet" />
<meta charset="UTF-8">
<title>Cheese Market</title>
</head>
<body>
	<!-- Content section 1-->
	<section id="scroll">
		<div class="container px-5" id="first_body">
			<div class="row gx-5 align-items-center">
				<div class="col-lg-6 order-lg-2">
					<div class="p-5">
						<img class="img-fluid" src="images/character.png" alt="..."
							id="character" />
					</div>
				</div>
				<div class="col-lg-6 order-lg-1">
					<div class="p-5">
						<h3 class="display-4">
							<bold>치</bold>
							즈마켓에서
						</h3>
						<h3 class="display-4">
							<bold>즈</bold>
							~을기자!
						</h3>
						<p>중고 거래와 일상 공유까지,</p>
						<p>함께해요 치즈마켓</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Content section 2-->
	<section>
		<div class="container px-5">
			<div class="row gx-5 align-items-center">
				<div class="col-lg-6">
					<div class="p-5">
						<img class="img-fluid rounded-circle" src="images/cheese.png"
							alt="..." />
					</div>
				</div>
				<div class="col-lg-6">
					<div class="p-5">
						<h2 class="display-4">간편한 중고 거래,</h2>
						<h2 class="display-4">따뜻한 일상 공유</h2>
						<p>지금 시작해보세요!</p>
						<button type="button" class="btn btn-warning" id="s_btn1" onclick="location.href='/market'">
							마켓 둘러보기</button>
						<button type="button" class="btn btn-warning" id="s_btn2" onclick="location.href='/board'">
							일상 둘러보기</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>
