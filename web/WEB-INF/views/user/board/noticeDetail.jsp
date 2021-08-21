<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맡겨줘 홈즈 관리자 모드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	.hidden {
		display: none;
	}
</style>	
</head>
<body>
	<!-- 네비 -->
	<div class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
            <h3>공지사항</h3><br>
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
         <div style="text-align:center";>
	         <button id="update" style="background-color: #02A79D; color: white">수정하기</button>  
         <c:if test="${ category == 'PERSONAL' }">
	         <form action="${ pageContext.servletContext.contextPath }/user/notice/delete" method="post">
	         <input type="hidden" name="no" value="${ noticeDTO.no }">
	         <button type="submit" style="background-color: #02A79D; color: white">삭제하기</button>
	         </form>  
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
	
	    
    </script>
</body>
</html>