<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
          	<div>
          	<label class="custom-control custom-radio custom-control-inline">
            	<input type="radio" name="radio-inline" class="custom-control-input"><span class="custom-control-label">사용자</span>
            </label>
            <label class="custom-control custom-radio custom-control-inline">
                 <input type="radio" name="radio-inline" class="custom-control-input"><span class="custom-control-label">해결사</span>
            </label>
			</div>
		  <div class="container">
 		 <textarea class="summernote" name="editordata"></textarea>    
		 </div>


<script>
$('.summernote').summernote({
	  height: 300,
	  lang: "ko-KR"
	});
</script>
    </div> 
  </div> 
   
</body>
</html>