<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cheese Market</title>
</head>
<body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("신고가 완료되었습니다.");
		location.href="market";
	</script>
</c:if>	
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("신고 등록에 실패 하였습니다.");
		history.go(-1);
	</script>
</c:if>
</body>
</html>