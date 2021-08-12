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
	table{
		position: absolute;
		top: 10%;
		height: 100px;
		margin-left: 600px;
	}
</style>
</head>
<body>
	<jsp:include page="../menubar.jsp" />
	<div class="table-area">
		<table id="listArea" border="1">
				<tr>
					<th width="120px" style="text-align: center; font-size: 20pt;">상품 번호</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품 카테고리</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품명</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">가격</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">히스토리</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">주문가능여부</th>
					<th width="140px" style="text-align: center; font-size: 20pt;">수정</th>
				</tr>
			<c:forEach items="${ productList }" var="product">
				<tr>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serCategory }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serName }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serPrice }"></c:out></td>
					<td align="center" style="text-align: center; font-size: 15pt;"><button>상세</button></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ 'Y' }"></c:out></td>
					<td align="center" style="text-align: center; font-size: 15pt;"><button>수정</button></td>
				</tr>
			</c:forEach>
		</table>
		<jsp:include page="paging.jsp"/>
	</div>
</body>
</html>