<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link href="css/hf_before.css" rel="stylesheet" />
<link href="css/pwFind.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div class="container py-5 h-100">
		<div
			class="row d-flex justify-content-center align-items-center h-100">
			<!-- xl-10 변경하면 가로폭 줄어듬 -->
			<div class="col col-xl-8">
				<img src="images/logo.png" id="logo" />
				<div class="card" style="border-radius: 1rem">
					<div class="g-0">
						<div class="col-md-6 col-lg-7 d-flex align-items-center">
							<div class="card-body p-4 p-lg-5 text-black">
								<form>
									<div class="input_all">
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">아이디</label>
											<input type="text" class="input" name="name" id="id"
												placeholder="아이디를 입력해주세요" required />
										</div>
										
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example17">이메일</label>
											<div class="d-flex">
												<input type="text" class="input" name="email" id="id_input"
													placeholder="이메일을 입력해주세요" required />
												<button type="button" class="btn" id="check_btn" onclick="idCheck()">
													인증하기</button>
											</div>
										</div>
										
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example17">인증번호 입력</label>
											<div class="d-flex">
												<input type="text" class="input" name="veryfy" id="id_input"
													placeholder="인증번호를 입력해주세요" required />
												<button type="button" class="btn" id="check_btn" onclick="idCheck()">
													확인</button>
											</div>
										</div>
										
										<div>
											<button class="btn btn-lg btn-block" type="button"
												id="pw_btn" onclick="register">비밀번호 변경</button>
										</div>
										<br />
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>