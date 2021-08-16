<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자모드 상품 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	.table-area{
		position: absolute;
		top: 10%;
		height: 100px;
		margin-left: 200px;
	}
</style>
</head>
<body>
	<jsp:include page="../menubar.jsp" />
	<div class="dashboard-wrapper">
		<div class="table-area">
		<table id="listArea" border="1">
				<tr>
					<th width="120px" style="text-align: center; font-size: 20pt;">상품 번호</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품 카테고리</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">상품명</th>
					<th width="500px" style="text-align: center; font-size: 20pt;">상품 내용</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">시간</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">가격</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">히스토리</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">상품 수정</th>
					<th><button type="button" id="insertProduct">상품 추가</button></th>
				</tr>
			<c:forEach items="${ productList }" var="product">
				<tr>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serCategory }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serName }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serContent }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serTime }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serPrice }"></c:out></td>
					<td align="center" style="text-align: center; font-size: 15pt;"><button>상세</button></td>
					<td style="text-align: center; font-size: 15pt;"><button type="button" id="updateProduct">수정</button></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="paging.jsp"/>
	</div>
	</div>
	
	<script>
	if(document.getElementById("insertProduct")) {
		const $addProdcut = document.getElementById("insertProduct");
		$addProdcut.onclick = function() {
			location.href = "${ pageContext.servletContext.contextPath }/admin/product/insert";
		}
	}
	
	if(document.getElementById("updateProduct")) {
		const $modifyProdcut = document.getElementById("updateProduct");
		$modifyProdcut.onclick = function() {
			location.href = "${ pageContext.servletContext.contextPath }/admin/product/update";
		}
	}
	</script>
</body>
</html>