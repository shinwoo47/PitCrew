<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	<div class="dashboard-wrapper">
            <div class="container-fluid dashboard-content">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
            <h3>사용자 공지사항</h3><br>
            <div class="row" style="background-color: #02A79D">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h3 style="color:#fff">No</h3>
                    </div>
            </div>
            </div>
            
    		
    </div>
</body>
</html>