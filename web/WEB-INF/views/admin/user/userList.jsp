<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	table {
		margin: 10px;
	}
</style>
</head> 
<body>
	<jsp:include page="../menubar.jsp"/>
	<br>
	<form action="list" align="center" style="text-align: center; font-size: 20pt;">
    <select name="category" style="text-align: center; font-size: 20pt; margin: 10px;">
        <%-- <c:forEach items="${listCategory}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach> --%>
    </select>
    <input type="text" style="text-align: center; font-size: 20pt;"/>
    <button style="text-align: center; font-size: 20pt; margin: 30px;">검색</button>
	</form>
	<h3 align="center">가입일 기간 : <input type="text">
	<button style="font-size: 20px"><img src="${ pageContext.servletContext.contextPath }/web/resources/common/img/calendar.png"></button> ~ <input type="text">
	<button><img src="${ pageContext.servletContext.contextPath }/web/resources/common/img/calendar.png"></button></h3>
	<h3 align="center">최근 의뢰 일자 기간 : <input type="text"><button>달력</button> ~ <input type="text"><button>달력</button></h3>
	<div class="table-area">
		<table align="right" id="listArea" border="1">
			<tr>
				<th width="120px" style="text-align: center; font-size: 20pt;">회원번호</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">가입일</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">아이디</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">이름</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">휴대폰 번호</th>
				<th width="500px" style="text-align: center; font-size: 20pt;">거주지역</th>
				<th width="140px" style="text-align: center; font-size: 20pt;">최근 의뢰 일자</th>
				<th width="150px" style="text-align: center; font-size: 20pt;">블랙리스트 추가</th>
				<th width="100px" style="text-align: center; font-size: 20pt;">자세히</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">탈퇴여부</th>
			</tr>
			<c:forEach items="${ userList }" var="user">
			<tr>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ user.memNo }"></c:out></td>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ user.enrollDate }"></c:out></td>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ user.memId }"></c:out></td>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ user.memName }"></c:out></td>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ user.phone }"></c:out></td>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ fn:replace(user.address, \"$\", \" \") }"></c:out></td>
				<td style="text-align: center; font-size: 20pt;"><%-- <c:out value="${  }"></c:out> --%></td>
				<td align="center" style="text-align: center; font-size: 15pt;"><button>추가</button></td>
				<td align="center" style="text-align: center; font-size: 13pt;"><button>자세히</button></td>
				<td style="text-align: center; font-size: 20pt;"><c:out value="${ user.entYn }"></c:out></td>
			</tr>
			</c:forEach>			
		</table>
		</div>
</body>
</html>