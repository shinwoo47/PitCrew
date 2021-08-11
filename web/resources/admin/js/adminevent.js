window.onload = function() {
	
	if(document.getElementById("writeBoard")) {
		const $writeNotice = document.getElementById("writeBoard");
		$writeNotice.onclick = function() {
			location.href = "${ pageContext.servletContext.contextPath }/admin/notice/insert";
		}
	}
	
	
}