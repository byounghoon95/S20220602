<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h4>처리상태를 확인해주세요</h4>
   <form method="post" action="wsupdate">	 
	   	<!-- pk hidden setting --> 
	   	<input type="hidden" name="warno" value="${warning.warno}"> 
	   	
	 	<input type="radio" name="warstatus" value="Y">처리
		<input type="radio" name="warstatus" value="N" checked="checked">미처리
		<p><input type="submit" value="확인"> 
		<input type="reset" value="Reset"></p>
   </form>
</div>
</body>
</html>