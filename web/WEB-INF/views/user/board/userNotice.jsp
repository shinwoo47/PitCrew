<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 공지사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 	<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/user/css/style.css" type="text/css">
    
<style>
	.hidden {
		display: none;
	}
	.container-fluid dashboard-content {
		background: red;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
	}
	#writeBoard {
		background-color: #02A79D;
		color: white;
	}
</style>
</head>
<body>
	<jsp:include page="../userMenubar.jsp"/>
    
    
	<div class="centera">
	<div align="center" class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
         	 <c:if test="${ category == '공지' }">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
         	 </c:if>
         	 <c:if test="${ category == 'FAQ' }">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/faq.png">
         	 </c:if>
         	 <c:if test="${ category == 'PERSONAL' }">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/personal.png">
         	 </c:if>
        
          
         <table id="boardList">
         	<tr>
         		<th class="hidden" width="100px">NO</th>
         		<th width="300px">제목</th>
   				<th width="100px">작성자</th>
   				<th width="100px">등록일</th>
   				<th>조회</th>
         	</tr>
         	<c:forEach items="${ requestScope.noticeList }" var="notice">
					<tr>
						<td class="hidden"><c:out value="${ notice.no }"/></td>
						<td><c:out value="${ notice.title }"/></td>
						<td><c:out value="${ notice.writer }"/></td>
						<td><c:out value="${ notice.writeDate }"/></td>
						<td><c:out value="${ notice.count }"/></td>
					</tr>
			</c:forEach>	
         	
         </table>         
         </div><br><br>
     <c:if test="${ category == 'PERSONAL' }">
            <button type="button" id="writeBoard">글쓰기</button>
            </c:if>
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
				location.href = "${ pageContext.servletContext.contextPath }/user/notice/detail?no=" + no;
			}
			
		}
		
	}
	    
	    if(document.getElementById("writeBoard")) {
			const $writeNotice = document.getElementById("writeBoard");
			$writeNotice.onclick = function() {
				location.href = "${ pageContext.servletContext.contextPath }/user/notice/insert";
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