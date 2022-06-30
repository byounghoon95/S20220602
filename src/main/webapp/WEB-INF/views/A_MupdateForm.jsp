<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/Amain.css?123" rel="stylesheet">
</head>
<body>
<div id="blank"></div>
<div class="container">
<div class="wrap">
<h4>회원정보</h4> 
<form action="update" method="post">
  <input type="hidden" name="id" value="${member.id}">
         
  <table class="table"> 
   <tr><th>아이디</th><td>${member.id }</td></tr>
   <tr><th>이름</th><td>${member.name}</td></tr>
   <tr><th>참여</th><td>${member.participation}</td></tr>
   <tr><th>경고횟수</th><td>
        <input type="number" name="warningcnt" required="required" value="${member.warningcnt}"></td></tr>
   <tr><th>회원상태</th><td>
       ${member.content}</td></tr>
   <tr><th></th><td>
       <select id="category_input" name="mcd" required="required">
            <option value="" selected disabled hidden>회원상태를 선택해주세요.</option>
         <c:forEach var="common" items="${memberStatusList}" >
            <option value="${common.mcd}" >${common.content}</option>
         </c:forEach>
      </select> 
      </td></tr>
     </table>
     
     <div id="reg_btn" class="d-flex justify-content-center">
     <button type="submit" class="btn btn-warning mx-1" id="bt1">확인</button>
      <!-- <input type="submit" value="확인"> -->
     </div>
      </div>
</form>
</div>

<div id="blank"></div>
<div id="blank"></div>
<%@ include file="adminfooter.jsp" %>
</body>
</html>