<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/market.css" rel="stylesheet" />

<title>Cheese Market</title>
</head>
<body id="page-top">
    <main>

        <section id="scroll">
            <div class="container px-5" id="first_body">
              <div class="row gx-5 align-items-center">
                <div class="col-lg-6 order-lg-2">
                    <div class="p-5">
                        <h4 class="categorytitle">카테고리</h4><br>
                        <ul>
                            <div class="maincategory">
                                <div class="maincategory_left">
                                    <li><a href="#">전체</a></li>
                                    <li><a href="#">디지털기기</a></li>
                                    <li><a href="#">가구/인테리어</a></li>
                                    <li><a href="#">생활/가공식품</a></li>
                                    <li><a href="#">스포츠/레저</a></li>
                                </div>
                                <div class="maincategory_right">
                                    <li><a href="#">의류</a></li>
                                    <li><a href="#">뷰티/미용</a></li>
                                    <li><a href="#">도서</a></li>
                                    <li><a href="#">기타</a></li>
                                    <li><a href="#">삽니다</a></li>
                                </div>
                            </div>
                          </ul><br><br>
                          
                          <button type="button" class="btn btn-warning sellbtn" id="start">내 물건 팔기</button>

                      </div>
                </div>
                <div class="col-lg-6 order-lg-1">

                  <div class="p-5">
                    <img
                      class="img-fluid"
                      src="images/character_market.png"
                      alt="..."
                      id="character"
                    />
                  </div>
                </div>              
              </div>
            </div>
          </section>

        
        
  
        <center>
        <div class="itemtitle font-size: large" >
          <h2>오늘의 인기상품</h2>
        </div>
      </center>
  
        <div class="items">

        <div class="card item" style="width: 18rem;">
          <img src="images/cheese.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
           
            <div class="item_boxbottom">
            <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
            
            <div class="board_icon_view d-flex justify-content-start likechat">
              <i class="fa-solid fa-heart"></i>&nbsp
              <span id="heart_cnt">5&nbsp&nbsp</span>
              <i class="fa-solid fa-comments"></i>&nbsp
              <span id="reply_cnt">5</span>
            </div>
          </div>

          </div>
        </div>

  
        <div class="card item" style="width: 18rem;">
          <img src="images/cheese.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
           
            <div class="item_boxbottom">
              <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
              
              <div class="board_icon_view d-flex justify-content-start likechat">
                <i class="fa-solid fa-heart"></i>&nbsp
                <span id="heart_cnt">5&nbsp&nbsp</span>
                <i class="fa-solid fa-comments"></i>&nbsp
                <span id="reply_cnt">5</span>
              </div>
            </div>


          </div>
        </div>
  
        <div class="card item" style="width: 18rem;">
          <img src="images/cheese.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            

            <div class="item_boxbottom">
              <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
              
              <div class="board_icon_view d-flex justify-content-start likechat">
                <i class="fa-solid fa-heart"></i>&nbsp
                <span id="heart_cnt">5&nbsp&nbsp</span>
                <i class="fa-solid fa-comments"></i>&nbsp
                <span id="reply_cnt">5</span>
              </div>
            </div>



          </div>
        </div>
  
        <div class="card item" style="width: 18rem;">
          <img src="images/cheese.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Card title</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
           
            <div class="item_boxbottom">
              <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
              
              <div class="board_icon_view d-flex justify-content-start likechat">
                <i class="fa-solid fa-heart"></i>&nbsp
                <span id="heart_cnt">5&nbsp&nbsp</span>
                <i class="fa-solid fa-comments"></i>&nbsp
                <span id="reply_cnt">5</span>
              </div>
            </div>


          </div>
        </div>
  
        </div>
  
  
  
  
       
        <center>
        <div class="itemtitle">
          <h2>전체 상품</h2>
        </div>
      </center>
  

        <div class="items">
          <div class="card item" style="width: 18rem;">
            <img src="images/cheese.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              

              <div class="item_boxbottom">
                <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                
                <div class="board_icon_view d-flex justify-content-start likechat">
                  <i class="fa-solid fa-heart"></i>&nbsp
                  <span id="heart_cnt">5&nbsp&nbsp</span>
                  <i class="fa-solid fa-comments"></i>&nbsp
                  <span id="reply_cnt">5</span>
                </div>
              </div>
              
            </div>
          </div>
    
          <div class="card item" style="width: 18rem;">
            <img src="images/cheese.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              
              <div class="item_boxbottom">
                <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                
                <div class="board_icon_view d-flex justify-content-start likechat">
                  <i class="fa-solid fa-heart"></i>&nbsp
                  <span id="heart_cnt">5&nbsp&nbsp</span>
                  <i class="fa-solid fa-comments"></i>&nbsp
                  <span id="reply_cnt">5</span>
                </div>
              </div>


            </div>
          </div>
    
          <div class="card item" style="width: 18rem;">
            <img src="images/cheese.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              
              <div class="item_boxbottom">
                <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                
                <div class="board_icon_view d-flex justify-content-start likechat">
                  <i class="fa-solid fa-heart"></i>&nbsp
                  <span id="heart_cnt">5&nbsp&nbsp</span>
                  <i class="fa-solid fa-comments"></i>&nbsp
                  <span id="reply_cnt">5</span>
                </div>
              </div>


            </div>
          </div>
    
          <div class="card item" style="width: 18rem;">
            <img src="images/cheese.png" class="card-img-top" alt="...">
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              
              <div class="item_boxbottom">
                <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                
                <div class="board_icon_view d-flex justify-content-start likechat">
                  <i class="fa-solid fa-heart"></i>&nbsp
                  <span id="heart_cnt">5&nbsp&nbsp</span>
                  <i class="fa-solid fa-comments"></i>&nbsp
                  <span id="reply_cnt">5</span>
                </div>
              </div>

            </div>
          </div>
          </div>

          <div class="items">
            <div class="card item" style="width: 18rem;">
              <img src="images/cheese.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
               

                <div class="item_boxbottom">
                  <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                  
                  <div class="board_icon_view d-flex justify-content-start likechat">
                    <i class="fa-solid fa-heart"></i>&nbsp
                    <span id="heart_cnt">5&nbsp&nbsp</span>
                    <i class="fa-solid fa-comments"></i>&nbsp
                    <span id="reply_cnt">5</span>
                  </div>
                </div>
                
              </div>
            </div>
      
            <div class="card item" style="width: 18rem;">
              <img src="images/cheese.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                
                <div class="item_boxbottom">
                  <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                  
                  <div class="board_icon_view d-flex justify-content-start likechat">
                    <i class="fa-solid fa-heart"></i>&nbsp
                    <span id="heart_cnt">5&nbsp&nbsp</span>
                    <i class="fa-solid fa-comments"></i>&nbsp
                    <span id="reply_cnt">5</span>
                  </div>
                </div>


              </div>
            </div>
      
            <div class="card item" style="width: 18rem;">
              <img src="images/cheese.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                
                <div class="item_boxbottom">
                  <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                  
                  <div class="board_icon_view d-flex justify-content-start likechat">
                    <i class="fa-solid fa-heart"></i>&nbsp
                    <span id="heart_cnt">5&nbsp&nbsp</span>
                    <i class="fa-solid fa-comments"></i>&nbsp
                    <span id="reply_cnt">5</span>
                  </div>
                </div>


              </div>
            </div>
      
            <div class="card item" style="width: 18rem;">
              <img src="images/cheese.png" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">Card title</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
               
                <div class="item_boxbottom">
                  <a href="#" class="btn btn-primary itembtn">상품 보러가기</a>
                  
                  <div class="board_icon_view d-flex justify-content-start likechat">
                    <i class="fa-solid fa-heart"></i>&nbsp
                    <span id="heart_cnt">5&nbsp&nbsp</span>
                    <i class="fa-solid fa-comments"></i>&nbsp
                    <span id="reply_cnt">5</span>
                  </div>
                </div>


              </div>
            </div>
            </div>



  
         <!-- pagination -->
         <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
              <li class="page-item">
                <a
                  class="page-link"
                  href="#"
                  aria-label="Previous"
                  id="page_btn"
                >
                  <span aria-hidden="true">&laquo;</span>
                </a>
              </li>
              <li class="page-item">
                <a class="page-link" href="#" id="page_btn">1</a>
              </li>
              <li class="page-item">
                <a class="page-link" href="#" id="page_btn">2</a>
              </li>
              <li class="page-item">
                <a class="page-link" href="#" id="page_btn">3</a>
              </li>
              <li class="page-item">
                <a class="page-link" href="#" aria-label="Next" id="page_btn">
                  <span aria-hidden="true">&raquo;</span>
                </a>
              </li>
            </ul>
          </nav>
          <!-- pagination end-->
	</main>

<%@ include file="footer.jsp" %>
</body>
</html>