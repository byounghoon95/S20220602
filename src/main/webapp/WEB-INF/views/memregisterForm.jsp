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
<link href="css/memregister.css" rel="stylesheet" />
<title>Cheese Market</title>
</head>
<script type="text/javascript">
//아이디 중복확인
function idCheck() {
	var id_input = $('#id_input').val();
	 $.ajax(
   		 {
 				url:'<%=context%>/idCheck',
 				type:"post",
 				data:{"id" : id_input},
 				dataType:'text',
 				success:function(data){
 					if(data == "redundancy"){
 						$('.idchk').html("중복된 아이디입니다").css('color','rgb(253, 201, 0)');
 						$('#id_input').val("");
 					}else if(data =="noredundancy"){
 						$('.idchk').html("사용가능한 아이디입니다").css('color','green');;
 					}else{
 						$('.idchk').html("아이디를 입력해주세요").css('color','rgb(253, 201, 0)');
 					}
 				}
 			}
   	 );
}
//비밀번호 유효성 검사
$(document).ready(function() {
	$('#pw').blur(function() {
		var pw = $('#pw').val();
		var num = pw.search(/[0-9]/g);
		var eng = pw.search(/[a-z]/ig);
		var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		if($('#pw').val().length < 8 || $('#pw').val().length > 16){
			$('.pwchk1').html("비밀번호는 8 ~ 16자리 사이로 입력해주세요").css('color','rgb(253, 201, 0)');
			$('#pw').val("");
		}else{
			if(num < 0 || eng < 0 || spe < 0){
				$('.pwchk1').html("비밀번호는 문자, 숫자, 특수문자의 조합으로 입력해주세요").css('color','rgb(253, 201, 0)');
				$('#pw').val("");
			}else{
				$('.pwchk1').html("사용가능한 비밀번호입니다").css('color','green');
			}
		};
	});
})
// 비밀번호 중복확인
$(document).ready(function() {
	$('#pwcheck').blur(function() {
		if($('#pw').val() != $('#pwcheck').val()){
			$('.pwchk').html("비밀번호가 일치하지 않습니다").css('color','rgb(253, 201, 0)');
			$('#pwcheck').val("");
		}else{
			$('.pwchk').html("비밀번호가 일치합니다").css('color','green');
		}
	});
})
$(document).ready(function() {
	$('#nickname').blur(function() {
		var pattern_num = /[0-9]/;	// 숫자 
		var pattern_eng = /[a-zA-Z]/;	// 문자 
		var pattern_spc = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자
		var pattern_kor = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글체크
		if(pattern_kor.test($('#nickname').val()) && !(pattern_eng.test($('#nickname').val()))
				&& !(pattern_spc.test($('#nickname').val())) && !(pattern_num.test($('#nickname').val()))){
			$('.nicknamechk').html("사용가능한 닉네임입니다").css('color','green');		
		}else{
			$('.nicknamechk').html("한글로 입력해주세요").css('color','rgb(253, 201, 0)');
			$('#nickname').val("");
		}
	});
})
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
								<form action="register">
									<div class="input_all">
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example17">아이디</label>
											<div class="d-flex">
												<input type="text" class="input" name="id" id="id_input"
													placeholder="아이디를 입력해주세요" required />
												<button type="button" class="btn" id="check_btn" onclick="idCheck()">
													중복확인</button>
											</div>
										</div>
										<span class="idchk"></span>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">닉네임</label>
											<input type="text" class="input" name="nickname" id="nickname"
												placeholder="닉네임을 입력해주세요" required />
										</div>
										<span class="nicknamechk"></span>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">이름</label>
											<input type="text" class="input" name="name"
												placeholder="이름을 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호</label>
											<input type="password" class="input" name="pw" id="pw" 
											placeholder="비밀번호를 입력해주세요" required />
										</div>
										<span class="pwchk1"></span>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호
												확인</label> <input type="password" class="input" name="pwcheck" id="pwcheck" 
												placeholder="비밀번호를 한 번 더 입력해주세요" required />
										</div>
										<span class="pwchk"></span>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">이메일</label>
											<input type="text" class="input" name="email"
												placeholder="이메일을 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">전화번호</label>
											<input type="tel" class="input" name="phone" id="check_input"
												placeholder="예) 010-1234-5678" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">지역</label>
											<select name="locno" class="input">
												<option value="" selected disabled hidden>지역을
													선택해주세요</option>
												<c:forEach var="locList" items="${locList }">
													<option value="${locList.mcd }">${locList.content }</option>
												</c:forEach>
											</select>
										</div>
										<div>
											<button class="btn btn-lg btn-block" type="submit"
												id="login_btn">회원가입</button>
										</div>
										<br /> <a href="login" id="reg">이미
											계정이 있습니까?&nbsp <span id="reg_in">로그인</span>하세요
										</a><br />
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