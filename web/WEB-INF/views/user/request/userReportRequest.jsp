<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Clean Home</title>
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
                        <form action="${ pageContext.servletContext.contextPath }/user/request/report" method="post" onsubmit="return check()" encType="multipart/form-data">
							  <h2 style="padding-bottom:100px;">신고 작성</h2>      
							  <table class="table table-hover">
							    <tbody>
							      <tr>
							        <td>신고 사유</td>
							        <td>
							        	<select style="padding:5px;" id="reportCategory" name="reportCategory">
											<option value="5">서비스 응대 불량</option>
											<option value="6">서비스 상태 불량</option>
											<option value="7">기물 파손</option>
											<option value="8">기타 사유</option>
										</select>
									</td>
							      </tr>
							      <tr>
							        <td>첨부파일</td>
							        <td>
							        	<input type="hidden" name="reqNo" id="reqNo" value="${ reqNo }"/>
										<input type="file" name="report" multiple><br>
                        			</td>
							      </tr>
							      <tr>
							        <td>상세 내용</td>
							       	<td colspan="3">
										<textarea id="body" name="body" cols="60" rows="15" style="resize:none;"></textarea>
									</td>
							      </tr>
							    </tbody>
							    	<td><button type="reset">취소하기</button></td>
							      	<td><button type="submit">신고하기</button></td>
							  </table>
							  </form>
							</div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
    
    	function check() {
    		if($("#body")[0].value == "") { 
    			alert("내용을 입력해 주세요");
    			$("#body").focus();
    			return false;
    		}
    		return true;
    	}
    	
    	window.onload = function() {
    		
    		$("#report").on("click", function() {
    			const no = $("#reqNo").val();
    			console.log(no)
    			location.href = "${ pageContext.servletContext.contextPath }/user/request/report?no=" + no;
    		});
    	}
    </script>
</body>
</html>