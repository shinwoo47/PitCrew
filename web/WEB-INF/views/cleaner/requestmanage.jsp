<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
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
    <link href='${ pageContext.servletContext.contextPath }/resources/packages/core/main.css' rel='stylesheet' />
	<link href='${ pageContext.servletContext.contextPath }/resources/packages/daygrid/main.css' rel='stylesheet' />
	<link href='${ pageContext.servletContext.contextPath }/resources/packages/list/main.css' rel='stylesheet' />
	<script src='${ pageContext.servletContext.contextPath }/resources/packages/core/main.js'></script>
	<script src='${ pageContext.servletContext.contextPath }/resources/packages/interaction/main.js'></script>
	<script src='${ pageContext.servletContext.contextPath }/resources/packages/daygrid/main.js'></script>
	<script src='${ pageContext.servletContext.contextPath }/resources/packages/list/main.js'></script>
	<script src='${ pageContext.servletContext.contextPath }/resources/packages/google-calendar/main.js'></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.min.js" integrity="sha256-8nl2O4lMNahIAmUnxZprMxJIBiPv+SzhMuYwEuinVM0=" crossorigin="anonymous"></script>
   	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.9.0/main.css" integrity="sha256-z7G6BBWwBOXahthaod21GyxfNhxiQFBVn6WQYHRs9W8=" crossorigin="anonymous">


	<script>

    document.addEventListener('DOMContentLoaded', function() {
      var calendarEl = document.getElementById('calendar');
      var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth'
      });
      calendar.render();

      $(".fc-button-group").click(function() {
          var date = calendar.getDate();
          var searchDate = date.toISOString();
            console.log(searchDate);
            $.ajax({
    			url: "${ pageContext.servletContext.contextPath }/cleaner/request/ajax",
    			type: "get",
    			data: {
    				date : searchDate
    			},
    			success: function(data, textStatus, xhr) {
    				console.log(data);
    				removeDiv();
    				createDiv(data)
    				
    				
    			},
    			error: function(xhr, status, error) {
    				console.log(xhr);
    			}
        	});
  		});
      });
    

  </script>

    <style>
    	.blog__item__text {
	padding: 5px 5px 5px 5px;
	margin : 5px 5px 5px 5px;
}
    </style>
</head>

<body>
   

    <!-- 네비 -->
	<jsp:include page="../cleaner/cleanermenubar.jsp"/>

    

    <!-- Blog Section Begin -->
    <section class="blog spad">
    
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-7">	
                    <div class="blog__item">
                   		<!-- 달력  -->
                    	<div id="calendar">
                    	</div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-5">
                    <div class="blog__sidebar">  
                    
                        <c:forEach var="request" items="${ requestScope.requestList }" varStatus="status">
                        <div style="height: auto; width: 80%; border:3px solid yellowgreen;" class="blog__item__text" id="request${status.count}">
                        	<input type="hidden" name="reqNo" id="reqNo" value="${ request.reqNo }"/>
                        	<input type="hidden" name="reqNo" id="reqNo" value="${ request.reqStatus }"/>
                        	<c:set var="address" value="${ request.address.address }"/>
                        	<c:set var="address1" value="${ fn:substring(address, fn:indexOf(address,'$') + 1, 30) }"/>
                        	<c:set var="address2" value="${ fn:substring(address1, 0, fn:indexOf(address1,'$')) }"/>
                            <h3><c:out value="${ address2 }"/></h3>
                            <ul>
                                <li><i class="fa fa-clock-o"></i> <fmt:formatDate value="${ request.reqDate }" type="date" pattern="yyyy/MM/dd (E) hh시"/></li>
                                <li>  
                                	<c:set var="sumPrice" value="0"/>
                                	<c:set var="sumTime" value="0"/>
                                	<i class="fa fa-user"></i> 
                                	<c:forEach var="product" items="${ request.productList }">             		
                                		<c:out value="${ product.serName } "/><c:set var="price" value="${ product.serPrice }"/>
                                		<c:set var="sumPrice" value="${ sumPrice + product.serPrice }"/>
                                		<c:set var="sumTime" value="${ sumTime + product.serTime }"/>
                                	</c:forEach>
                                </li>
                            </ul>
                                                            예상소요시간 :<c:out value="${ sumTime }"/> 시간<br>
                                                              합계 가격 : <c:out value="${ sumPrice }"/> 원
                            <button style="float: right;" class="selectbtn" id="ok">선택하기 </button>
                        	
                        </div>
                        </c:forEach>
                    </div>
                </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog End -->

    
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
    <script>
    

    </script>

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
		
		$("body").on("click", "[id^=request]", function(){ 
			const no = this.children[0].innerText;
			const status = this.children[1].innerText;
			location.href = "${ pageContext.servletContext.contextPath }/cleaner/request/detail?no=" + no + "&status=" + status;

		});
	}
	function removeDiv(){

		  $(".blog__item__text").remove();
		}
	
	function createDiv(data){
		
		for(var i in data) {
			var request = data[i];
			
			var $div = $("<div class='blog__item__text' id='request'>");
			var address = (request.address.address).split('$')
			$div.append($("<input type='hidden'>").text(request.reqNo))
			$div.append($("<input type='hidden'>").text(request.reqStatus))
			console.log(request.reqNo);
			console.log(request.reqStatus)
			$div.append($("<h6>").text("장소 : " + address[1]));
			$div.append($("<h8>").text("일시 : " + request.reqDate))
			for(let service of request.productList){
			    let $cellsOfRow = $("<ul>" +
			        "<li>" + service.serName + "</li>" +
			        "<li>" + service.SerTime + "시간" + "</li>" +
			        "<li>" + service.serPrice + "원" + "</li>" +
			        "</ul>");
			    $div.append($cellsOfRow);
			}
				$(".blog__sidebar").append($div);
		}
	}
    </script>
    
</body>

</html>