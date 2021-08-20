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
		<c:if test="${ requestScope.selectAdminCriteriaForCal.pageNo <= 1 }">
			<button class="page-link-disabled">Prev</button>
		</c:if>
		<c:if test="${ requestScope.selectAdminCriteriaForCal.pageNo > 1 }">
			<button class="page-link" id="prevPage">Prev</button>
		</c:if>
		
		<!-- 숫자 버튼 -->
		<c:forEach var="p" begin="${ requestScope.selectAdminCriteriaForCal.startPage }" end="${ requestScope.selectAdminCriteriaForCal.endPage }" step="1">
			<c:if test="${ requestScope.selectAdminCriteriaForCal.pageNo eq p }">
				<button class="page-link-disabled" ><c:out value="${ p }"/></button>
			</c:if>
			<c:if test="${ requestScope.selectAdminCriteriaForCal.pageNo ne p }">
				<button onclick="pageButtonAction(this.innerText);" class="page-link"><c:out value="${ p }"/></button>
			</c:if>
		</c:forEach>
		
		<!-- 다음 페이지 버튼 -->
		<c:if test="${ requestScope.selectAdminCriteriaForCal.pageNo >= requestScope.selectAdminCriteriaForCal.maxPage }">
			<button class="page-link-disabled" >Next</button>
		</c:if>
		<c:if test="${ requestScope.selectAdminCriteriaForCal.pageNo < requestScope.selectAdminCriteriaForCal.maxPage }">
			<button   id="nextPage" class="page-link">Next</button>
		</c:if>
		
		<!-- 마지막 페이지로 이동 버튼 -->
		<button class="page-link" id="maxPage">>></button> 
	</div>
	
	<script>
	
		const link = "${ pageContext.servletContext.contextPath }/admin/request/list";
		let searchText = "";
	
		
		if(${ !empty requestScope.selectAdminCriteriaForCal.searchCondition? true: false }) {
			searchText += "&searchCondition=${ requestScope.selectAdminCriteriaForCal.searchCondition }";
		};
		
		if(${ !empty requestScope.selectAdminCriteriaForCal.searchValue? true: false }) {
			searchText += "&searchValue=${ requestScope.selectAdminCriteriaForCal.searchValue }";
		}
		
		if(${ !empty requestScope.selectAdminCriteriaForCal.searchStartDate? true: false }) {
			searchText += "&searchStartDate=${ requestScope.selectAdminCriteriaForCal.searchStartDate }";
		}
		
		if(${ !empty requestScope.selectAdminCriteriaForCal.searchEndDate? true: false }) {
			searchText += "&searchEndDate=${ requestScope.selectAdminCriteriaForCal.searchEndDate }";
		}
		
		
		if(${ !empty requestScope.selectAdminCriteriaForCal.searchStatusValue? true: false }) {
			searchText += "&searchStatusValue=${ requestScope.selectAdminCriteriaForCal.searchStatusValue }";
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
				location.href = link + "?currentPage=${ requestScope.selectAdminCriteriaForCal.pageNo - 1 }" + searchText;
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectAdminCriteriaForCal.pageNo + 1 }" + searchText;
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.selectAdminCriteriaForCal.maxPage }" + searchText;
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text + searchText;
		}
		
	</script>
</body>
</html>