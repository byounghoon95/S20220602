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
<link href="css/mempwFind.css" rel="stylesheet" />
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
								<form action="pwupdate" method="post">
								<input type="hidden" name="id" value="${member.id }">
									<div class="input_all">
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">새 비밀번호</label>
											<input type="password" class="input" name="pw" id="pw_input"
												placeholder="새 비밀번호를 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호
												확인</label> <input type="password" class="input" name="pw2"
												id="pw2_input" placeholder="새 비밀번호를 한 번 더 입력해주세요" required />
										</div>
										<div class="pw_chk"></div>
										<button type="submit" class="btn btn-lg btn-block" id="pw_btn">비밀번호
											변경</button>
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
	<script type="text/javascript">
		$(document).ready(function() {
			$('#pw2_input').blur(function() {
				console.log("시작");
				var pw = $('#pw_input').val();
				var pw2 = $('#pw2_input').val();
				if (pw == pw2) {
					$(".pw_chk").html('비밀번호가 일치합니다').css('color','green');
				} else {
					$(".pw_chk").html('비밀번호가 일치하지 않습니다').css('color','rgb(253, 201, 0)');
					$('#pw2_input').val("");
				}
			})
		});
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>