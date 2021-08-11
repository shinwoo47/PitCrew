<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
							        <td>${ fn:replace(requestDetail.address.address, "$", " ")}</td>
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
							      <tr>
							        <td>의뢰상태</td>
							        <td>${ requestDetail.reqStatus }</td> 
							      </tr>
							    </tbody>
							  </table>
							</div>
                    </div>
                    <div class="blog__details__quote">
                        <p>${ request.reqReq }</p>

                    </div>
                    <div class="blog__details__text">
                        <h4>1. Promotional Advertising Specialty You Ve Waited Long Enough</h4>
                        <p class="first-para">Take it on a Thursday or Friday, when the big Sunday advertisements are in
                            process construction, the scene is remarkably lively, and the man at the head of the
                            advertising department has plenty</p>
                        <p>He must have very clear-cut and definite ideas as to whatâs what, and no matter what
                            influence may be brought to bear upon him by the different managers the advertising manager
                            must have a stamina to select what he considers the best and arrange the same as he thinks
                            wise, while at the same time he must have sufficient tact and skill to do these things
                            without hurting the</p>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__text">
                        <h4>2. Advertising Relationships Vs Business Decisions</h4>
                        <p class="first-para">Businesses often become known today through effective marketing. The
                            marketing may be in the form of a regular news item or half column society news in the
                            Sunday newspaper. The marketing may be in the form of a heart to heart talk with Mr. Brown
                            on his prominent local television show. These are all advertising. Businesses cannot get
                            away from the force of advertising. If they want to make their products known in the
                            marketplace they have to use some</p>
                        <p>Advertising is being more and more known as a reasonable and desirable business force. Letâs
                            say you own a department store. The advertising manager of the store is like the managing
                            editor of a daily newspaper with his group of reporters regularly bringing fresh matter to
                            his</p>
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
</body>

</html>