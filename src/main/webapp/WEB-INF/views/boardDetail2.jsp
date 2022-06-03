<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/boardDetail.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="blank"></div>
	<div id="blank_5vh"></div>

	<form action="reply">
		<input type="hidden" name='boardno' value="${board.boardno }">
		<input type="hidden" name='id' value="${board.id }"> 
		<input type="hidden" name='boardtitle' value="${board.boardtitle }">
		<input type="hidden" name='ref' value="${board.ref }">
		<input type="hidden" name='ref_step' value="${board.ref_step }"> 
		<input type="hidden" name='ref_level' value="${board.ref_level }">
		<div class="wrap">
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
			<!-- 상세글 출력 -->
			<c:forEach var="brList" items="${boardReplyList }">
				<c:choose>
					<c:when test="${board.nickname == brList.nickname} ">
						<div class="comment">
						<h6>${board.nickname }&nbsp&nbsp<img src="images/writer.png" id="writer" /></h6>
						${brList.boardcontent }
						</div>
						<hr />
					</c:when>
					<c:otherwise>
						<div class="comment">
						<h6>${brList.nickname }</h6>
						${brList.boardcontent }
						</div>
						<hr />
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			
 			<div class="comment">
				<h6>
					${board.nickname }&nbsp&nbsp<img src="images/writer.png" id="writer" />
				</h6>
				이 제습기 가격은 위닉스라서 좀 비싸게 샀습니다<br />
				<p>
					<span id="comment_reply" data-bs-toggle="collapse"
						href="#collapseExample" role="button" aria-expanded="false"
						aria-controls="collapseExample"> 답글쓰기 </span>
				</p>
				<div class="collapse" id="collapseExample">
					<input type="text" id="comment_input" name="comment" placeholder="내용을 입력해주세요" />
					<div class="d-flex justify-content-end">
						<button type="submit" id="register">등록</button>
					</div>
				</div>
			</div>
			<hr />

			<!-- 상세글 끝 -->
			<h6>댓글</h6>
			<input type="text" id="comment_input" name="comment"
				placeholder="내용을 입력해주세요" />
			<div class="d-flex justify-content-end">
				<button type="submit" id="register">등록</button>
			</div>
			<hr />
		</div>
		<div id="blank"></div>
	</form>
	<div id="blank"></div>
	<%@ include file="footer.jsp"%>
</body>
</html>