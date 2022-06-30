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

<link href="css/searchList.css?a242" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#ask').click(function() {
		var cartegori =  $('#cartegori option:selected').val();
		var area 	  =  $('#area  option:selected').val();
		var sendData  = 'cartegori='+cartegori;
		var sendData2 = 'area='+area;
		/* alert('sendData-->'+sendData)  */
		/* alert('sendData2-->'+sendData2)  */
		location.href="searchList?&keyword=${keyword }&"+sendData+"&"+sendData2;
	});
});
function statusChange1( statusItem )
{
   var strText = $(statusItem).text();
   // strText 에 a태그 안의 문자열이 입력된다.
   var sendData  = 'value='+strText;
   location.href="searchList?&keyword=${keyword }&cartegori=${cartegori}&area=${area}&"+sendData;
}

function statusChange2( statusItem )
{
   var strText = $(statusItem).text();
   // strText 에 a태그 안의 문자열이 입력된다.
   var sendData  = 'value='+strText;
   location.href="searchList?&keyword=${keyword }&cartegori=${cartegori}&area=${area}&"+sendData;
}


</script>

<title>Cheese Market</title>
</head>
<body>
	<section id="category">
		
		<div class="check">
			<div class="filter_select">
				<div class="filter">
					<h4>검색필터</h4>
					<div class="filter_ex">원하는 카테고리와 지역을 설정해서 상세 검색을 해보세요 !</div>
				</div>
				<div class="select">
					<div class="item1">
						<h4>카테고리</h4>
						<select id="cartegori" name="cartegori">
							<option value="c_all">전체</option>
							<c:forEach var="listCartegori" items="${listCartegori}">
								<option><c:out value="${listCartegori.content}"></c:out></option>      
							</c:forEach>
						</select>
					</div>
					<div class="area">
						<h4>지역</h4>
							<select id="area" name="area">                                                                                                                                                                                                                                                                                         
								<option value="a_all">전체</option>
								<c:forEach var="listCommon" items="${listCommon}">
									<option><c:out value="${listCommon.content}"></c:out></option>      
								</c:forEach>
							</select>
						<button type="button" class="ask" id="ask">조회</button>
					</div>
				</div>
			</div>
			
			<div class="inquire">
				<img
			      class="img-fluid"
			      src="images/character_market.png"
			      alt="..."
			    /><br>
			</div>
		</div>
		
	</section>
	
		<div class="itemtitle font-size: large" >
          <h2>중고거래</h2>
          <div class="value">
	        	<a id="value1" onclick="statusChange1(this)" name="value" class="value1">추천순</a>&nbsp&nbsp|&nbsp&nbsp<a id="value2" onclick="statusChange2(this)" name="value" class="value2">최신순</a>
	      </div>
        </div>
	
		<div class="items">
	        <div class="container">
				<div class="market_itembox">
					<ul class="faq-list">
						<c:forEach var="listItem" items="${listItem }">
							<li class="li_item">
								<a class="item_detail" href="/itemDetail?itemno=${listItem.itemno }">
									<div class="card item" style="width: 18rem;">
							          <img src="${context}/itemImgs/${listItem.itemimg1 }" class="card-img-top" width="286" height="286" >
							          <div class="card-body">
							            <h5 class="card-title"><div class="card-itemTitle">${listItem.itemtitle }</div></h5>
							            
							           
							            <div class="item_boxbottom">
								            <p class="card-text">
								            	<span>${listItem.itemcost }원</span><br>
								            	<span>서울시&nbsp&nbsp ${listItem.content }</span>
								            </p>
							              
							              <div class="board_icon_view d-flex justify-content-start likechat">
							                <i class="fa-solid fa-heart"></i>&nbsp
							                <span id="heart_cnt">${listItem.itemwish }&nbsp&nbsp</span>
							                <i class="fa-solid fa-eye"></i>&nbsp
							                <span id="reply_cnt">${listItem.itemview }&nbsp&nbsp</span>
							              </div>
							            </div>
							          </div>
							        </div>
							    </a>
							</li>
						</c:forEach>
					</ul>
					<div class="empty_item">
						<c:if test="${empty listItem}">
							<tr>
								<td>
									<center> 검색 조건에 맞는 상품이 없습니다.</center>
								</td>
							</tr>
						</c:if>
					</div>
				</div>
			</div>
	  </div>
            
            <!-- pagination -->
         <nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:if test="${si.startPage > si.pageBlock }">
							<li class="page-item"><a class="page-link" href="searchList?currentPage=${si.startPage-si.pageBlock}&keyword=${keyword }&cartegori=${cartegori}&area=${area}&value=${value}"
								aria-label="Previous" id="page_btn"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
						</c:if>
						<c:forEach var="i" begin="${si.startPage}" end="${si.endPage}">
							<li class="page-item"><a class="page-link" href="searchList?currentPage=${i}&keyword=${keyword }&cartegori=${cartegori}&area=${area}&value=${value}"
								id="page_btn">${i}</a></li>
						</c:forEach>
						<c:if test="${si.endPage < si.totalPage }">
							<li class= "page-item"><a class="page-link" href="searchList?currentPage=${si.startPage+si.pageBlock}&keyword=${keyword }&cartegori=${cartegori}&area=${area}&value=${value}"
								aria-label="Next" id="page_btn"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</c:if>
					</ul>
				</nav>
          <!-- pagination end-->
          
          
    
	<%@ include file="footer.jsp"%>
</body>
</html>







