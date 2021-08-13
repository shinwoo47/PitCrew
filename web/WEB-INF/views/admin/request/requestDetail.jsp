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
   				<th width="150px">상품명</th>
   				<th width="150px">의뢰 일시</th>
   				<th width="150px">청소 해결사</th>
   				<th width="150px">주문 일자</th>
   				<th width="150px">의뢰 상태</th>
   				<th width="150px">상세 보기</th>
         	</tr>
         	<tr></tr>
         	<c:forEach items="${ requestScope.requestList }" var="request">
					<tr>
						<td><c:out value="${ request.reqNo }"/></td>
						<td><c:out value="${ request.user.name }"/></td>
						<td><c:out value="${ request.product.productName }"/></td>
						<td><c:out value="${ request.serviceDate }"/></td>
						<td><c:out value="${ request.cleaner.name }"/></td>
						<td><c:out value="${ request.pay.payDate }"/></td>
						<td><c:out value="${ request.status }"/></td>
						<td><button type="button">자세히</button></td>
					</tr>
			</c:forEach>	
         	
         </table>         
        <hr>
        <div class="tab-regular">
			<ul class="nav nav-tabs " id="myTab" role="tablist">
			 <li class="nav-item">
				<a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">의뢰 히스토리</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">의뢰 변경</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" id="contact-tab" data-toggle="tab" href="#contact" role="tab" aria-controls="contact" aria-selected="false">결제 관리</a>
			</li>
			</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
	 			<p class="lead"> head같은 내용 </p>
				<p>내용내용내용</p>
			</div>
			<div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
				<h3>두번째 탭</h3>
				<p>정녕 ajax가 답인가</p>
			</div>
		<div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
				<h3>세번째 탭 내용 </h3>
				<p>진짜 ajax뿐이냐고 다시 공부해야한단말야</p>
			</div>
		</div>
				</div>     
             
                      
            </div>
         </div>
      </div>


	</div>
</body>
</html>