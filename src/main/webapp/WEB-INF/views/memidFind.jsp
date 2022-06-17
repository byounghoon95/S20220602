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
<link href="css/memidFind.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$('#find_btn').click(function(){
		var name_input = $('#id_input').val();
		var phone_input = $('#phone_input').val();
		var email_input = $('#email_input').val();
		 $.ajax(
		   		 {
		 				url:'<%=context%>/idchk',
		 				type:"get",
		 				data:{"name" : name_input, "phone" : phone_input, "email" : email_input},
		 				dataType:'json',
		 				success:function(data){
		 				var id = data.id;
		 					if(data.chk == 0){
		 						alert("정보를 확인해 주세요");
		 						$('#id_input').val("");
		 						$('#phone_input').val("");
		 						$('#email_input').val("");
		 					}else{
		 						$(".modal-body").html("회원님의 아이디는 " + id + " 입니다");		
		 						$('#exampleModal').modal("show");
		 					}
		 				}
		 			}
		   	 );
	});
});
</script>
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
											<label class="form-label" for="form2Example27">이름</label> <input
												type="text" class="input" name="name" id="id_input"
												placeholder="이름을 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">전화번호</label> <input
												type="text" class="input" name="phone" id="phone_input"
												placeholder="전화번호를 입력해주세요" required />
										</div>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">이메일</label> <input
												type="text" class="input" name="email" id="email_input"
												placeholder="이메일을 입력해주세요" required />
										</div>
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-lg btn-block"
											id="find_btn">아이디 조회</button>
										<!-- 모달 -->
										<div class="modal fade" id="exampleModal" tabindex="-1"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<!-- 모달에 텍스트 나오는 부분 -->
													<div class="modal-body"></div>
													<div class="modal-footer">
														<button type="button" class="btn" id="login_btn"
															onclick="location.href='login'" data-bs-dismiss="modal">로그인</button>
														<button type="button" class="btn" id="pwfind_btn"
															onclick="location.href='pwForm'">비밀번호 찾기</button>
													</div>
												</div>
											</div>
										</div>
										<!-- 모달 -->
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