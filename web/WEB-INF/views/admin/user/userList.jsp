<%@page import="com.pitcrew.cleanhome.admin.blacklist.controller.InsertBlacklistServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자모드 사용자 정보 조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
/* table {
	margin-right: 10px;
} */
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
	 <div class="dashboard-wrapper">
   	 <div class="container-fluid dashboard-content">
       <div class="row">
          <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	<form action="${ pageContext.servletContext.contextPath }/admin/select/alluserinfo"	method="get" 
			align="center" style="text-align: center; font-size: 20pt;" onsubmit="return check()">
		<select id="searchCondition" name="searchCondition" style="text-align: center; font-size: 20pt; margin: 10px;">
			<option value=""<%-- ${ requestScope.selectCriteria.searchCondition eq ""? "selected": "" } --%> selected disabled="disabled">==선택하세요==</option>
			<option id="memNo" value="memNo"${ requestScope.selectCriteria.searchCondition eq "memNo"? "selected": "" }>회원번호</option>
			<option id="memId" value="memId"${ requestScope.selectCriteria.searchCondition eq "memId"? "selected": "" }>아이디</option>
			<option id="memName" value="memName"${ requestScope.selectCriteria.searchCondition eq "memName"? "selected": "" }>이름</option>
			<option id="phone" value="phone"${ requestScope.selectCriteria.searchCondition eq "phone"? "selected": "" }>휴대폰 번호</option>
			<option id="address" value="address"${ requestScope.selectCriteria.searchCondition eq "address"? "selected": "" }>거주지역</option>
			<option id="entYn" value="entYn"${ requestScope.selectCriteria.searchCondition eq "entYn"? "selected": "" }>탈퇴여부</option>
		</select> 
		<input type="text" style="text-align: center; font-size: 20pt;" id="searchResult" name="searchResult"/>
		<button style="text-align: center; font-size: 20pt; margin: 30px;">검색</button>
		<div class="blog__sidebar__search">
			<h3 align="center">
				가입일 기간 : <input type="date" id="searchDate" name="searchDate"class="fa fa-search" placeholder="날짜 선택"> ~ 
							<input type="date" id="searchEndDate" name="searchEndDate" class="fa fa-search"placeholder="날짜 선택"></h3>
			<br>
			<h3 align="center">
				최근 의뢰 일자 기간 : <input type="date" id="crrentSearchDate" name="crrentSearchDate" class="fa fa-search" placeholder="날짜 선택"> ~ 
								<input type="date" id="crrentSearchEndDate" name="crrentSearchEndDate" class="fa fa-search" placeholder="날짜 선택">
			</h3>
			<br>
		</div>
	</form>
	<div class="table-area">
		<table align="right" id="listArea" border="1">
				<tr>
					<th width="120px" style="text-align: center; font-size: 18pt;">회원번호</th>
					<th width="150px" style="text-align: center; font-size: 18pt;">가입일</th>
					<th width="150px" style="text-align: center; font-size: 18pt;">아이디</th>
					<th width="120px" style="text-align: center; font-size: 18pt;">이름</th>
					<th width="200px" style="text-align: center; font-size: 18pt;">휴대폰 번호</th>
					<th width="200px" style="text-align: center; font-size: 18pt;">이메일</th>
					<th width="450px" style="text-align: center; font-size: 18pt;">거주지역</th>
					<th width="160px" style="text-align: center; font-size: 18pt;">최근 의뢰 일자</th>
					<th width="150px" style="text-align: center; font-size: 18pt;">블랙리스트 추가</th>
					<th width="120px" style="text-align: center; font-size: 18pt;">탈퇴여부</th>
				</tr>
			 <c:forEach items="${ userList }" var="user">
				<tr>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ user.memNo }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ user.enrollDate }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ user.memId }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ user.memName }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ user.phone }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ user.email }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out	value="${ fn:replace(user.address, \"$\", \" \") }"></c:out></td>
					<td style="text-align: center; font-size: 15pt;"><c:out value="${ user.reqNo.reqDate }"></c:out></td>
					<td id="insertButton" style="text-align: center; font-size: 15pt;"><button type="submit" id="insertButton" name="insertButton">추가</button></td>
					<td style="text-align: center; font-size: 15pt;"><c:out value="${ user.entYn }"></c:out></td>
				</tr> 
			 </c:forEach> 
			</table>
					<jsp:include page="../paging.jsp"/>
				</div>
			</div>
		</div>
	</div>
</div>
	<script>
	/* function check() {
	 //회원번호 검색 확인
    if($("#memNo").val() != /^[0-9]$/g){
	        alert("회원번호를 입력해 주세요");
	        $("#memNo").focus();
	        return false; 
    }*/
	 /* //아이디 검색 확인
    if($("#memId").val() == ){
	        alert("아이디를 입력해 주세요");
	        $("#memId").focus();
	        return false;
    }
	 //이름 검색 확인
    if($("#memName").val() != /^[0-9]$/g){
	        alert("회원번호를 입력해 주세요");
	        $("#memName").focus();
	        return false;
    }
	 //핸드폰 검색 확인
    if($("#phone").val() != /^[0-9]$/g){
	        alert("회원번호를 입력해 주세요");
	        $("#phone").focus();
	        return false;
    }
	 //주소 검색 확인
    if($("#address").val() != /^[0-9]$/g){
	        alert("회원번호를 입력해 주세요");
	        $("#address").focus();
	        return false;
    }
	 //탈퇴여부 검색 확인
    if($("#entYn").val() != 'Y' || 'N'){
	        alert("회원번호를 입력해 주세요");
	        $("#entYn").focus();
	        return false;
    } */
/* 	 return true; 
	}*/
		  $("button[type=submit]").click(function() {
			  	const $tds = document.getElementsByTagName("td");
				for(let i = 0; i < $tds.length; i++) {
					$tds[i].onclick = function() {
						const memNo = this.parentNode.children[0].innerText;
						const email = this.parentNode.children[5].innerText;
						 location.href = "${ pageContext.servletContext.contextPath }/admin/blacklist/insert?memNo=" + memNo + "&email=" + email;
					}
				}
		    });	 
    </script>
	
</body>
</html>