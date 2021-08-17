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
        initialView: 'dayGridMonth',
        
        events: [
            {
              title: 'Event1',
              start: '2011-04-04'
            },
            {
              title: 'Event2',
              start: '2011-05-05'
            }
            // etc...
          ],
          backgroundColor: 'yellow',   // an option!
          textColor: 'white' // an option!
      });
      
      calendar.render();
      
      var date = calendar.getDate();
      	var year = date.getFullYear();
      	var month = date.getMonth();
      	console.log(year)
      	console.log(month)
      	var firstDate = new Date(year + "-" + (month + 1) + "-" + "02")
      	console.log("firstDate" + firstDate)
      var searchDate = firstDate.toISOString();
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
        var arr = getCalendarDataInDB();
        
        function getCalendarDataInDB(){
    	    //배열 초기화

    	      console.log("ajax2 : " + searchDate)
    	    var arr = [];
    	    $.ajax({

    	        url: "${ pageContext.servletContext.contextPath }/cleaner/request/ajax2",
    	        type:'post',
    	        success:function(data){
    	        	for(var i in data) {
    	    			var calendar2 = data[i];
						console.log(calendar2)
						calendar.addEvent( calendar2);
    	        	}
    	        	
    	        },
    	        error:function(){
    	            alert('저장 중 에러가 발생했습니다. 다시 시도해 주세요.');
    	        }
    	    });
    	    
    	    return arr;
    	}

  	      calendar.render();
        
        $("#match").on("click", function(){ 
			const status = this.value;
			var date = calendar.getDate();
	      	var year = date.getFullYear();
	      	var month = date.getMonth();
	      	console.log(year)
	      	console.log(month)
	      	var firstDate = new Date(year + "-" + (month + 1) + "-" + "02")
	      	console.log("firstDate" + firstDate)
	      var searchDate = firstDate.toISOString();
	        console.log(searchDate);
			$.ajax({
    			url: "${ pageContext.servletContext.contextPath }/cleaner/request/ajax",
    			type: "get",
    			data: {
    				date : searchDate,
					status : status
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
        
        $("#complete").on("click", function(){ 
			const status = this.value;
			var date = calendar.getDate();
	      	var year = date.getFullYear();
	      	var month = date.getMonth();
	      	console.log(year)
	      	console.log(month)
	      	var firstDate = new Date(year + "-" + (month + 1) + "-" + "02")
	      	console.log("firstDate" + firstDate)
	      var searchDate = firstDate.toISOString();
	        console.log(searchDate);
			$.ajax({
    			url: "${ pageContext.servletContext.contextPath }/cleaner/request/ajax",
    			type: "get",
    			data: {
    				date : searchDate,
					status : status
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
                	<button id="match" name="match" value="매칭              ">매칭된 의뢰</button><button id="complete" name="complete" value="완료              ">완료된 의뢰</button>
                    <div class="blog__sidebar">   
                        
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