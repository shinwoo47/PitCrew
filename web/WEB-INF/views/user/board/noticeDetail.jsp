<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clean Home</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	.hidden {
		display: none;
	}
	.dashboard-wrapper {
		position: absolute;
		top: 30%;
		left: 50%;
		transform: translate(-50%, -50%);
	}
	.container-fluid dashboard-content {
		position: absolute;
		left: 50%;
		transform: translate(-50%, -50%);
	}
	
	.contentax {
		left: 100%;
	}
	.content {
		text-align: center;
	margin: auto;
	width: 50%;
	}
	
</style>	
</head>
<body>
	<!-- 네비 -->
	<jsp:include page="../userMenubar.jsp"/>
	<div class="dashboard-wrapper">
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
         </div>
         <table>
         	<tr id="detailhead">
         		<th class="hidden" id="no">${ noticeDTO.no }</th>
         		<th width="250px">제목 : ${ noticeDTO.title }</th>
   				<th width="200px">작성자 : ${ noticeDTO.writer }</th>
   				<th width="200px">작성일: ${ noticeDTO.writeDate }</th>
   				<th>조회 : ${ noticeDTO.count }</th>
         	</tr>
         </table>
         <div>
         	<label>${ noticeDTO.content }</label>
         </div>  
         <div style="text-align:center"><br>
         <c:if test="${ category == 'PERSONAL' }">
         	<div class="content">
	         <button id="update" style="background-color: #02A79D; color: white">수정하기</button>  
	         <button id="delete" style="background-color: #02A79D; color: white">삭제하기</button>  
	         
         	</div>
	     </c:if>      
         </div>       
    </div>
	<script>
	if(document.getElementById("update")) {
		const $update = document.getElementById("update");
		$update.onclick = function() {
			const no = document.getElementById("no").innerText;
			location.href = "${ pageContext.servletContext.contextPath }/user/notice/update?no=" + no;
		}
	}
	if(document.getElementById("delete")) {
		const $delete = document.getElementById("delete");
		$delete.onclick = function() {
			const no = document.getElementById("no").innerText;
			location.href = "${ pageContext.servletContext.contextPath }/user/notice/delete?no=" + no;
		}
	}
	
	    
    </script>
</body>
</html>