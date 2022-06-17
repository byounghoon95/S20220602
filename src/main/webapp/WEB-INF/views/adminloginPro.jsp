<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${(member.id == input_id) && (member.pw == input_pw) && (member.nickname == '관리자')}">
	<script type="text/javascript">
		alert("관리자님 환영합니다.");
		location.href="adminmain?id=${input_id}";
	</script>
</c:when>
<c:otherwise>
	<script type="text/javascript">
		alert("관리자 로그인에 실패했습니다.");
		location.href="login";
	</script>
</c:otherwise>
</c:choose>
</body>
</html>