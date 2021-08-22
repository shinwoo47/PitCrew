<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>맡겨줘 홈즈 관리자 모드</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

 div.pad {
 	padding-top: 30px;
 	padding-botton: 30px;
 }
</style>
</head>
<body>
<jsp:include page="../menubar.jsp"/>
 <div class="dashboard-wrapper">
    <div class="container-fluid dashboard-content">
       <div class="row">
          <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
             <br><h2 class="pageheader-title">의뢰 조회 </h2><br>
			 <form action="${ pageContext.servletContext.contextPath }/admin/request/list" method="get">
			 <div style="color: black;">
			 <label style=" margin: 5px; padding: 10px;">검  색 : </label>
			 <select style="padding:5px;" id="searchCondition" name="searchCondition">
				<option></option>
				<option value="product">상품명</option>
				<option value="user">이용자명</option>
				<option value="cleaner">청소 해결사명</option>
			 </select>
			 	<input type="text" placeholder="검색어를 입력하세요" id="searchValue" name="searchValue" 
			 		    style="width: 300px; margin: 10px;" >	                       
             </div>  
             <div style="color: black;">
             <label style="padding:10px;">의뢰일 : </label>
             <input type="date" id="searchStartDate" name="searchStartDate"> ~ <input type="date" id="searchEndDate" name="searchEndDate">
             </div>
             <div style="color: black;">
             <label style="margin: 5px;">의뢰 상태 : </label>
          	<label class="custom-control custom-radio custom-control-inline">
            	<input type="radio" class="custom-control-input" id="statusValue" name="statusValue">
            	<span class="custom-control-label">전체</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" id="statusValue" name="statusValue"  value="매칭 신청">
                 <span class="custom-control-label">매칭 신청</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" id="statusValue" name="statusValue"  value="매칭 완료">
                 <span class="custom-control-label">매칭 완료</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input"  id="statusValue" name="statusValue" value="종료된 의뢰">
                 <span class="custom-control-label">종료된 의뢰</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input"  id="statusValue" name="statusValue" value="취소 요청">
                 <span class="custom-control-label">취소 요청</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input"  id="statusValue" name="statusValue" value="의뢰 취소">
                 <span class="custom-control-label">의뢰 취소</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" id="statusValue" name="statusValue" value="수정 요청">
                 <span class="custom-control-label">수정 요청</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" id="statusValue" name="statusValue" value="수정된 의뢰">
                 <span class="custom-control-label">수정된 의뢰</span>
            </label>
            <br><br>
             </div>
             <div class="text-center">
             	<button type="submit" style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">검색</button>
             </div><hr>
             </form>
         	<br>
            <table class="text-center" id="requestList">
	        	<thead>
		        	<tr height="15" style="font-size: 15px">
		        		<th width="150px">의뢰 번호</th>
		        		<th width="150px">이용자</th>
		  				<th width="150px">상품명</th>
		  				<th width="150px">의뢰 일시</th>
		  				<th width="150px">청소 해결사</th>
		  				<th width="150px">주문 일자</th>
		  				<th width="150px">의뢰 상태</th>
		  				<th width="150px">상세 보기</th>
		        	</tr>
	        	</thead>
	        	<tbody>
	        		<c:forEach items="${ requestScope.requestList }" var="request" varStatus="st">
						<tr id="reqContent${ st.count }">
							<td class="req-no"><c:out value="${ request.reqNo }"/></td>
							<td><c:out value="${ request.user.name }"/></td>
							<td class="product-name">
								<c:forEach items="${ request.product }" var="product">
									<c:out value="${ product.productName }"/><br>
								</c:forEach>
							</td>
							<td class="service-date"><c:out value="${ request.serviceDate }"/></td>
							<td class="cleaner-name"><c:out value="${ request.cleaner.name }"/></td>
							<td class="pay-date">
							<c:forEach items="${ request.pay }" var="pay" begin="0" end="0">
								<c:out value="${ pay.payDate }"/>
							</c:forEach></td>
							<td class="req-status"><c:out value="${ request.status }"/></td>
							<td class="detail"><button type="button" id="detail${ st.count }"style="background-color: #D9D9D9; border-color:transparent; 
										border-radius:0.3rem;">자세히</button></td>
						</tr>
					</c:forEach>			
	        	</tbody>
         </table>         
             <br><br><br>
              <jsp:include page="../paging.jsp"/>
            </div>
         </div>
      </div>
	</div>
<script>

	 $("[id^=detail]").on('click', function(event){
				 
		 let tbody = $("#requestList > tbody");
		 let rows = tbody.children(); 
		 
		 let id = $(this).attr("id");
		 let number = id.replace("detail", "");
		 
		 
		let reqNo = "";
		 rows.each(function(i) {
			let trId = $(this).attr("id");
			let trNum = trId.replace("reqContent", "");
	
			if(number == trNum) {
				reqNo = $(this).find(".req-no").text();
				console.log(reqNo);
			}
		});	
		
		 location.href = "${ pageContext.servletContext.contextPath }/admin/request/detail?reqNo=" + reqNo; 
		 
	 });   
    
	    
    </script>	
	
</body>
</html>