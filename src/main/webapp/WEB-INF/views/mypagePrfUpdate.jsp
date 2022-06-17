<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mypagePrfUpdate.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>

	
	<div class="container mypage_all">
	<h4 class="my_cheese">My 치즈</h4>
		<div class="profile_box">
			
				<div class="left_prf">
					<!-- <img src="images/profile.jpg" class="profile_img" alt="..."> -->
					<img src="${context}/itemImgs/${member.userImg }" class="profile_img" width="200" height="200" >
					<p>
					<a class="prfimgUpd_A" href="#">프로필 이미지 수정</a>
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
												<option value="locno" selected disabled hidden>지역을
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