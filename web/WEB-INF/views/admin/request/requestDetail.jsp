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

</head>
</head>
<body>
<jsp:include page="../menubar.jsp"/>
<div class="dashboard-wrapper">
    <div class="container-fluid dashboard-content">
       <div class="row">
          <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
             <br><h2 class="pageheader-title">의뢰 조회 </h2><br>
			 <table class="text-center" id="requestList">
         	<tr height="15" style="font-size: 15px">
         		<th width="150px">의뢰 번호</th>
         		<th width="150px">이용자</th>
         		<th width="150px">아이디</th>
   				<th width="150px">휴대폰번호</th>
   				<th width="150px">의뢰 일시</th>
   				<th width="150px">의뢰 상태</th>
   				<th width="150px">청소 해결사</th>
   				<th width="150px">해결사 연락처</th>
   				<th width="150px">주문 일자</th>
         	</tr>
			<tr id="rlist${ st.count }"  height="15" style="font-size: 15px">
			<td><c:out value="${ reqDetailDTO.reqNo }"/>
				<td><c:out value="${ reqDetailDTO.user.name }"/></td>
				<td><c:out value="${ reqDetailDTO.user.id }"/></td>
				<td><c:out value="${ reqDetailDTO.user.phone }"/></td>
				<td><c:out value="${ reqDetailDTO.serviceDate }"/></td>
				<td><c:out value="${ reqDetailDTO.status }"/></td>
				<td><c:out value="${ reqDetailDTO.cleaner.name }"/></td>
				<td><c:out value="${ reqDetailDTO.cleaner.phone }"/></td>
				<td>
				<c:forEach items="${ reqDetailDTO.pay }" var="pay" begin='0' end='0'>
				<c:out value="${ pay.payDate }"/>						
				</c:forEach></td>
			</tr> 
         </table>         
        <hr>
        <br><h2 class="pageheader-title">의뢰 히스토리 </h2><br>   
          <table class="text-center">
          <thead>
         	<tr style="font-size: 15px">
   				<th width="150px">상품코드</th>
   				<th width="200px">상품명</th>
   				<th width="200px">의뢰 일시</th>
   				<th width="200px">의뢰 상태</th>
   				<th width="200px">청소해결사</th>
   				<th width="200px">상태 변경일시</th>
         	</tr>
         </thead>
         <tbody>
         	<tr id="rDetail${ st.count }" height="15" style="font-size: 15px" >
				<td>
					<c:forEach items="${ reqDetailDTO.product}" var="product">
						<c:out value="${ product.productNo }"/><br>				
					</c:forEach>
				</td>
				<td>	
					<c:forEach items="${ reqDetailDTO.product}" var="product">
						<c:out value="${ product.productName }"/><br>				
					</c:forEach>
				</td>
				<td><c:out value="${ reqDetailDTO.serviceDate }"/></td>
				<td>
					<c:forEach items="${ reqDetailDTO.reqStatusHistory }" var="reqStatusHistory">
						<c:out value="${ reqStatusHistory.status }"/><br>
					</c:forEach>
				</td>
				<td><c:out value="${ reqDetailDTO.cleaner.name }"/></td>
				<td>
					<c:forEach items="${ reqDetailDTO.reqStatusHistory }" var="reqStatusHistory">
						<c:out value="${ reqStatusHistory.date }"/><br>
					</c:forEach>
				</td>
			</tr>	       	
		</tbody>			
         </table>            
          	<div style="text-align:center; justify-content: space-between;">
         			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modifyReqModal" 
         			   style="background-color: #02A79D; color: white;border-color:transparent; border-radius:0.3rem;">의뢰 변경</button>
         			<button type="reset" class="btn btn-primary" style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">목록으로</button>   
         	</div>
         	<!-- 모달 적용 -->
         	
        <div class="modal fade" id="modifyReqModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
             <div class="modal-dialog" role="document">
                      <div class="modal-content">
                             <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">의뢰 수정</h5>
                                       <a href="#" class="close" data-dismiss="modal" aria-label="Close">
                                                  <span aria-hidden="true">&times;</span>
                                        </a>
                               </div>
                      <div class="modal-body">
                   	  <form action="${ pageContext.servletContext.contextPath }/admin/request/update" method="post">
                   	  <table class="text-center" id="requestUpdateList">
			         	<tr height="15">
			         		<th width="100px">의뢰번호</th>
			   				<th width="100px">상품명</th>
			   				<th width="100px">의뢰 일시</th>
			   				<th width="100px">청소해결사</th>
			         	</tr>
			         	
								<tr>
									<td><c:out value="${ requestScope.reqDetailDTO.reqNo }"/></td>
									<td>
									<c:forEach items="${ reqDetailDTO.product}" var="product">
									<c:out value="${ product.productName }"/><br>				
									</c:forEach></td>
									<td><c:out value="${ requestScope.reqDetailDTO.serviceDate }"/></td>
									<td>
									<c:out value="${ reqDetailDTO.cleaner.name }"/></td>
								</tr>         	
			         </table>
                   	  
                   	  
                   	  </form>
                      </div>
                <div class="modal-footer">
                   <button type="reset">취소하기</button>
                   <button type="submit">변경 완료</button>
                </div>
               </div>
              </div>
              </div>            
            </div>
         </div>
      </div>
	</div>
	<script>
		/*	if(document.getElementById("modify")) {
				const $modify = document.getElementById("modify");
				//경로와 reqNo를 넘겨서 수정 모달을 띄우기
				$modify.onclick = function() {
					location.href = "${ pageContext.servletContext.contextPath }/admin/notice/insert";
				}
			}*/
			$("button[type=reset]").click(function() {
				
				if(confirm("목록으로 가시겠습니까?")) {
					history.back();
				} 	
			});	 
	</script>		
</body>
</html>