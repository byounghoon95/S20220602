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
		alert("예약에 성공했습니다.");
		location.href="reservationDetail?itemno=${itemno}";
	</script>
</c:if>	
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("예약에 실패했습니다.");
		history.go(-1);
	</script>
</c:if>
</body>
</html>