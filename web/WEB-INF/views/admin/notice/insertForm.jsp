<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>맡겨줘 홈즈 관리자 모드</title>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	<div class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
         	<div style="display: block">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
          	</div>
          <form action="${ pageContext.servletContext.contextPath }/admin/notice/insert" method="post">
          	<div>
          	<label class="custom-control custom-radio custom-control-inline">
            	<input type="radio" class="custom-control-input" name="forWho" value="사용자"><span class="custom-control-label">사용자</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" class="custom-control-input" name="forWho" value="해결사"><span class="custom-control-label">해결사</span>
            </label>
            <br><br></div>
			
		  	<div class="container" style="padding: 20px;">
		  	<label class="col-form-label">제목 :</label>
            <input type="text" name="title" style="width: 1000px; height: 50px;">
            <hr>
 		 	<textarea class="summernote" name="editordata"></textarea>    
		 	</div>
		 	
			<div style="text-align:center; padding: 10px; justify-content: space-between;">
         			<button type="submit" style="background-color: #02A79D; color: white;border-color:transparent; border-radius:0.3rem;">작성완료</button>
         			<button type="reset" style="background-color: #02A79D; color: white; border-color:transparent; border-radius:0.3rem;">목록으로</button>
         	</div>
         </form>
    </div> 
  </div> 
  <script>
$('.summernote').summernote({
	  height: 300,
	    lang: "ko-KR",
	  focus : true	  
	});
	
$("button[type=reset]").click(function() {
	
	if(confirm("페이지를 벗어나시겠습니까?")) {
		history.back();
	} 	
	
	
});	
</script> 
</body>
</html>