<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="${ pageContext.servletContext.contextPath }/resources/user/js/event.js"></script>
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Loanday | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/style.css" type="text/css">
    
     <!-- Js Plugins -->
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/user/js/main.js"></script>
<style>
	header {
 		height: 173.31px;
 	}
 	.header__Menu {
 		width: 391.69;
 		height: 36.98;
 	}
 	section {
 		height: calc(100% - 173.31px);
 		padding-top: 100px;
 	}
 	.nav-container {
 		width: 100%;
 		height: 100px;
 		display: flex;
 		justify-content: center;	/*수평 정렬*/
 		align-items: flex-start;		/*수직 정렬*/	
 		margin-bottom: 30px;
 	}
 	.nav-req-btn {
		width: 260px;
		height: 70px;
		font-size: 30px;
		border: 3px solid yellowgreen;
		background: white;
		text-align: center;
	}
	.nav-req-btn:nth-child(2) {
		color: white;
		background-color: yellowgreen;
	}
	
 	.req-list-container {
 		width: 100%;
 		height: calc(100% - 130px);
 		display: flex;
 		justify-content: center;
 	}
 	.containerp-list {
 		width: 1000px;
 		height: 100%;
 	}
	.containerp {
		border: 2px solid darkgray;
		border-radius: 20px;
		width: 100%;
		height: 300px;
		margin-bottom: 10px;
	}
	.containerp-top {
		width: 100%;
		height: 20%;
	}
	.containerp-top > div {
		height: 100%;
		display: flex;
		align-items: flex-end;
	}
	.containerp-top > div:nth-child(1) {
		width: 70%;
		float: left;
		padding-left: 25px;
		font-size: 25px;
	}
	.containerp-top > div:nth-child(2) {
		width: 30%;
		float: right;
		justify-content: flex-end;
		padding-right: 10px;
		font-weight: bold;
		font-size: 20px;
	}
	.containerp-section {
		width: 100%;
		height: 63%;
		display: flex;
		justify-content: center;
		align-items: flex-start;
	}
	.containerp-section > div {
		width: 50%;
		height: 100%;
		font-size: 20px;
		padding-top: 20px;
	}
	.containerp-section > div:nth-child(1) {
		width: 25%;
		padding-left: 30px;
		font-weight: bold;
	}
	.containerp-section > div:nth-child(2) {
		width: 75%;
	}
	
	.containerp-bottom {
		width: 100%;
		height: 17%;
		display: flex;
		justify-content: flex-end;
		align-items: center;
		padding-right: 10px;
	}
	.req-work-btn {
		width: 120px;
		height: 30px;
		margin-right: 10px;
	}
	
	.blog__item__text {
		align:center;
	}
	.nav-container p-3 my-3 border {
		height: 500px;
	}
	.blog__item__text {
		width:1110px;
	}
</style>
</head>

<body>
	
	<jsp:include page="../userMenubar.jsp"/>
	    
    <!-- Section Section Start -->
	<section class="blog">
		<div class="nav-container">
			<input type="button" class="nav-req-btn" id="allReqBtn" value="전체" > 
			<input type="button" class="nav-req-btn" id="registReqBtn" value="매칭신청" > 
			<input type="button" class="nav-req-btn" id="compMatchingReqBtn" value="매칭완료" > 
			<input type="button" class="nav-req-btn" id="endReqBtn" value="종료된의뢰"> 
		</div>
		<div class="req-list-container">
			<div id="containerp-list" class="containerp-list">

<%-- 			<c:forEach items="${ requestScope.myRegistRequest }" var="myRegistReq"> --%>
<!-- 				<div class="containerp"> -->
<!-- 					<div class="containerp-top"> -->
<%-- 						<div> <c:out value="${ myRegistReq.reqDate }"/> <c:out value="${ myRegistReq.reqStatus }"/> </div> --%>
<!-- 						<div class="req_detail"> -->
<!-- 							<a href="">의뢰상세보기 ></a> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				<c:forEach items="${ myRegistReq.productList }" var="product"> --%>
<!-- 					<div class="containerp-section"> -->
<!-- 						<div class="req-name-container"> -->
<!-- 							<div>상품명 : </div> -->
<!-- 							<div>가격 : </div> -->
<!-- 							<div>전화번호 : </div> -->
<!-- 						</div> -->
<!-- 						<div class="req-object-container"> -->
<%-- 							<div> <c:out value="${ product.serName }"/></div> --%>
<%-- 							<div> <c:out value="${ product.serPrice }"/></div> --%>
<%-- 							<div> <c:out value="${ myAllReq.phone.phone }"/></div> --%>
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</c:forEach> --%>
<!-- 					<div class="containerp-bottom"> -->
<!-- 						<button class="req-work-btn req-revise-btn">수정하기</button> -->
<!-- 						<button class="req-work-btn req-report-btn">신고하기</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<%-- 				</c:forEach> --%>
			</div>
		</div>
	</section>
    <!-- Search End -->
</body>
	
     <script>
	<c:forEach var="products" items="${requestScope.myRegistRequest}" varStatus="status">
		var grpName = "";
		var grpPrice = 0;
		var grpPhone = "";
		var grpReqDate = "";
		var grpReqStatus = "";
		
     	<c:forEach var="product" items="${products.productList}" varStatus="st">
     		grpName += "${product.serName}"
     		grpName += " ";
     		grpPrice += parseInt("${product.serPrice}");
     		grpPhone = "${products.phone.phone}";
     		grpReqDate = "${products.reqDate}";
     		grpReqStatus = "${products.reqStatus}";
     		grpNo = "${ products.reqNo }"
     	</c:forEach>
     	
     	$("#containerp-list").append(
	     	'<div class="containerp">'
			+ 	'<div class="containerp-top">'
			+ 		'<div> ' + grpReqDate + ' ' + grpReqStatus + '</div>'
			+ 		'<div class="req_detail">'
			+			'<input type="hidden" id="reqNo" value=' + grpNo + '>'
			+ 			'<button id="req_detailBtn">의뢰상세보기 ></button>'
			+ 		'</div>'
			+ 	'</div>'
			+ 	'<div class="containerp-section">'
			+ 		'<div class="req-name-container">'
			+ 			'<div>상품명 : </div>'
			+ 			'<div>가격 : </div>'
			+ 			'<div>전화번호 : </div>'
			+ 		'</div>'
			+ 		'<div class="req-object-container">'
			+ 			'<div>' + grpName + '</div>'
			+ 			'<div>' + grpPrice + '</div>'
			+ 			'<div>' + grpPhone + '</div>'
			+ 		'</div>'
			+ 	'</div>'
			+ 	'<div class="containerp-bottom">'
			+ 	'</div>'
			+ '</div>'
     	);
     	
	</c:forEach>
	
	/* 모든 의뢰 정보*/
     if(document.getElementById("allReqBtn")) {
		 const $registRequest = document.getElementById("allReqBtn");
		 $registRequest.onclick = function() {
			 location.href = "/pitcrew/user/select/myRequest";
		 }
     }
     
	/* 등록된 의뢰정보*/
     if(document.getElementById("registReqBtn")) {
		 const $registRequest = document.getElementById("registReqBtn");
		 $registRequest.onclick = function() {
			 location.href = "/pitcrew/user/regist/request";
		 }
     }
     
     /* 매칭된 의뢰정보*/
     if(document.getElementById("compMatchingReqBtn")) {
         const $endRegistRequest = document.getElementById("compMatchingReqBtn");
    	 $endRegistRequest.onclick = function() {
			 location.href = "/pitcrew/user/comp/regist/request";
		 }
     } 
	 
     /* 종료된 의뢰정보*/
     if(document.getElementById("endReqBtn")) {
    	 const $endRequest = document.getElementById("endReqBtn");
    	 $endRequest.onclick = function() {
			 location.href = "/pitcrew/user/end/request";
		 }
     } 
     
	window.onload = function() {
    	 
    	 const $detail = $("div > #req_detailBtn");
    	 const $reqNo = $("div > #reqNo");
    	 
    	 console.log("hi")
    	 console.log($detail)
    	 console.log($reqNo)
    	 $detail.on("click", function(){ 
    		 	const no = this.parentNode.children[0].value;
				console.log(no)
 			location.href = "${ pageContext.servletContext.contextPath }/user/request/detail?no=" + no;

 		});
	}
     </script>
     
     
</body>
</html>