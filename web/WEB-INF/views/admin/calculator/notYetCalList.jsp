<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡겨줘 홈즈 관리자 모드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>

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
             <label style="padding:10px;">의뢰일자 : </label>
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
         	<div>
             	<button type="submit" id="cal" 
             	style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.2rem;">정산하기</button>
             </div><br><br>
            
            <table class="text-center" id="calList">
            	<thead>
		         	<tr height="25px" style="font-size: 15px">
		         		<th><input type="checkbox" id="all_select"></th>
		         		<th class="req-no" width="150px">의뢰 번호</th>
		         		<th class="mem-no" width="150px">회원 번호</th>
		         		<th class="mem-id" width="150px">아이디</th>
		   				<th class="mem-name" width="150px">성  명</th>
		   				<th class="enroll-date" width="150px">가입일</th>
		   				<th class="service-date" width="150px">의뢰 일자</th>
		   				<th class="calc-price" width="150px">정산 금액</th>
		   				<th class="income-tax" width="150px">소득세</th>
		   				<th class="resident-tax" width="150px">주민세</th>
		   				<th class="transfer-price" width="150px">실수령액</th>
		         	</tr>
	         	</thead>
         		<tbody>
         				<c:forEach items="${ perReqCalcList }" var="calList" varStatus="st">
							<tr id="content${ st.count }" height="15">
								<td><input type="checkbox" name="ch"></input></td>
								<td class="req-no"><c:out value="${ calList.request.reqNo }"/></td>
								<td class="mem-no"><c:out value="${ calList.cleaner.memNo }"/></td>
								<td class="mem-id" ><c:out value="${ calList.cleaner.id }"/></td>
								<td class="mem-name"><c:out value="${ calList.cleaner.name }"/></td>
								<td class="enroll-date"><c:out value="${ calList.cleaner.enrollDate }"/></td>
								<td class="service-date"><c:out value="${ calList.request.serviceDate }"/></td>
								<td class="calc-price"><c:out value="${ calList.request.cleanerIncome }" /></td>
								<td class="income-tax"><c:out value="${ calList.incometax }" /></td>
								<td class="resident-tax"><c:out value="${ calList.residenttax }" /></td>
								<td class="transfer-price"><c:out value="${ calList.cleanerTransferPrice }"/></td>
							</tr>
						</c:forEach>
					</tbody>	
         		</table>       
         		<br><br><br>      
              <jsp:include page="../pagingForCal.jsp"/> 
            </div>
         </div>
      </div>
	</div>
<script>

		$('#all_select').on("click", function() {
			if($("input:checkbox[id='all_select']").prop("checked")){
				$("input[type=checkbox]").prop("checked", true);
			} else {
				$("input[type=checkbox]").prop("checked", false);
			}
		});
		
			
		$("#cal").click(function() {
			
			 let tbody = $("#calList > tbody");
			 const rows = tbody.children();
			 
			 const calList = [];
			 
			 rows.each(function () {
			 if($(this).find("input[type=checkbox]").is(':checked')) {
      			const cal = {};
      			cal.reqNo = $(this).find(".req-no").text()
				cal.memNo = $(this).find(".mem-no").text()
      			cal.memId = $(this).find(".mem-id").text()
      			cal.memName = $(this).find(".mem-name").text()
      			cal.enrollDate = $(this).find(".enroll-date").text()
      			cal.serviceDate = $(this).find(".service-date").text()
      			cal.calcPrice = $(this).find(".calc-price").text()
      			cal.incomeTax = $(this).find(".income-tax").text()
      			cal.residentTax = $(this).find(".resident-tax").text()
      			cal.transferPrice = $(this).find(".transfer-price").text()
      			
				calList.push(cal);
			 }
				
			 console.log(calList)
		 
			 console.log(calList.length);
			
			 let calcList = JSON.stringify(calList);
			 
			 
			if($("input:checkbox[name=ch]:checked").length == (calList.length)){
			 	 $.ajax({
					url: "${ pageContext.servletContext.contextPath }/admin/yetcal/list",
					method: "POST",
					traditional: true,
					data: { calcList : calcList },
					dataType: 'JSON',
					success: function(data, testStatus, xhr) {	
						alert(calList.length + "건 정산 요청 성공");
					},
					error: function(xhr, status, error) {
						alert(calList.length + "건 정산 요청 실패");
					} 			
					
				});
			 }
			}); 
		});
			

		
    
    </script>	
	
</body>
</html>