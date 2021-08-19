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
	margin-right: 160px;
}
</style>
</head>
<body>
	<jsp:include page="../menubar.jsp" />
	<form action="${ pageContext.servletContext.contextPath }/admin/select/allcleanerinfo"	method="get" 
			align="center" style="text-align: center; font-size: 20pt;">
		<select id="searchCondition" name="searchCondition" style="text-align: center; font-size: 20pt; margin: 10px;">
			<option value=""${ requestScope.selectCriteria.searchCondition eq ""? "selected": "" } selected disabled="disabled">==선택하세요==</option>
			<option value="memNo"${ requestScope.selectCriteria.searchCondition eq "memNo"? "selected": "" }>회원번호</option>
			<option value="memId"${ requestScope.selectCriteria.searchCondition eq "memId"? "selected": "" }>아아디</option>
			<option value="memName"${ requestScope.selectCriteria.searchCondition eq "memName"? "selected": "" }>이름</option>
			<option value="phone"${ requestScope.selectCriteria.searchCondition eq "phone"? "selected": "" }>휴대폰 번호</option>
			<option value="entYn"${ requestScope.selectCriteria.searchCondition eq "entYn"? "selected": "" }>탈퇴여부</option>
		</select> 
		<input type="text" style="text-align: center; font-size: 20pt;" id="searchResult" name="searchResult"/>
		<button style="text-align: center; fon t-size: 20pt; margin: 30px;">검색</button>
		<div class="blog__sidebar__search">
			<h3 align="center">
				신원 조회 일자 기간 : <input type="date" id="searchDate" name="searchDate"class="fa fa-search" placeholder="날짜 선택"> ~ 
							<input type="date" id="searchEndDate" name="searchEndDate" class="fa fa-search"placeholder="날짜 선택"></h3>
			<br>
			<h3 align="center">
				교육 이수 일자 기간 : <input type="date" id="crrentSearchDate" name="crrentSearchDate" class="fa fa-search" placeholder="날짜 선택"> ~ 
								<input type="date" id="crrentSearchEndDate" name="crrentSearchEndDate" class="fa fa-search" placeholder="날짜 선택">
			</h3>
			<br>
		</div>
	</form>
	<form action="${ pageContext.servletContext.contextPath }/admin/blacklist/insert" method="post">
		<div class="table-area">
		<table align="right" id="listArea" border="1">
			<tr>
				<th width="120px" style="text-align: center; font-size: 20pt;">회원번호</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">가입일</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">아이디</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">이름</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">신원 조회 일자</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">교육 이수 일자</th>
				<th width="140px" style="text-align: center; font-size: 20pt;">휴대폰 번호</th>
				<th width="150px" style="text-align: center; font-size: 20pt;">블랙리스트 추가</th>
				<th width="100px" style="text-align: center; font-size: 20pt;">자세히</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">탈퇴여부</th>
			</tr>
			<c:forEach items="${ cleanerList }" var="cleaner">
			<input type="hidden" id="memNo" name="memNo" value="${ cleaner.memNo }">
			<input type="hidden" id="enrollDate" name="enrollDate" value="${ cleaner.enrollDate }">
			<%-- <input type="hidden" id="memberRole" name="memberRole" value="${ user.memberRole }"> --%>
			<input type="hidden" id="memId" name="memId" value="${ cleaner.memId }">
			<input type="hidden" id="memName" name="memName" value="${ cleaner.memName }">
			<input type="hidden" id="phone" name="phone" value="${ cleaner.phone }">
			<%-- <input type="hidden" id="penaltyScoreSum" name="penaltyScoreSum" value="${ user.penaltyScoreSum }"> --%>
			<input type="hidden" id="entYn" name="entYn" value="${ cleaner.entYn }">
				<tr>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ cleaner.memNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ cleaner.enrollDate }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ cleaner.memId }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ cleaner.memName }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><%-- <c:out	value="${ '' }"></c:out> --%></td>
					<td style="text-align: center; font-size: 20pt;"><%-- <c:out	value="${ '' }"></c:out> --%></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ cleaner.phone }"></c:out></td>
					<td align="center" style="text-align: center; font-size: 15pt;"><button type="submit">추가</button></td>
					<td align="center" style="text-align: center; font-size: 13pt;"><button>자세히</button></td>
					<td style="text-align: center; font-size: 20pt;"><c:out value="${ cleaner.entYn }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</form>
</body>
</html>