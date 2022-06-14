<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String context = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<link href="css/hf_before.css" rel="stylesheet" />
<link href="css/memregister.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
function memidCheck(Vdeptno) {
	 console.log(Vdeptno);
	 $.ajax(
   		 {
 				url:"<%=context%>/getDeptName",  
 				data:{deptno : Vdeptno},
 				dataType:'text',
 				success:function(minJu){
 				//	alert("success ajax Data->"+data); 
 					$('#deptName').val(minJu);     /*  input Tag */
 					$('#msg').html(minJu);         /* span  id Tag */
 				}
 			}
   	 );   	 

}

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
											<label class="form-label" for="form2Example17">아이디</label>
											<div class="d-flex">
												<input type="text" class="input" name="id" id="id_input"
													placeholder="아이디를 입력해주세요" required />
												<button type="button" class="btn" id="check_btn">
													중복확인</button>
											</div>
										</div>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">닉네임</label>
											<input type="text" class="input" name="nickname"
												placeholder="닉네임을 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">이름</label>
											<input type="text" class="input" name="name"
												placeholder="이름을 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호</label>
											<input type="password" class="input" name="pw"
												placeholder="비밀번호를 입력해주세요" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호
												확인</label> <input type="password" class="input" name="pwcheck"
												placeholder="비밀번호를 한 번 더 입력해주세요" required />
										</div>

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
												<option value="1101">강남구</option>
												<option value="1102">강동구</option>
												<option value="1103">강북구</option>
												<option value="1104">강서구</option>
												<option value="1105">관악구</option>
												<option value="1106">광진구</option>
												<option value="1107">구로구</option>
												<option value="1108">금천구</option>
												<option value="1109">노원구</option>
												<option value="1110">도봉구</option>
												<option value="1111">동대문구</option>
												<option value="1112">동작구</option>
												<option value="1113">마포구</option>
												<option value="1114">서대문구</option>
												<option value="1115">서초구</option>
												<option value="1116">성동구</option>
												<option value="1117">성북구</option>
												<option value="1118">송파구</option>
												<option value="1119">양천구</option>
												<option value="1120">영등포구</option>
												<option value="1121">용산구</option>
												<option value="1122">은평구</option>
												<option value="1123">종로구</option>
												<option value="1124">중구</option>
												<option value="1125">중랑구</option>
											</select>
										</div>
										<div>
											<button class="btn btn-lg btn-block" type="button"
												id="login_btn" onclick="register">회원가입</button>
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