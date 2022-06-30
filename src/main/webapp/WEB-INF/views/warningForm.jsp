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
   
   <form action="warningReg" method="post" enctype="multipart/form-data">
	   <input type="hidden" name="id" value="${warning.id }"><!-- 신고글 작성자 id -->
	   <input type="hidden" name="warnid" value="${warning.warnid }">
	   <input type="hidden" name="itemno" value="${warning.itemno }">
	   <input type="hidden" name="boardno" value="${warning.boardno }">
	   <div class="wrap">
	      <h4>
	         <i class="fa-solid fa-clipboard"></i>&nbsp신고하기
	      </h4>
	      <hr />
	      	※신고에 도움이 되는 사진을 올려주세요.<br/>
	      	<!-- <input type="file" name="itemimg1"> -->
			
	      <hr />
	      <h6>
	         ${warnNickname}님을 신고하는 이유를 선택해주세요.
	      </h6>
	      <hr />
	      <select id="category_input" name="mcd" required="required">
	      		<option value="" selected disabled hidden>신고사유를 선택해주세요.</option>
	      	<c:forEach var="common" items="${reportCategoryList}" >
	      		<option value="${common.mcd}" >${common.content}</option>
	      	</c:forEach>
	      </select>
	      <hr />
	         <textarea class="mb-4" rows="25" cols="100" placeholder="자세한 신고 사유를 작성해주세요. 허위로 신고할 경우 경고처리 될 수 있어요."
	            id="content_input" name="warcontent" required="required"></textarea>
	         <div id="reg_btn" class="d-flex justify-content-center">
	            <button type="button" class="btn btn-gray mx-1"
	               onclick="history.go(-1)">뒤로가기</button>
	            <button type="submit" class="btn btn-blue mx-1">등록하기</button>
	         </div>
	       <hr />
	   </div>
   </form>

   <div id="blank"></div>

   <%@ include file="footer.jsp"%>
</body>
</html>
</body>
</html>