<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>
	<h2 align="center">사용자 정보 조회</h2></div>
	<div class="table-area">
		<table align="center" id="listArea">
			<tr>
				<th width="100px">회원번호</th>
				<th width="100px">가입일</th>
				<th width="100px">아이디</th>
				<th width="100px">이름</th>
				<th width="100px">휴대폰 번호</th>
				<th width="100px">거주지역</th>
				<!-- <th width="100px">최근 의뢰일자</th>
				<th width="100px">블랙리스트 추가</th>
				<th width="100px">자세히</th> -->
				<th width="100px">탈퇴여부</th>
			</tr>
			<c:forEach var="user" items="${ requestScope.userList }">
			<tr>
				<td><c:out value="${ user.memNo }"></c:out></td>
				<td><c:out value="${ user.enrollDate }"></c:out></td>
				<td><c:out value="${ user.memId }"></c:out></td>
				<td><c:out value="${ user.memName }"></c:out></td>
				<td><c:out value="${ user.phone }"></c:out></td>
				<td><c:out value="${ user.address }"></c:out></td>
				<%-- <td><c:out value="${  }"></c:out></td>
				<td><c:out value="${  }"></c:out></td>
				<td><c:out value="${  }"></c:out></td> --%>
				<td><c:out value="${ user.entYn }"></c:out></td>
			</tr>
			</c:forEach>			
		</table>
		</div>
</body>
</html>