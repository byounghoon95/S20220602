<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="css/hf_before.css" rel="stylesheet" />
    <link href="css/memlogin.css" rel="stylesheet" />
<title>Cheese Market</title>
 <body>
    <section class="vh-100">
      <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
          <div class="col col-xl-10">
			<img src="images/admin_logo.png" id="logo" />
            <div class="card" style="border-radius: 1rem">
              <div class="row g-0">
                <div class="col-md-6 col-lg-5 d-none d-md-block">
                  <img
                    src="images/character.png"
                    alt="login form"
                    class="img-fluid"
                    style="border-radius: 1rem 0 0 1rem"
                    id="admincharacter"
                  />
                </div>
                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                  <div class="card-body p-4 p-lg-5 text-black">
                  
                  <div class="adminpage"><a href="login" id="reg">
                        <span id="member_in">일반회원</span>이신가요?</a>
                   	</div>
                  
                    <form action="adminloginPro" method="post">
                      <div class="d-flex align-items-center mb-3 pb-1">
                        <i
                          class="fas fa-cubes fa-2x me-3"
                          style="color: #ff6219"
                        ></i>
                      </div>

                      <div class="form-outline mb-4">
                        <label class="form-label" for="form2Example17"
                          >관리자 아이디</label
                        >
                        <input type="text" id="input1" name="id" required="required"/>
                      </div>

                      <div class="form-outline mb-4">
                        <label class="form-label" for="form2Example27"
                          >패스워드</label
                        >
                        <input type="password" id="input2" name="pw" required="required"/>
                      </div>

                      <div>
                        <button
                          class="btn btn-lg btn-block"
                          type="submit"
                          id="login_btn"
                        >
                          	로그인
                        </button>
                      </div>

                    </form>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
