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
<link href="css/mempwForm.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function(){
	$('#email_btn').click(function(){
		var email_input = $('#email_input').val();
		var id_input = $('#id_input').val();
		if (email_input == "" || id_input == ""){
			alert("정보를 입력해주세요");
		}else{
			 $.ajax(
			   		 {
			 				url:'<%=context%>/mailTransport',
			 				type:"post",
			 				data:{"email" : email_input, "id" : id_input},
			 				dataType:'json',
			 				success:function(data){
			 					if(data == 0){
			 						alert("정보를 확인해 주세요");
			 						$('#id_input').val("");
			 						$('#email_input').val("");
			 					}else{
			 						alert('인증번호를 입력해 주세요');
			 					}
			 				}
			 			}
			   	 );
		}

	});
});
$(document).ready(function(){
	$('#verify_btn').click(function(){
		var verify_input = $('#verify_input').val();
		var email_input = $('#email_input').val();
		var id_input = $('#id_input').val();
		console.log(verify_input);
		console.log(id_input);
		if (verify_input == "" || email_input == "" || id_input == ""){
			alert("정보를 입력해주세요");
		}else{
			 $.ajax(
			   		 {
			 				url:'<%=context%>/verifyChk',
			 				type:"post",
			 				data:{"temppw" : verify_input,"id" : id_input,"email" : email_input },
			 				dataType:'json',
			 				success:function(data){
			 					console.log("data.temppw -> " + data.temppw);
			 					console.log("verify_input -> " + verify_input);
			 					if(data.temppw ==  verify_input){
			 						$(".verify_text").html("인증에 성공했습니다").css('color','green');
			 					}else{
			 						$(".verify_text").html("인증에 실패했습니다").css('color','rgb(253, 201, 0)');
			 						$('#verify_input').val("");
			 					}
			 				}
			 			}
			   	 );
		}
	})
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
								<form action="pwFind">
									<div class="input_all">
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">아이디</label>
											<input type="text" class="input" name="name" id="id_input"
												placeholder="아이디를 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">이메일 확인</label>
											<div class="d-flex">
											<input type="text" class="input" name="email" id="email_input"
												placeholder="이메일을 입력해주세요" required />
											<button type="button" class="btn" id="email_btn">
											인증하기</button>
											</div>
										</div>
										
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">인증번호 입력</label>
											<div class="d-flex">
											<input type="text" class="input" name="verifynum" id="verify_input"
												placeholder="인증번호를 입력해주세요" required />
											<button type="button" class="btn" id="verify_btn">
											확인</button></div>
											<div class="verify_text"></div>
										</div>
										<div id="veryfy"></div>
										<button type="submit" class="btn btn-lg btn-block"
											id="pw_btn">비밀번호 변경</button>
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