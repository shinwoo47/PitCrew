<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin-left: 200px;
		margin-top: 100px;
	}
	#updateProduct{
		margin-left: 1517px;
	}
</style>
</head>
<body>
<jsp:include page="../menubar.jsp" />
	<div class="dashboard-wrapper">
	<div class="table-area">
	<form action="${ pageContext.servletContext.contextPath }/admin/product/update" method="post">
		<table id="listArea" border="1">
				<tr>
					<th width="120px" style="text-align: center; font-size: 20pt;">상품 번호</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품 카테고리</th>
					<th width="100px" style="text-align: center; font-size: 20pt;">상품명</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품 내용</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">시간</th>
					<th width="120px" style="text-align: center; font-size: 20pt;">가격</th>
				</tr>
			<c:forEach items="${ updateProduct }" var="product">
				<tr>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serCategory }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serName }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serContent }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serTime }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ product.serPrice }"></c:out></td>
				</tr>
			</c:forEach>
				<tr>
					<td style="text-align: center; font-size: 15pt;"><input type="text" name="serNo"></td>
					<td style="text-align: center; font-size: 15pt;"><input type="text" name="serCategory">
					<!-- <select name="serContent" >
					    <option value="메인">메인</option>
					    <option value="옵션">옵션</option>
				  	</select> --></td>
					<td style="text-align: center; font-size: 15pt;"><input type="text" name="serName"></td>
					<td style="text-align: center; font-size: 15pt;"><input type="text" name="serContent"></td>
					<td style="text-align: center; font-size: 15pt;"><input type="text" name="serTime"></td>
					<td style="text-align: center; font-size: 15pt;"><input type="text" name="serPrice"></td>
				</tr>
		</table>
		<button type="submit" id="updateProduct">수정 완료</button>
		</form>
	</div>
	</div>
</body>
</html>