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
		margin-left: 500px;
	}
	button{
	background-color: #02A79D; 
	color: white; 
	border-color:transparent; 
	border-radius:0.3rem;
	}
</style>
</head>
<body>
	<jsp:include page="../menubar.jsp" />
		<form action="${ pageContext.servletContext.contextPath }/admin/signup/approval" method="post">
			<div class="dashboard-wrapper">
				<div class="table-area">
				
				<table id="listArea" border="1">
						<tr>
							<th width="200px" style="text-align: center; font-size: 20pt;">회원 번호</th>
							<th width="200px" style="text-align: center; font-size: 20pt;">아이디</th>
							<th width="150px" style="text-align: center; font-size: 20pt;">이름</th>
							<th width="120px" style="text-align: center; font-size: 20pt;">서류 제출</th>
							<th width="120px" style="text-align: center; font-size: 20pt;">교육 이수</th>
							<th width="120px" style="text-align: center; font-size: 20pt;">승인</th>
						</tr>
					<c:forEach items="${ signUpList }" var="signUp">
					<input type="hidden" id="memNo" name="memNo" value="${ signUp.memId.memNo }">
						<tr>
							<td style="text-align: center; font-size: 20pt;"><c:out	value="${ signUp.memId.memNo }"></c:out></td>
							<td style="text-align: center; font-size: 20pt;"><c:out	value="${ signUp.memId.memId }"></c:out></td>
							<td style="text-align: center; font-size: 20pt;"><c:out	value="${ signUp.memId.memName }"></c:out></td>
							<td style="text-align: center; font-size: 20pt;"><c:out value="${ signUp.identifyYn }"></c:out><br><input type="checkbox" name="identifyYn" value="Y"></td>
							<td style="text-align: center; font-size: 20pt;"><c:out value="${ signUp.educateYn }"></c:out><br><input type="checkbox" name="educateYn" value="Y"></td>
							<td style="text-align: center; font-size: 15pt;"><button type="submit" value="승인">승인</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			</div>
		</form>
</body>

<script>
	window.onload = function() {
		
		console.log($("#memNo")[0].value);
		console.log("hi")
	}
	
	
</script>
</html>