<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%
	String context = request.getContextPath();
%>
<meta charset="UTF-8">
<script type="text/javascript">
function replydelete(boardno){
	alert("boardno->"+boardno);
	$.ajax(
			  {
					url:"<%=context%>/replydelete",
					data:{boardno : boardno},
					dataType:'json',
					type:"post",
					success:function(data){
						if (data == 1){
							alert("삭제에 성공했습니다");
						}else{
							alert("삭제에 실패했습니다");
						}
					}
			 	 }
			);
}	
function replyupdate(boardno){
	alert("boardno->"+boardno);
	var boardcontent = $('.comment_'+boardno).val();
	$.ajax(
			  {
					url:"<%=context%>/replyUpdate",
					data:{boardno : boardno, boardcontent:boardcontent},
					dataType:'json',
					type:"post",
					success:function(data){
						if (data == 1){
							alert("수정에 성공했습니다");
						}else{
							alert("수정에 실패했습니다");
						}
					}
			 	 }
			);
}	
</script>
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

<title>Cheese Market</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
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
			<hr /><br><br><br>
			<c:set var="sid" value="${id }" />
			<c:set var="bid" value="${board.id }" />
			<c:choose>
				<c:when test="${sid eq bid}">
					<div id="reg_btn" class="d-flex justify-content-end">
						<button type="button" class="btn btn-warning mx-1" id="revise"
							onclick="location.href='boardUpdateForm?boardno=${board.boardno}'">
							수정</button>
						<button type="button" class="btn btn-warning mx-1" id="delete"
							onclick="location.href='boardDelete?boardno=${board.boardno}'">
							삭제</button>
					</div>
				</c:when>
				<c:otherwise>
					<div id="reg_btn" class="d-flex justify-content-end">
						<!-- <button type="button" class="btn btn-warning mx-1" id="revise" disabled="disabled">
							수정</button>
						<button type="button" class="btn btn-warning mx-1" id="delete" disabled="disabled">
							삭제</button> -->
					</div></c:otherwise>
			</c:choose>


			<h6><a href="mypageOther?id=${board.id }" class="board_id">${board.nickname }</a></h6>
			<hr>
			<br>
			<p>${board.boardcontent }</p>
			<c:choose>
				<c:when test="${id eq null}">
					<p id="view">조회&nbsp${board.boardview }&nbsp&nbsp&nbsp<a id="report">신고</a></p>
				</c:when>
				<c:otherwise>
				<p id="view">조회&nbsp${board.boardview }&nbsp&nbsp&nbsp<a id="report" href="warningForm?boardno=${board.boardno }">신고</a></p>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${id eq null}">
					<p>
				</c:when>
				<c:otherwise>
				 	<hr />
					<h6>댓글</h6>
					<input type="text" id="comment_input" name="comment"
						placeholder="내용을 입력해주세요" />
					<div class="d-flex justify-content-end">
						<button type="submit" id="register">등록</button>
					</div>
				</c:otherwise>
			</c:choose>
			
			<hr />
		</form>

			<p>댓글&nbsp${replycnt }</p>
			<!-- 상세글 출력 -->
			<c:forEach var="ReplyList" items="${boardReplyList }">
				<c:set var="i" value="${i + 1 }" />
				<c:choose>
					<c:when test="${board.nickname eq ReplyList.nickname}">
						<div class="comment">
							<h6>${ReplyList.nickname }&nbsp&nbsp<img
									src="images/writer.png" id="writer" />
							</h6>
							${ReplyList.boardcontent }
						</div>
						<c:set var="Reid" value="${ReplyList.id }"></c:set>
						
						<c:if test="${sid eq Reid }">
							<p>
								<span id="reply_update" data-bs-toggle="collapse"
									href="#collapseExample${i }" role="button" aria-expanded="false"
									aria-controls="collapseExample">수정</span>
								<span id="reply_delete" onclick="replydelete(${ReplyList.boardno})" style="cursor: pointer;">삭제</span>
							</p>
						</c:if>
						<div class="collapse" id="collapseExample${i }">
							<input type="text" id="comment_input" class="comment_input${i } comment_${ReplyList.boardno}" name="boardcontent"
								value="${ReplyList.boardcontent }" />
							<div class="d-flex justify-content-end">
								<button type="button" id="replyupdate" onclick="replyupdate(${ReplyList.boardno})">수정</button>
							</div>
						</div>
						<hr />
					</c:when>
					<c:when test="${board.nickname ne ReplyList.nickname}">
						<div class="comment">
							<h6>${ReplyList.nickname }&nbsp&nbsp</h6>
							${ReplyList.boardcontent }
						</div>
						<c:if test="${sid eq Reid }">
							<p>
								<span id="reply_update" data-bs-toggle="collapse"
									href="#collapseExample${i }" role="button" aria-expanded="false"
									aria-controls="collapseExample">수정</span>
								<span id="reply_delete" onclick="replydelete(${ReplyList.boardno})" style="cursor: pointer;">삭제</span>
							</p>
						</c:if>
						<div class="collapse" id="collapseExample${i }">
							<input type="text" id="comment_input" class="comment_input${i } comment_${ReplyList.boardno}" name="boardcontent"
								value="${ReplyList.boardcontent }" />
							<div class="d-flex justify-content-end">
								<button type="button" id="replyupdate" onclick="replyupdate(${ReplyList.boardno})">수정</button>
							</div>
						</div>
						<hr />
					</c:when>
				</c:choose>
			</c:forEach>
	</div>
	
	<div id="blank"></div>

	<div id="blank"></div>
	<%@ include file="footer.jsp"%>
</body>
</html>