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
	<jsp:include page="../menubar.jsp"/>
	<div class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
            <h3>사용자 공지사항</h3><br>
         </div>
         <table class="text-center">
         	<tr id="detailhead" height="30">
         		<th class="hidden" id="no">${ noticeDTO.no }</th>
         		<th width="500px">제목 : ${ noticeDTO.title }</th>
   				<th width="100px">작성자 : ${ noticeDTO.writer.name }</th>
   				<th width="200px">작성일: ${ noticeDTO.writeDate }</th>
   				<th width="100px">조회 : ${ noticeDTO.count }</th>
         	</tr>
         	<tr height="12"></tr>
         	<tr class="text-left" height="300" style="margin: 5px; padding: 10px;">
         		<td colspan="4">${ noticeDTO.content }</td>
         	</tr>
         </table>  
         <div style="text-align:center";>
         <button type="submit" style="margin: 5px; background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">수정하기</button>
         <button class="delete" style="margin: 5px; background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">삭제하기</button>
         <button class="reset" style="margin: 5px; background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">목록으로</button>
         </div>       

    </div>
    <script>
    $("button[type=reset]").click(function() {
    	
    	if(confirm("페이지를 벗어나시겠습니까?")) {
    		history.back();
    	} 	    	
    });		    
    
    
    </script>
</body>
</html>