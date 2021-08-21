<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자모드 블랙리스트 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
table {
	margin-right: 170px;
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
	<form action="${ pageContext.servletContext.contextPath }/admin/select/alluserinfo"	method="get" 
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
				가일일 기간 : <input type="date" id="searchDate" name="searchDate"class="fa fa-search" placeholder="날짜 선택"> ~ 
							<input type="date" id="searchEndDate" name="searchEndDate" class="fa fa-search"placeholder="날짜 선택"></h3>
		</div>
	</form>
	<%-- <form action="${ pageContext.servletContext.contextPath }/admin/blacklist/delete" method="post"> --%>
	<div class="table-area">
		<table align="right" id="listArea" border="1">
			<tr>
				<th width="120px" style="text-align: center; font-size: 20pt;">회원번호</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">가입일</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">회원 분류</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">아이디</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">이름</th>
				<th width="200px" style="text-align: center; font-size: 20pt;">휴대폰 번호</th>
				<th width="140px" style="text-align: center; font-size: 20pt;">패널티 점수</th>
				<th width="150px" style="text-align: center; font-size: 20pt;">블랙리스트 삭제</th>
				<th width="100px" style="text-align: center; font-size: 20pt;">자세히</th>
				<th width="120px" style="text-align: center; font-size: 20pt;">탈퇴여부</th>
			</tr>
			<c:forEach items="${ blacklistList }" var="blacklist">
			<%-- <input type="hidden" id="memNo" name="memNo" value="${ blacklist.memNo }"> --%>
				<tr>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ blacklist.memNo }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ blacklist.enrollDate }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ blacklist.memberRole }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ blacklist.memId }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ blacklist.memName }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out	value="${ blacklist.phone }"></c:out></td>
					<td style="text-align: center; font-size: 20pt;"><c:out value="${ blacklist.penaltyScoreSum }"></c:out></td>
					<td align="center" style="text-align: center; font-size: 15pt;"><button type="submit">삭제</button></td>
					<td align="center" style="text-align: center; font-size: 13pt;"><button>자세히</button></td>
					<td style="text-align: center; font-size: 20pt;"><c:out value="${ blacklist.entYn }"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		  $("button[type=submit]").click(function() {
			  	const $tds = document.getElementsByTagName("td");
				for(let i = 0; i < $tds.length; i++) {
					$tds[i].onclick = function() {
						const memNo = this.parentNode.children[0].innerText;
						 location.href = "${ pageContext.servletContext.contextPath }/admin/blacklist/delete?memNo=" + memNo;
						 /* location.reload(); */
					}
				}
		    });	 
    </script>
	<!-- </form> -->
</body>
</html>