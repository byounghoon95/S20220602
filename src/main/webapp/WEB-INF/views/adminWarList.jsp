<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <br>
	<div class="container">
	 <div class="ds">
	 <h4>
	 <i class="fa-solid fa-circle-exclamation"></i> &nbsp신고관리</h4>
	 </div>
 	 <hr>
	 <P>신고 수 : ${total}</P>

<c:set var="num" value="${pg.total-pg.start+1}"></c:set>
<table class="table" style="text-align:center; ">
	
		<tr>
			<th>NO.</th>
			<th>신고번호</th>
			<!-- <th>신고할ID</th> -->
			<th>신고사유</th>
			<th>작성일</th>
			<th>작성자</th>
			<!-- <th>신고분류</th> -->
			<th>처리상태</th>
		</tr>
		<c:forEach var="warning" items="${listWarning}">
		<c:set var="seq" value="${seq + 1 }"></c:set>
			<tr>
				<td>${seq}</td>
				<td><a href="adminWarDetail?warno=${warning.warno}">${warning.warno}</a></td>
			<%-- 	<td>${warning.warnid}</td> --%>
				<td>${warning.content}</td>
				<td>${warning.wardate}</td>
				<td>${warning.id }</td>
				<%-- <td>${warning.warnCatName}</td> --%>
				<td>${warning.warstatus }</td>
				
			</tr>
		</c:forEach>
	</table>

				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${pg.startPage > pg.pageBlock }">
							<li class="page-item"><a class="page-link" href="adminWarList?currentPage=${pg.startPage-pg.pageBlock}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
							<li class="page-item"><a class="page-link" href="adminWarList?currentPage=${i}"
								id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${pg.endPage < pg.totalPage }">
							<li class="page-item"><a class="page-link" href="adminWarList?currentPage=${pg.startPage+pg.pageBlock}"
								aria-label="Next" id="page_btn"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>


</div>
<%@ include file="adminfooter.jsp" %>
</body>
</html>