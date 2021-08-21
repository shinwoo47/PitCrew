<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	margin-right: 300px;
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
		<form action="${ pageContext.servletContext.contextPath }/admin/resign/allselect" method="get" 
				align="center" style="text-align: center; font-size: 20pt;">
			<select id="searchCondition" name="searchCondition" style="text-align: center; font-size: 20pt; margin: 10px;">
				<option value=""${ requestScope.selectCriteria.searchCondition eq ""? "selected": "" } selected disabled="disabled">==선택하세요==</option>
				<option value="memNo"${ requestScope.selectCriteria.searchCondition eq "memNo"? "selected": "" }>회원번호</option>
				<option value="memId"${ requestScope.selectCriteria.searchCondition eq "memId"? "selected": "" }>아아디</option>
				<option value="memName"${ requestScope.selectCriteria.searchCondition eq "memName"? "selected": "" }>이름</option>
				<option value="phone"${ requestScope.selectCriteria.searchCondition eq "phone"? "selected": "" }>휴대폰 번호</option>
				<option value="address"${ requestScope.selectCriteria.searchCondition eq "address"? "selected": "" }>거주지역</option>
			</select> 
			<input type="text" style="text-align: center; font-size: 20pt;" id="searchResult" name="searchResult"/>
			<button style="text-align: center; font-size: 20pt; margin: 30px;">검색</button>
			<div class="blog__sidebar__search">
				<h3 align="center">
					탈퇴일 기간 : <input type="date" id="searchDate" name="searchDate"class="fa fa-search" placeholder="날짜 선택">  ~  
								<input type="date" id="searchEndDate" name="searchEndDate" class="fa fa-search"placeholder="날짜 선택"></h3>
				<br>
				<br>
			</div>
		</form>
		<div class="table-area">
			<table align="right" id="listArea" border="1">
					<tr>
						<th width="120px" style="text-align: center; font-size: 20pt;">회원번호</th>
						<th width="200px" style="text-align: center; font-size: 20pt;">탈퇴일</th>
						<th width="200px" style="text-align: center; font-size: 20pt;">아이디</th>
						<th width="120px" style="text-align: center; font-size: 20pt;">이름</th>
						<th width="200px" style="text-align: center; font-size: 20pt;">휴대폰 번호</th>
						<th width="450px" style="text-align: center; font-size: 20pt;">거주지역</th>
					</tr>
				<c:forEach items="${ resignMemberList }" var="resignMember">
					<tr>
						<td style="text-align: center; font-size: 20pt;"><c:out	value="${ resignMember.memNo }"></c:out></td>
						<td style="text-align: center; font-size: 20pt;"><c:out	value="${ resignMember.entDate }"></c:out></td>
						<td style="text-align: center; font-size: 20pt;"><c:out	value="${ resignMember.memId }"></c:out></td>
						<td style="text-align: center; font-size: 20pt;"><c:out	value="${ resignMember.memName }"></c:out></td>
						<td style="text-align: center; font-size: 20pt;"><c:out	value="${ resignMember.phone }"></c:out></td>
						<td style="text-align: center; font-size: 20pt;"><c:out	value="${ fn:replace(resignMember.address, \"$\", \" \") }"></c:out></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</body>
</html>