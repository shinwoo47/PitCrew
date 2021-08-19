<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡겨줘 홈즈 관리자 모드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.hidden {
		display: none;
	}
</style>
</head>
<body>
<jsp:include page="../menubar.jsp"/>
 <div class="dashboard-wrapper">
    <div class="container-fluid dashboard-content">
       <div class="row">
          <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
             <br><h2 class="pageheader-title"><b>미정산 내역 조회</b></h2><br>
			 <form action="${ pageContext.servletContext.contextPath }/admin/yetcal/list" method="get">
			 
			 <div style="color: black;">
             <label style="padding:10px;">* 의뢰일자 : </label>
             <input type="date" id="searchStartDate" name="searchStartDate"> ~ <input type="date" id="searchEndDate" name="searchEndDate">
             </div>
			 
			 <div style="color: black;">
			 <label style=" margin: 5px; padding: 10px;">검  색 : </label>
			 <select style="padding:5px;" id="searchCondition" name="searchCondition">
				<option></option>
				<option value="cleanerId">해결사 아이디</option>
				<option value="cleanerName">청소 해결사명</option>
			 </select>
			 	<input type="text" id="searchValue" name="searchValue" 
			 		    style="width: 300px; margin: 10px;" >	                       
             </div>  
             
             <div class="text-center">
             	<button type="submit" style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">검색</button>
             </div>
             </form>
         	<hr>
         	<form action="${ pageContext.servletContext.contextPath }/admin/yetcal/list" method="post">
         	<div>
             	<button type="submit" style="background-color: #02A79D; 
             	 color: white; border-color:transparent; border-radius:0.2rem;">정산하기</button>
             </div><br>
             
             <table class="text-center" id="calList">
         	<tr height="15" style="font-size: 15px">
         		<th class="hidden" width="150px">회원 번호</th>
         		<th><input type="checkbox" name="cal" onclick="selectAll(this)"></th>
         		<th width="150px">아이디</th>
   				<th width="150px">성  명</th>
   				<th width="150px">가입일</th>
   				<th width="150px">의뢰 일자</th>
   				<th width="150px">정산 금액</th>
   				<th width="150px">소득세</th>
   				<th width="150px">주민세</th>
   				<th width="150px">실수령액</th>
         	</tr>
         	<tr></tr>
         	<c:forEach items="${ perReqCalcList }" var="calList">
					<tr>
						<td class="hidden"><c:out value="${ calList.cleaner.memNo }"/></td>
						<td><input type="checkbox" name="cal"></input></td>
						<td><c:out value="${ calList.cleaner.id }"/></td>
						<td><c:out value="${ calList.cleaner.name }"/></td>
						<td><c:out value="${ calList.cleaner.enrollDate }"/></td>
						<td><c:out value="${ calList.request.serviceDate }"/></td>
						<td><c:out value="${ calList.request.cleanerIncome }"/></td>
						<td><c:out value="${ calList.incometax }"/></td>
						<td><c:out value="${ calList.residenttax }"/></td>
						<td><c:out value="${ calList.cleanerTransferPrice }"/></td>
					</tr>
					</c:forEach>	
         		</table>         
             </form>
              <jsp:include page="/WEB-INF/views/common/paging.jsp"/> 
            </div>
         </div>
      </div>
	</div>
<script>
		$(function selectAll(selectAll) {
			const checkboxes 
		       = document.getElementsByName('cal');
		  
		  checkboxes.forEach((checkbox) => {
		    checkbox.checked = selectAll.checked;
		  })
		});


	    $("[id^=detail]").on('click', function(event) {
	    	
	    	let name = $(this).attr("name");
	    	let number = name.replace("btn", "");
	    	// 이렇게 적으면 생성된 버튼에 클릭함수를 거는거랬는데 어떻게 경로와 파라미터를 주지?
	    	let reqNo = this.parentNode.children[0].innerText;
			location.href = "${ pageContext.servletContext.contextPath }/admin/request/detail?reqNo=" + reqNo;	    
	    });
    
    
    </script>	
	
</body>
</html>