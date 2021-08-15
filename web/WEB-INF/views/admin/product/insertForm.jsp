<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	.table-area{
		position: absolute;
		top: 10%;
		height: 100px;
		margin-left: 300px;
		margin-top: 200px;
	}
	#insertProduct{
		margin-left: 300px;
	}
</style>
</head>
<body>
	<jsp:include page="../menubar.jsp" /> 
	<div class="table-area">
		<form action="${ pageContext.servletContext.contextPath }/admin/product/insert" method="post">
		<table id="listArea" border="1">
				<tr>
					<th width="120px" style="text-align: center; font-size: 20pt;">상품 번호</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품 카테고리</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품명</th>
					<th width="200px" style="text-align: center; font-size: 20pt;">상품 내용</th>
					<th width="50px" style="text-align: center; font-size: 20pt;">시간</th>
					<th width="100px" style="text-align: center; font-size: 20pt;">가격</th>
					<!-- <th width="200px" style="text-align: center; font-size: 20pt;">주문가능여부</th> -->
				</tr>
				<tr>
					<td style="text-align: center; font-size: 20pt;"><input type="text" name="serNo"></td>
					<td style="text-align: center; font-size: 20pt;"> 
					<select id="searchCondition" name="searchCondition" style="text-align: center; font-size: 20pt; margin: 10px;">
						<option>==선택하세요==</option>
						<option value="메인">메인</option>
						<option value="옵션">옵션</option>
					</select>
					</td>
					<td style="text-align: center; font-size: 20pt;"><input type="text" name="serName"></td>
					<td style="text-align: center; font-size: 20pt;"><input type="text" name="serContent"></td>
					<td style="text-align: center; font-size: 20pt;"><input type="text" name="serTime"></td>
					<td style="text-align: center; font-size: 20pt;"><input type="text" name="serPrice"></td>
					<!-- <td style="text-align: center; font-size: 20pt;"><input type="text" name="serOrderable"></td> -->
				</tr>
		</table>
				<button type="submit" id="insertProduct">완료</button>
		</form>
	</div>
</body>
</html>