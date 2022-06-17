<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- header -->
<c:choose>
<c:when test="${id == null}">
	<%@ include file="header.jsp"%>
</c:when>
<c:otherwise>
	<%@ include file="header_mem.jsp"%>
</c:otherwise>
</c:choose>

<link href="css/boardDetail.css" rel="stylesheet" />

<title>Insert title here</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<script>
 	$(document).ready(function() {
		$(".register").click(function() {
			var boardno = $(this).val();
			var comment = $(".comment_input"+boardno).val();
			console.log(boardno);
			console.log(comment);
			$(location).attr('href',"rereply?comment=" + comment + "&boardno=" + boardno);
		});
	});
</script>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>


		<div class="wrap">
		<form action="reply">
			<input type="hidden" name='boardno' value="${board.boardno }">
			<input type="hidden" name='id' value="${board.id }"> <input
				type="hidden" name='boardtitle' value="${board.boardtitle }">
			<input type="hidden" name='ref' value="${board.ref }"> <input
				type="hidden" name='ref_step' value="${board.ref_step }"> <input
				type="hidden" name='ref_level' value="${board.ref_level }">
			<h4>치즈 일상</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="revise"
					onclick="location.href='boardUpdateForm?boardno=${board.boardno}'">
					수정</button>
				<button type="button" class="btn btn-warning mx-1" id="delete"
					onclick="location.href='boardDelete?boardno=${board.boardno}'">
					삭제</button>
			</div>
			<h6>${board.nickname }</h6>
			<hr>
			<br>
			<p>${board.boardcontent }</p>
			<p id="view">조회&nbsp${board.boardview }</p>
			<hr />
			<h6>댓글</h6>
			<input type="text" id="comment_input" name="comment"
				placeholder="내용을 입력해주세요" />
			<div class="d-flex justify-content-end">
				<button type="submit" id="register">등록</button>
			</div>
			<hr />
		</form>



		<form action="reply">
			<p>댓글&nbsp${replycnt }</p>
			<!-- 상세글 출력 -->
			<c:forEach var="brList" items="${boardReplyList }">
				<c:set var="i" value="${i + 1 }" />
				<c:choose>
					<c:when test="${board.nickname eq brList.nickname}">
						<div class="comment">
							<h6>${brList.nickname }&nbsp&nbsp<img
									src="images/writer.png" id="writer" />
							</h6>
							${brList.boardcontent }
						</div>
						<p>
							<span id="reply_update" data-bs-toggle="collapse"
								href="#collapseExample${i }" role="button" aria-expanded="false"
								aria-controls="collapseExample">수정</span>
							<span id="reply_delete" href="#collapseExample${i }">삭제</span>
						</p>
						<div class="collapse" id="collapseExample${i }">
							<input type="text" id="comment_input" name="update"
								value="${brList.boardcontent }" />
							<div class="d-flex justify-content-end">
								<button type="submit" id="update">수정</button>
							</div>
						</div>
						<hr />
					</c:when>
					<c:when test="${board.nickname ne brList.nickname}">
						<div class="comment">
							<h6>${brList.nickname }&nbsp&nbsp</h6>
							${brList.boardcontent }
						</div>
						<p>
							<span id="reply_update" data-bs-toggle="collapse"
								href="#collapseExample${i }" role="button" aria-expanded="false"
								aria-controls="collapseExample">수정</span>
							<span id="reply_delete" href="#collapseExample${i }">삭제</span>
						</p>
						<div class="collapse" id="collapseExample${i }">
							<input type="text" id="comment_input" name="update"
								value="${brList.boardcontent }" />
							<div class="d-flex justify-content-end">
								<button type="submit" id="update">수정</button>
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
	<%@ include file="footer.jsp"%>
</body>
</html>