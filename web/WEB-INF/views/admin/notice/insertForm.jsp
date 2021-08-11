<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/admin/board/summernote-lite.js"></script>
<script src="${ pageContext.servletContext.contextPath }/resources/admin/board/summernote-ko-KR.js"></script>
 <link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/resources/admin/board/summernote-lite.css">
<title>맡겨줘 홈즈 관리자 모드</title>
</head>
<body>
	<jsp:include page="../menubar.jsp"/>
	<div class="dashboard-wrapper">
         <div class="container-fluid dashboard-content">
                	<img src="${ pageContext.servletContext.contextPath }/resources/admin/assets/images/notice.png">
            <h3>사용자 공지사항</h3><br>
           
		  <form method="post">
		  <textarea id="summernote" name="editordata"></textarea>
		</form>
    </div> 

    <script>
    $(document).ready(function() {
    	$('#summernote').summernote({
    		  height: 150                 // 에디터 높이
    		  minHeight: null,             // 최소 높이
    		  maxHeight: null,             // 최대 높이
    		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
    		  lang: "ko-KR",					// 한글 설정
    		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
              
    	});
    });
    
    </script>
</body>
</html>