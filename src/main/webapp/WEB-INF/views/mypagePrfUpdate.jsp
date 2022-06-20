<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<link href="css/mypagePrfUpdate.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
//비밀번호 중복확인
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


</script>

<body>
	
	<div class="container mypage_all">
	<h4 class="my_cheese">My 치즈</h4>
		<div class="profile_box">
			
				<div class="left_prf">
					<!-- <img src="images/profile.jpg" class="profile_img" alt="..."> -->
					<img src="${context}/itemImgs/${member.userImg }" class="profile_img" width="200" height="200" >
					<p>
					<!-- <span class="prfimgUpd_A" href="#">프로필 이미지 수정</span><br> -->
					<div class="file_img"><input type="file" name="userImg" value="${member.userImg }"></div>
				</div>
				
				<div class="right_prf">
					<div class="update_box">
						
						<div class="card-body p-4 p-lg-5 text-black">
							
								<form action="mypagePrfUpdatePro" method="post">
									<div class="input_all">
									
									<span class="prf_name">${member.name } &nbsp&nbsp ${member.id }</span>
									<img src="images/cheese.png" class="cheese_img" alt="..."><p>
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">닉네임</label>
											<input type="text" class="input" name="nickname"
												value="${member.nickname }" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호</label>
											<input type="password" class="input" name="pw" id="pw"  
												placeholder="비밀번호를 입력해주세요" required />
										</div>
										
										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">비밀번호
												확인</label> <input type="password" class="input" name="pwcheck" id="pwcheck" 
												placeholder="비밀번호를 한 번 더 입력해주세요" required />
										</div>
										<span class="pwchk"></span>
										
										

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">이메일</label>
											<input type="text" class="input" name="email"
												value="${member.email }" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">전화번호</label>
											<input type="tel" class="input" name="phone" id="check_input"
												value="${member.phone }" required />
										</div>

										<div class="form-outline mb-4">
											<label class="form-label" for="form2Example27">지역</label>
											<select name="locno" class="input">
												<c:forEach var="locList" items="${locList }">
													<option value="${locList.mcd }" <c:if test ="${member.locno eq locList.mcd}"> selected="selected"</c:if>>${locList.content }</option>
												</c:forEach>
											</select>
											
											
										</div>
										<div>
											<button class="btn btn-lg btn-block" type="submit"
												id="login_btn">수정완료</button>
										</div>
									</div>
								</form>
							</div>
						
						
						
						
						
						
						<!-- <span class="prfUd_list">닉네임 <input type="text" class="input" name="nickname" required="required"> </span><p>
						<span class="prfUd_list">내 지역 <input type="text" class="input" name="locname" required="required"> </span><p>
						<span class="prfUd_list">email <input type="text" class="input" name="email" required="required"> </span><p>
						<span class="prfUd_list">휴대번호 <input type="text" class="input" name="phone" required="required"> </span><p>
						<span class="prfUd_list">비밀번호 <input type="password" class="input" name="pw" required="required"> </span><p>
						<span class="prfUd_list">비밀번호 확인 <input type="password" class="input" name="pw" required="required"> </span><p>
						<button type="button" class="btn btn-warning btn_prf" id="s_btn1" onclick="location.href='/mypagePrfUpdate'">수정 완료</button> -->
					</div>
				</div>
				
			
		</div>
	
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>