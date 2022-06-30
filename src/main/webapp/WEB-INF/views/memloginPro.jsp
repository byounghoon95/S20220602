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
<c:choose>
<c:when test="${(member.id == input_id) && (member.pw == input_pw)}">
	<script type="text/javascript">
		alert("로그인에 성공했습니다.");
		location.href="main?id=${input_id}";
	</script>
</c:when>
<c:otherwise>
	<script type="text/javascript">
		alert("로그인에 실패했습니다.");
		location.href="login";
	</script>
</c:otherwise>
</c:choose>
</body>
</html>