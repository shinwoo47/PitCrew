<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		margin-top: 100px;
		margin-right: 225px;
	}
</style>
</head>
<body>
<jsp:include page="../menubar.jsp" />
	<div class="table-area">
		<table align="right" id="listArea" border="1">
				<tr>
				<th width="120px" style="text-align: center; font-size: 20pt;">회원번호</th>
				<th width="150px" style="text-align: center; font-size: 20pt;">아이디</th>
				<th width="150px" style="text-align: center; font-size: 20pt;">이름</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">의뢰 번호</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">결제 번호</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">결제 금액</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">결제일</th>
				<th width="300px" style="text-align: center; font-size: 20pt;">승인 번호</th>
			</tr>
			 <c:forEach items="${ payList }" var="pay">
				<tr>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.memId.memNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.memId.memId }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.memId.memName }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.reqNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.payNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.payPrice }원"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ pay.payDate }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out value="${ pay.payApprovalNo }"></c:out> </td>
				</tr> 
			 </c:forEach> 
		</table>
	</div>
</body>
</html>