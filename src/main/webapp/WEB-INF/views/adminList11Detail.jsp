<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="adminHeader.jsp"%>

<link href="css/adminNoticeDetail.css" rel="stylesheet" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>Insert title here</title>
</head>
<script>
 	$(document).ready(function() {
		$(".register").click(function() {
			var inqno = $(this).val();
			var comment = $(".comment_input"+inqno).val();
			console.log(inqno);
			console.log(comment);
			$(location).attr('href',"rereply?comment=" + comment + "&inqno=" + inqno);
		});
	});
</script>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="adminList11reply">
		<input type="hidden" name='inqno' value="${adminList11.inqno }">
		<input type="hidden" name='id' value="${adminList11.id }"> <input
			type="hidden" name='inqtitle' value="${adminList11.inqtitle }">
		<input type="hidden" name='ref' value="${adminList11.ref }"> <input
			type="hidden" name='ref_step' value="${adminList11.ref_step }">
		<input type="hidden" name='ref_level'
			value="${adminList11.ref_level }">
		<div class="wrap">
			<h4>1 : 1 문의사항</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="revise"
					onclick="location.href='adminList11'">목록</button>
				<button type="button" class="btn btn-warning mx-1" id="delete"
					onclick="location.href='adminList11Delete?inqno=${adminList11.inqno}'">
					삭제</button>
			</div>
			<h6>${adminList11.nickname }</h6>
			<hr>
			<br>
			<p>${adminList11.inqcontent }</p>
			<hr />


			<h6>답변</h6> <input type="text" id="comment_input" name="comment"
					placeholder="내용을 입력해주세요" />
				<div class="d-flex justify-content-end">
					<button type="submit" id="register">등록</button>
				</div>
	</form>

	<form action="adminList11reply">

		<h6>답변</h6>
		<br>
		<!-- 상세글 출력 -->
		<c:forEach var="inqList" items="${adminList11ReplyList }">
			<c:set var="i" value="${i + 1 }" />
			<c:choose>
				<c:when test="${adminList11.nickname eq inqList.nickname}">
					<div class="comment">
						<h6>${inqList.nickname }&nbsp&nbsp<img src="images/writer.png"
								id="writer" />
						</h6>
						${inqList.inqcontent }
					</div>
					<p>
					</p>
					<div class="collapse" id="collapseExample${i }">
						<input type="text" id="comment_input" name="update"
							value="${inqList.inqcontent }" />
						<div class="d-flex justify-content-end">
						</div>
					</div>
					<hr />
				</c:when>
				<c:when test="${adminList11.nickname ne inqList.nickname}">
					<div class="comment">
						<h6>${inqList.nickname }&nbsp&nbsp</h6>
						${inqList.inqcontent }
						<br>
						<span id="reply_update" data-bs-toggle="collapse"
								onclick="location.href='adminList11Delete?inqno=${inqList.inqno}'"
								 role="button" aria-expanded="false"
								aria-controls="collapseExample">삭제</span>
					</div>
					
					<p>
					</p>
					<div class="collapse" id="collapseExample${i }">
						<input type="text" id="comment_input" name="update"
							value="${inqList.inqcontent }" />
						<div class="d-flex justify-content-end">
						</div>
					</div>
					<hr />
				</c:when>
			</c:choose>
		</c:forEach>
	</form>
	</div>
	<div id="blank"></div>
	<div id="blank"></div>
	<%@ include file="adminfooter.jsp"%>
</body>
</html>