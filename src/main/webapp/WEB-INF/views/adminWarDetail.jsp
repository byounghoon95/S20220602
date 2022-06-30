<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<script type="text/javascript"
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<link href="css/adminWarDetail.css?after" rel="stylesheet" />
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
   // 모달창 
   // 모달창id얻기
    var modal = document.getElementById('dtsch_modal1');
    // 클릭id얻기
    var btn = document.getElementById("first_btn2");
    // 닫기
    var close = document.getElementsByClassName("modal_close")[0];                                          
    //검색버튼클릭시 모달창 block
    btn.onclick = function() {
        modal.style.display = "block";
    }
    // close_btn클릭시 모달창none
    close.onclick = function() {
        modal.style.display = "none";
    }
    // 모달창외 클릭시 모달 닫힘
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
});
</script>
<body>
   <div id="blank"></div>
   <div id="blank_5vh"></div>

   <form>
      <input type="hidden" name='boardno' value="${warning.boardno }">
      <input type="hidden" name='itemno' value="${warning.itemno }">   
      <div class="wrap">
         <h4>신고상세 </h4>
         
            <div id="reg_btn" class="d-flex justify-content-end">
            
               
               <c:choose>
                        <c:when test="${warning.boardno !=0 }">
                           <a href="A_BoardDetail?boardno=${warning.boardno}&warno=${warning.warno}" class="btn btn-primary itembtn">해당글로 이동</a>
                        </c:when>                   
                        <c:when test="${warning.itemno != 0 }">
                           <a href="A_itemDetail?itemno=${warning.itemno}" class="btn btn-primary itembtn">해당상품으로 이동</a>
                       </c:when>
                       <c:when test="${warning.smcd == 803 }">
                           <a href="A_Mdetail?id=${warning.warnid}" class="btn btn-primary itembtn">해당회원으로 이동</a>
                       </c:when>
                       <c:when test="${warning.boardno ==0 }">
                           <a href="#" class="btn btn-primary itembtn">※해당글 삭제됨</a>
                        </c:when>
                        <c:when test="${warning.boardno ==0 }">
                           <a href="#" class="btn btn-primary itembtn">※해당 상품 삭제됨</a>
                        </c:when>
                     </c:choose>
         </div>
         <hr />
      
         
          <table class="table">
         <tr>
         <th>신고번호</th><td>${warning.warno}</td>
         <th>작성일</th><td>${warning.wardate}</td>
         <th>신고내용</th><td>${warning.content}</td>
         </tr>
         <tr>
         <%-- <th>신고분류</th><td>${warning.smcd}</td> --%>
         <th>신고할 ID</th><td><a href="A_Mdetail?id=${warning.warnid}" >${warning.warnid}</td>
         <th>작성자</th><td><a href="A_Mdetail?id=${warning.id}" style="color:blue;">${warning.id}</td>
         <th>처리상태</th><td>${warning.warstatus}</td>
         </tr>
         </table>
      
         
         <br>
         <p> ${warning.warcontent}</p>
         <br>
      <%--    <img src="${warning.warimg}/itemImgs/${itemimg1 }"> --%>
         <hr />
         <div>
            <button type="button" class="btn btn-warning" id="first_btn"
               onclick="location.href='adminWarList'">목록</button>
            <button type="button" class="btn btn-warning" id="first_btn2">확인</button>
                     
         </div>
         
         
      </div>
      <div id="blank"></div>
   </form>
   <div id="blank"></div>
   <form method="post" action="wsupdate">    
      <div id="dtsch_modal1" class="dtsch_modal modal">
         <div class="modal-cnt">
             <span class="modal_close">&times;</span>                                                               
              <p class="tit">처리상태를 확인해주세요</p>
              <div class="m-content">
                 <input type="hidden" name="warno" value="${warning.warno}"> 
                 <input type="radio" name="warstatus" value="Y">처리
                <input type="radio" name="warstatus" value="N" checked="checked">미처리
                <p><input type="submit" class="modal-btn" value="확인"> 
                   <input type="reset"  class="modal-btn" value="Reset"></p>
            </div>
         </div>
      </div>
   </form>
   





<%@ include file="adminfooter.jsp" %>
</body>
</html>
