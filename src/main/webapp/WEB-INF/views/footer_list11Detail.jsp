<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header_mem.jsp"%>
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

	<form action="List11reply">
		<input type="hidden" name='inqno' value="${footer_list11.inqno }">
		<input type="hidden" name='id' value="${footer_list11.id }">
		<input type="hidden" name='inqtitle' value="${footer_list11.inqtitle }">

		<div class="wrap">
			<h4>1 : 1 문의하기</h4>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="delete" onclick="location.href='footer_list11'">목록</button>
			</div>
			<h6>${list11.nickname }</h6>
			<hr><br>
			<p>${list11.inqcontent }</p>
			<hr />
			<div id="reg_btn" class="d-flex justify-content-end">
				<button type="button" class="btn btn-warning mx-1" id="revise"
					onclick="location.href='footer_list11UpdateForm?inqno=${list11.inqno}'">
					수정</button>
				<button type="button" class="btn btn-warning mx-1" id="delete"
					onclick="location.href='footer_list11Delete?inqno=${list11.inqno}'">
					삭제</button>
			<hr><br>
				
			</div>
		<form action="List11reply">
		<hr><br>
		<!-- 상세글 출력 -->
		<c:forEach var="inqList" items="${list11ReplyList }">
			<c:set var="i" value="${i + 1 }" />
			<c:choose>
				<c:when test="${List11.nickname eq inqList.nickname}">
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
				
			</c:choose>
		</c:forEach>
	</form>
		</div>
		<div id="blank"></div>
		
	</form>
	<div id="blank"></div>
<%@ include file="footer.jsp"%>
</body>
</html>