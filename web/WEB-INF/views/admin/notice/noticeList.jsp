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
    
    
    
    
</body>
</html>