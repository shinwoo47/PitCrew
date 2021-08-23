<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Loanday Template">
    <meta name="keywords" content="Loanday, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <title>Loanday | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
 	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/slicknav.min.css" type="text/css"> 
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  	<style>
		h2 {
		padding-bottom: 20px;
		}
		.account-btn {
		margin: 20px 20px 20px 20px;
		padding: 5px 10px 5px 10px;
		}
		.calculate {
		display: inline-block;
		margin-right: 90px;
		
		margin-top: 50px;
		
		}
		.detail{
		margin-right: 100px;
		}
		.sum {
		background-color: #1BAC89;
		}
		th {
		background-color: #20EBBA;		
		}
		.text {
		background-color: #EAEE34;		
		}
		th, td {
		text-align: center;
		}
  	</style>
</head>

<body>
    
    <!-- 네비 -->
	<jsp:include page="../cleaner/cleanermenubar.jsp"/>

    

    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__title">
                        <div class="container">
                        	<div>

                        	<input type="hidden" id="calNo" name="calNo" value="${ calculate.calNo }"/>
                        	<h5 style="margin-bottom: 20px; margin-top: 20px;">상세 정산</h5>
							  <table class="table table-hover">
							   <c:forEach var="calculateList" items="${ requestScope.calculateList }" varStatus="status">
							    <thead>
							      <tr>
							        <th>의뢰번호</th>
							        <th>의뢰시간</th>
							        <th>정산일자</th>
							        <th>정산금액</th>
							        <th>소득세</th>
							        <th>주민세</th>
							        <th>이체금액</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td>${ calculateList.reqNo }</td>
							        <td><fmt:formatDate value="${ calculateList.reqDate }" type="date" pattern="yyyy-MM-dd"/></td>
							        <td><fmt:formatDate value="${ calculateList.calDate }" type="date" pattern="yyyy-MM-dd"/></td>
							        <td>${ calculateList.cleanerIncome }</td>
							        <td>${ calculateList.incomeTax }</td>
							        <td>${ calculateList.residentTax }</td>
							        <td>${ calculateList.transferPrice }</td>
							      </tr>
							     </c:forEach>
							    </tbody>
							  </table>
                        	</div>
						</div>
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

   <jsp:include page="../cleaner/footer.jsp"/>

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

   <!-- Js Plugins -->
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-3.3.1.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/bootstrap.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nice-select.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery-ui.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.nicescroll.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.magnific-popup.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/jquery.slicknav.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/owl.carousel.min.js"></script>
    <script src="${ pageContext.servletContext.contextPath }/resources/common/js/main.js"></script>
    <script>


    </script>
</body>

</html>