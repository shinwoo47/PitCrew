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
                        	<form>
                        	<input id="date" name="date" type="month" style="margin-bottom: 50px;"><button type="submit">선택</button>
                        	</form>
                        	<input type="hidden" id="calNo" name="calNo" value="${ calculate.calNo }"/>
							  <table class="table table-hover">
							    <thead>
							    <h4><fmt:formatDate value="${ calculate.calDate }" type="date" pattern="yyyy-MM"/> 월 정산</h4>
							    <h5 style="margin-bottom: 20px; margin-top: 20px;">개인 정보</h5>
							    
							      <tr>
							        <th>이름</th>
							        <th>은행명</th>
							        <th>계좌 번호</th>
							        <th>정산일</th>
							        <th><button id="detail">상세정산</button></th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td>${ calculate.accountHolder }</td>
							        <td>${ calculate.bankName }</td>
							        <td>${ calculate.accountNo }</td>
							        <td><fmt:formatDate value="${ calculate.calDate }" type="date" pattern="yyyy-MM-dd"/></td>
							      </tr>
							      
							    </tbody>
							  </table>
                        	</div>
                        	<div class="calculate">     
							  <table class="table table-hover">
							    <thead>
							      <tr>
							        <th>청소종류</th>
							        <th>실적</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td class="text">방청소</td>
							        <td>${ productSum.room } 회</td>
							      </tr>
							      <tr>
							        <td class="text">화장실</td>
							        <td>${ productSum.bathroom } 회</td>
							      </tr>
							      <tr>
							        <td class="text">전체청소</td>
							        <td>${ productSum.all } 회</td>
							      </tr> 
							      <tr>
							        <td class="text">옵션</td>
							        <td>${ productSum.window + productSum.dishes } 회</td>
							      </tr>
							    </tbody>
							  </table>
                        	</div>
                        	<div class="calculate">							           
							  <table class="table table-hover">
							    <thead>
							      <tr>
							        <th>지급내역</th>
							        <th>지급액</th>
							        <th>공제내역</th>
							        <th>공제액</th>
							      </tr>
							    </thead>
							    <tbody>
							      <tr>
							        <td rowspan="4" class="text">정산금액</td>
							        <td rowspan="4">${ calculate.calPrice } 원</td>
							      </tr>
							      <tr>
							        <td class="text">소득세</td>
							        <td>${ calculate.incomeTax } 원</td>
							      </tr>
							      <tr>
							        <td class="text">주민세</td>
							        <td>${ calculate.residentTax } 원</td>
							      </tr>
							      <tr>
							        <td class="sum">공제액계</td>
							        <td>${ calculate.incomeTax + calculate.residentTax } 원</td>
							      </tr>
							      <tr>
							        <td class="sum">지급액계</td>
							        <td>${ calculate.calPrice } 원</td>
							        <td class="sum">차인지급액</td>
							        <td>${ calculate.calTransferPrice } 원</td>
							      </tr>							      
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

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__logo">
                            <a href="./index.html"><img src="img/footer-logo.png" alt=""></a>
                        </div>
                        <p>Please remember though that how far you go is up to you. There is no substitute for your own
                            work and effort in succeeding in this business.</p>
                    </div>
                </div>
                <div class="col-lg-2 offset-lg-1 col-md-3 col-sm-6">
                    <div class="footer__widget">
                        <h5>Services</h5>
                        <div class="footer__widget">
                            <ul>
                                <li><a href="#">Personal Loans</a></li>
                                <li><a href="#">Business Loans</a></li>
                                <li><a href="#">Online Cash Loans</a></li>
                                <li><a href="#">Cash Advance</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 col-md-3 col-sm-6">
                    <div class="footer__widget">
                        <h5>Socials</h5>
                        <div class="footer__widget footer__widget--social">
                            <ul>
                                <li><a href="#"><i class="fa fa-facebook"></i> Facebook</a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i> Instagram</a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i> Twitter</a></li>
                                <li><a href="#"><i class="fa fa-skype"></i> Skype</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 offset-lg-1 col-md-6 col-sm-6">
                    <div class="footer__widget footer__widget--address">
                        <h5>Open Hours</h5>
                        <p>We work all days a week, Please contact us for any inquiry.</p>
                        <ul>
                            <li>Monday - Friday: 11:00 am - 8:00 pm</li>
                            <li>Saturday: 10:00 am - 6:00 pm</li>
                            <li>Sunday: 11:00 am - 6:00 pm</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer__copyright">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <ul class="footer__copyright__links">
                            <li><a href="#">Terms of use</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Community</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <div class="footer__copyright__text">
                            <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p>
                        </div>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

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
    window.onload = function() {
    	
    	
    	if(document.getElementById("detail")) {
    		const $detail = document.getElementById("detail")	
			const no = $("#calNo")[0].value;
    		console.log(no)
    		$detail.onclick = function() {
    			location.href = "${ pageContext.servletContext.contextPath }/cleaner/calculate/detail?no=" + no;
    		}
    	}
    	
    	
    	
    }

    </script>
</body>

</html>