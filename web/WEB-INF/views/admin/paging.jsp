<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.page-link {
	position: relative;
    display: inline;
    padding: .5rem .75rem;
    margin-left: 0px;
    margin-right: 5px;
    line-height: 1.25;
    color: #02A79D;
    background-color: #ECFFFE;
    border: 1px solid #e6e6f2;
    border-radius: 3px;
    line-height: 1;
}
 .page-link-disabled {
 	opacity: 0.6;
 	cursor: disabled;
 	position: relative;
    display: inline;
    padding: .5rem .75rem;
    margin-left: 0px;
    margin-right: 5px;
    line-height: 1.25;
    color: #02A79D;
    border: 1px solid #e6e6f2;
    border-radius: 3px;
    line-height: 1; 
 }

</style>
</head>
<body>
	<div  class="text-center">
		<!-- 맨 앞으로 이동 버튼 -->
	    <button class="page-link" id="startPage"><<</button>
		
		<!-- 이전 페이지 버튼 -->
		<c:if test="${ requestScope.selectAdminCriteria.pageNo <= 1 }">
			<button class="page-link-disabled">Prev</button>
		</c:if>
		<c:if test="${ requestScope.selectAdminCriteria.pageNo > 1 }">
			<button class="page-link" id="prevPage">Prev</button>
		</c:if>
		
		<!-- 숫자 버튼 -->
		<c:forEach var="p" begin="${ requestScope.selectAdminCriteria.startPage }" end="${ requestScope.selectAdminCriteria.endPage }" step="1">
			<c:if test="${ requestScope.selectAdminCriteria.pageNo eq p }">
				<button class="page-link-disabled" ><c:out value="${ p }"/></button>
			</c:if>
			<c:if test="${ requestScope.selectAdminCriteria.pageNo ne p }">
				<button onclick="pageButtonAction(this.innerText);" class="page-link"><c:out value="${ p }"/></button>
			</c:if>
		</c:forEach>
		
		<!-- 다음 페이지 버튼 -->
		<c:if test="${ requestScope.selectAdminCriteria.pageNo >= requestScope.selectAdminCriteria.maxPage }">
			<button class="page-link-disabled" >Next</button>
		</c:if>
		<c:if test="${ requestScope.selectAdminCriteria.pageNo < requestScope.selectAdminCriteria.maxPage }">
			<button   id="nextPage" class="page-link">Next</button>
		</c:if>
		
		<!-- 마지막 페이지로 이동 버튼 -->
		<button class="page-link" id="maxPage">>></button> 
	</div>
	
	<script>
	
		const link = "${ pageContext.servletContext.contextPath }/admin/request/list";
		let searchText = "";
	
		
		if(${ !empty requestScope.selectAdminCriteria.searchCondition? true: false }) {
			searchText += "&searchCondition=${ requestScope.selectAdminCriteria.searchCondition }";
		});
		
		if(${ !empty requestScope.selectAdminCriteria.searchValue? true: false }) {
			searchText += "&searchValue=${ requestScope.selectAdminCriteria.searchValue }";
		}
		
		if(${ !empty requestScope.selectAdminCriteria.searchStartDate? true: false }) {
			searchText += "&searchStartDate=${ requestScope.selectAdminCriteria.searchStartDate }";
		}
		
		if(${ !empty requestScope.selectAdminCriteria.searchEndDate? true: false }) {
			searchText += "&searchEndDate=${ requestScope.selectAdminCriteria.searchEndDate }";
		}
		
		if(${ !empty requestScope.selectAdminCriteria.searchStatus? true: false }) {
			searchText += "&searchStatus=${ requestScope.selectAdminCriteria.searchStatus }";
		}
		
		if(${ !empty requestScope.selectAdminCriteria.searchStatusValue? true: false }) {
			searchText += "&searchStatusValue=${ requestScope.selectAdminCriteria.searchStatusValue }";
		}
		
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1" + searchText;
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectAdminCriteria.pageNo - 1 }" + searchText;
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectAdminCriteria.pageNo + 1 }" + searchText;
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectAdminCriteria.maxPage }" + searchText;
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text + searchText;
		}
		
	</script>
</body>
</html>