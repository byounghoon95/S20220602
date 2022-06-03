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
		<p>댓글&nbsp4</p>
		<!-- 상세글 출력 -->
		<c:forEach var="brList" items="${boardReplyList }">
			<!-- 답변쓰기 했을 때 전체가 다 안열리고 하나씩만 열리게끔 하는 로직, i -> default는 0 -->
			<c:set var="i" value="${i + 1 }" />
			<c:choose>
				<c:when
					test="${board.nickname eq brList.nickname && brList.ref_level eq 1}">
					<div class="comment">
						<h6>${brList.nickname }&nbsp&nbsp<img src="images/writer.png"
								id="writer" />
						</h6>
						${brList.boardcontent }
						<p>
							<span id="comment_reply" data-bs-toggle="collapse"
								href="#collapseExample${i }" role="button" aria-expanded="false"
								aria-controls="collapseExample">답글쓰기</span>
						</p>
						<div class="collapse" id="collapseExample${i }">
							<input type="text" id="comment_input" name="comment"
								placeholder="${brList.nickname }에게 답글달기" />
							<div class="d-flex justify-content-end">
								<button type="submit" id="register">등록</button>
							</div>
						</div>
					</div>
					<hr />
				</c:when>
				<c:when
					test="${board.nickname eq brList.nickname && brList.ref_level > 1}">
					<div class="comment1">
						<input type="hidden" name='brListno' value="${brList.boardno }">
						<h6>${brList.nickname }&nbsp&nbsp<img src="images/writer.png"
								id="writer" />
						</h6>
						${brList.boardcontent }
					</div>
					<hr />
				</c:when>
				<c:when
					test="${board.nickname ne brList.nickname && brList.ref_level eq 1}">
					<div class="comment">
						<h6>${brList.nickname }&nbsp&nbsp</h6>
						${brList.boardcontent }
						<p>
							<span id="comment_reply" data-bs-toggle="collapse"
								href="#collapseExample${i }" role="button" aria-expanded="false"
								aria-controls="collapseExample"> 답글쓰기 </span>
						</p>
						<div class="collapse" id="collapseExample${i }">
							<input type="text" id="comment_input" name="comment"
								placeholder="${brList.nickname }에게 답글달기" />
							<div class="d-flex justify-content-end">
								<button type="submit" id="register">등록</button>
							</div>
						</div>
					</div>
					<hr />
				</c:when>
				<c:when
					test="${board.nickname ne brList.nickname && brList.ref_level > 1}">
					<div class="comment1">
					<input type="hidden" name='brListno' value="${brList.boardno }">
						<h6>${brList.nickname }&nbsp&nbsp</h6>
						${brList.boardcontent }
					</div>
					<hr />
				</c:when>
			</c:choose>
		</c:forEach>
		</form>
		<!-- 상세글 끝 -->

	</div>
	<div id="blank"></div>
	
	<div id="blank"></div>
	<%@ include file="footer.jsp"%>
</body>
</html>