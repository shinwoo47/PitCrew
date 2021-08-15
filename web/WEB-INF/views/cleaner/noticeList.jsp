<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡겨줘 홈즈 관리자 모드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&display=swap" rel="stylesheet">
    

    <!-- Css Styles -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/slicknav.min.css" type="text/css"> 
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/common/css/style.css" type="text/css">
<style>
	.hidden {
		display: none;
	}
</style>
</head>
<body>
	<!-- 네비 -->
	<jsp:include page="../cleaner/cleanermenubar.jsp"/>
	<div class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
            <h3>사용자 공지사항</h3><br>
          <!--  <div class="row" style="background-color: #02A79D">
              <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                        <h3 style="color:#fff">No</h3>
                    </div>
            </div>-->
            
          <button type="button" id="writeBoard">글쓰기</button>
         <table id="boardList">
         	<tr>
         		<th class="hidden" width="100px">NO</th>
         		<th width="300px">제목</th>
   				<th width="100px">작성자</th>
   				<th width="100px">등록일</th>
   				<th>조회</th>
         	</tr>
         	<tr></tr>
         	<c:forEach items="${ requestScope.noticeList }" var="notice">
					<tr>
						<td class="hidden"><c:out value="${ notice.no }"/></td>
						<td><c:out value="${ notice.title }"/></td>
						<td><c:out value="${ notice.writer.name }"/></td>
						<td><c:out value="${ notice.writeDate }"/></td>
						<td><c:out value="${ notice.count }"/></td>
					</tr>
			</c:forEach>	
         	
         </table>         
         </div>
    </div>
    <script>
	    if(document.getElementsByTagName("td")) {
			
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "#00C1B6";
					this.parentNode.style.cursor = "pointer";
				}
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "#fff";
				}
				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/admin/notice/detail?no=" + no;
				}
				
			}
			
		}
    
	    if(document.getElementById("writeBoard")) {
			const $writeNotice = document.getElementById("writeBoard");
			$writeNotice.onclick = function() {
				location.href = "${ pageContext.servletContext.contextPath }/admin/notice/insert";
			}
		}
    
    
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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