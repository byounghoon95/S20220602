<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/boardDetail.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<br><br>
<div class="container">
 <div class="ds"> <h4>
<i class="fa-solid fa-cart-shopping icon_prf icon_mycart"></i> &nbsp카테고리관리</h4> 
</div>
<hr id="sh_hr">
<c:if test="${result > 0  }">
    <h5>category 등록에 성공했습니다</h5>
</c:if>
<P>카테고리 수 : ${total}</P>
  <table class="table" style="text-align:center;">
		<tr>
			<th>NO.</th>
			<th>카테고리</th>
			<th>카테고리명</th>
		</tr>
		 <c:forEach var="common" items="${listAcat}">
		    <c:set var="seq" value="${seq + 1 }"></c:set>
			<tr>
				<td>${seq}</td>
				<c:choose>
					<c:when test="${common.bcd == commBcd900.bcd  }">
					 <td>${commBcd900.content  }</td>
					</c:when>
					<c:when test="${common.bcd == commBcd1000.bcd  }">
					 <td>${commBcd1000.content  }</td>
					</c:when>
					<c:otherwise>
					 <td>   ${common.content} </td>
					</c:otherwise>
				</c:choose>
				
					<c:choose>
					<c:when test="${common.bcd == commBcd900.bcd && common.mcd == commBcd900.mcd  }">
					 <td>${commBcd900.content  }</td>
					</c:when>
					<c:when test="${common.bcd == commBcd1000.bcd && common.mcd == commBcd1000.mcd }">
					 <td>${commBcd1000.content  }</td>
					</c:when>
					<c:otherwise>
					 <td>   ${common.content} </td>
					</c:otherwise>
					</c:choose>
		</c:forEach>		
</table>	
	
		
		<div id="reg_btn" class="d-flex justify-content-end">
				
				<%-- <button type="button" class="btn btn-warning mx-1" id="revise" onclick="location.href='A_MupdateForm?id=${member.id}'">
					수정</button> --%>
				<button type="button" class="btn btn-warning mx-1" id="delete" onclick="location.href='adminCatWriteForm'">
					등록</button>
		</div>		
	<!-- pagination -->
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${pg.startPage > pg.pageBlock }">
							<li class="page-item"><a class="page-link" href="adminCatList?currentPage=${pg.startPage-pg.pageBlock}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${pg.startPage}" end="${pg.endPage}">
							<li class="page-item"><a class="page-link" href="adminCatList?currentPage=${i}"
								id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${pg.endPage < pg.totalPage}">
							<li class="page-item"><a class="page-link" href="adminCatList?currentPage=${pg.startPage+pg.pageBlock}"
								aria-label="Next" id="page_btn"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
				<!-- pagination end-->
			</div>
			<div id="blank"></div>

<%@ include file="adminfooter.jsp" %>
</body>
</html>