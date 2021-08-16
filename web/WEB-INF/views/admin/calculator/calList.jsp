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
             <br><h2 class="pageheader-title">정산 조회 </h2><br>
			 <form method="post">
			 <div style="color: black;">
			 <label style=" margin: 5px; padding: 10px;">검  색 : </label>
			 <select style="padding:5px;" id="searchCondition" name="searchCondition">
				<option></option>
				<option value="cleanerId">해결사 아이디</option>
				<option value="cleanerName">청소 해결사명</option>
			 </select>
			 	<input type="text" placeholder="검색어를 입력하세요" id="searchValue" name="searchValue" 
			 		    style="width: 300px; margin: 10px;" >	                       
             </div>  
             <div style="color: black;">
             <label style="padding:10px;">정산일자 : </label>
             <input type="date" id="searchStartDate" name="searchStartDate"> ~ <input type="date" id="searchEndDate" name="searchEndDate">
             </div>
             <div style="color: black;">
             <label style="margin: 5px;">정산 상태 : </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" id="statusValue" name="statusValue"  value="정산 대기">
                 <span class="custom-control-label">정산 대기</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" id="statusValue" name="statusValue"  value="정산 완료">
                 <span class="custom-control-label">정산 완료</span>
            </label>
            <br><br>
             </div>
             
             <div class="text-center">
             	<button type="submit" style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">검색</button>
             </div><hr>
             </form>
         	<hr>
         	<div>
         	<table class="text-center" id="calTotal">
         	<tr height="15" style="font-size: 15px">
         		<th width="150px">구    분</th>
         		<th width="150px">총 인원(명)</th>
   				<th width="150px">총 정산 금액(원)</th>
   				<th width="150px">총 공제액(원)</th>
   				<th width="150px">총 이체금액(원)</th>
         	</tr>
         	<tr>
         		<td>총   계</td>
         		<td></td>
         		<td></td>
         		<td></td>
         		<td></td>
         	</tr>
         	</table>
         	<div style="text-align:center; padding: 10px; justify-content: space-between;">
         			<button type="submit" style="background-color: #02A79D; color: white;border-color:transparent; border-radius:0.3rem;">정산하기</button>
         			<button type="button" style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">엑셀 내려받기</button>
         	</div>
         	</div>
             <table class="text-center" id="calList">
         	<tr height="15" style="font-size: 15px">
         		<th class="hidden" width="150px">회원 번호</th>
         		<th>선택</th>
         		<th width="150px">아이디</th>
   				<th width="150px">성  명</th>
   				<th width="150px">가입일</th>
   				<th width="150px">정산 일자</th>
   				<th width="150px">정산 금액</th>
   				<th width="150px">공제액</th>
   				<th width="150px">이체 금액</th>
   				<th width="150px">정산 상태</th>
         	</tr>
         	<tr></tr>
         	<c:forEach items="${ requestScope.requestList }" var="request">
					<tr>
						<td><input type="checkbox" id="cal" style="background-color: #D9D9D9; border-color:transparent; 
									border-radius:0.3rem;"></input></td>
						<td><c:out value="${ request.reqNo }"/></td>
						<td><c:out value="${ request.user.name }"/></td>
						<td><c:out value="${ request.product.ProductInfo.productName }"/></td>
						<td><c:out value="${ request.serviceDate }"/></td>
						<td><c:out value="${ request.cleaner.name }"/></td>
						<td><c:out value="${ request.pay.PayDTO.payDate.date }"/></td>
						<td><c:out value="${ request.reqStatusHistory.ReqInfoDTO.status }"/></td>
						
					</tr>
			</c:forEach>	
         	
         </table>         
             
              <jsp:include page="/WEB-INF/views/common/paging.jsp"/> 
            </div>
         </div>
      </div>
	</div>
<script>
	    $("[id^=detail]").on('click', function(event) {
	    	
	    	let id = $(this).attr("id");
	    	let number = id.replace("btn", "");
	    	// 이렇게 적으면 생성된 버튼에 클릭함수를 거는거랬는데 어떻게 경로와 파라미터를 주지?
	    	let reqNo = this.parentNode.children[0].innerText;
			location.href = "${ pageContext.servletContext.contextPath }/admin/request/detail?reqNo=" + reqNo;	    
	    });
    
    
    </script>	
	
</body>
</html>