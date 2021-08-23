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
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/faq.png">
            <h3>사용자 FAQ</h3><br>
         </div>
         <table>
         	<tr id="detailhead">
         		<th class="hidden">${ faqDTO.no }</th>
         		<th width="500px">제목 : ${ faqDTO.title }</th>
   				<th width="100px">작성자 : ${ faqDTO.writer.name }</th>
   				<th width="200px">작성일: ${ faqDTO.writeDate }</th>
   				<th>조회 : ${ faqDTO.count }</th>
         	</tr>
         	<tr></tr>
         	<tr>
         		<td colspan="4">${ faqDTO.content }</td>
         	</tr>
         </table>  
         <div style="text-align:center";>
         <button type="submit" style="background-color: #02A79D; color: white">수정하기</button>
         <button type="submit" style="background-color: #02A79D; color: white">삭제하기</button>
         <button type="reset" style="background-color: #02A79D; color: white">목록으로</button>
         </div>       

    </div>
</body>
</html>