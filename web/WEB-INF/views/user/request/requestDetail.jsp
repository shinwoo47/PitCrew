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

<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../userMenubar.jsp"/>
	
    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__title">
                        <div class="container">
						    <h2>의뢰 상세 내역</h2>
							<p>*확인 필수*</p>            
							<table class="table table-hover">
							    <thead>
							        <tr>
							        	<th>상세</th>
							        	<th>내용</th>
							       </tr>
							    </thead>
							    <tbody>
							      <tr>
							        	<td>장소</td>
							        	<td>
							        	<c:set var="address" value="${ requestDetail.address.address }"/>
                        				<c:set var="address1" value="${ fn:substring(address, fn:indexOf(address,'$') + 1, 30) }"/>
                        				<c:set var="address2" value="${ fn:replace(address1, \"$\", \" \") }"/>
                        				<c:out value="${ address2 }"/>
                        				</td>
							       </tr>
							        <tr>
							        	<td>연락처</td>
							        	<td>${ requestDetail.phone.phone }</td>
							       </tr>
							        <tr>
							        	<td>일시</td>
							        	<td>${ requestDetail.reqDate }</td>
							       </tr>
							        <tr>
							        <tr>
							        	<td>시간</td>
							        	<td><c:set var="sum2" value="0"/>
							        	<c:forEach var="product" items="${ requestDetail.productList }">
                                		<input type=hidden value="${ product.serTime}"/>
                                		<c:set var="sum2" value="${ sum2 + product.serTime }"/>
                                		</c:forEach>
                                		<c:out value="${ sum2 }"/> 시간
                                		</td>
							       </tr>
							        <tr>
							        	<td>청소종류</td>
							        	<td><c:set var="sum" value="0"/>
                                		<c:forEach var="product" items="${ requestDetail.productList }">
                                		<c:out value="${ product.serName }"/><input type=hidden value="${ product.serPrice }"/>
                                		<c:set var="sum" value="${ sum + product.serPrice }"/>
                                		</c:forEach>
                                		</td>
							       </tr>
							        <tr>
							        	<td>가격</td>
							        	<td><c:out value="${ sum }"/> 원</td>
							       </tr>
							    </tbody>
							  </table>
							</div>
                    	</div>
                    <h4 class="requestReq">요청사항</h4>
                    <div class="blog__details__text" style="text-align:left;">
                        <p>${ requestDetail.reqReq }</p>
                    </div>
                    <div>
                    	<c:if test="${ requestDetail.reqStatus eq '완료              ' }">
                    	<input type="hidden" name="reqNo" id="reqNo" value="${ requestDetail.reqNo }"/>
                    	<button id="report">신고 하기</button>
                    	</c:if>
                    </div>
				</div>
			</div>				
		</div>				
    </section>	
    
    <script>
    
    $("#report").on("click", function(){ 
		const no = $("#reqNo").val();
		console.log(no)
		location.href = "${ pageContext.servletContext.contextPath }/user/request/report?no=" + no;

	});    	
    </script>			                    
</body>
</html>