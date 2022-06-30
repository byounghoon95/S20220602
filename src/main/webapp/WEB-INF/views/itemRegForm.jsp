<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/itemRegForm.css" rel="stylesheet">
<title>Cheese Market</title>

</head>
<body>
   <div id="blank"></div>
   <div id="blank_5vh"></div>
   
   <form action="itemReg" method="post" enctype="multipart/form-data">
   <input type="hidden" name="id" value="${id }">
   <div class="wrap">
      <h4>
         <i class="fa-solid fa-clipboard"></i>&nbsp중고거래 글쓰기
      </h4>
      <hr />
      	※가장 첫번째 사진이 대표사진으로 설정됩니다.<br/>
      	
      	<input type="file" name="file1">첫번째 이미지 <p>
		<input type="file" name="file2">두번째 이미지 <p>
		<input type="file" name="file3">세번째 이미지 <p>
		<input type="file" name="file4">네번째 이미지 <p>
		<input type="file" name="file5">다섯번째 이미지 <p>
      <hr />
      <input type="text" id="title_input" name="itemtitle" placeholder="제목" required="required"/>
      <hr />
      <select id="category_input" name="mcd" required="required">
      		<option value="" selected disabled hidden>카테고리를 선택해주세요.</option>
      	<c:forEach var="common" items="${itemCategoryList}" >
      		<option value="${common.mcd}" >${common.content}</option>
      	</c:forEach>
      </select>
      <hr />
      <input type="text" id="cost_input" name="itemcost" placeholder="가격" required="required"/>
      <hr />
      
         <h6>내용</h6>
         <textarea class="mb-4" rows="25" cols="100" wrap="hard" placeholder="${memberLocName}에 올릴 게시글 내용을 작성해주세요. 가품 및 판매금지품목은 게시가 제한될 수 있어요."
            id="content_input" name="itemcontent" required="required"></textarea>
         <div id="reg_btn" class="d-flex justify-content-center">
            <button type="button" class="btn btn-gray mx-1"
               onclick="history.go(-1)">뒤로가기</button>
            <button type="submit" class="btn btn-blue mx-1">등록하기</button>
         </div>
   </div>
   </form>

   <div id="blank"></div>

   <%@ include file="footer.jsp"%>
</body>
</html>
</body>
</html>