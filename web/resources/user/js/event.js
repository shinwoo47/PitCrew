window.onload = function() {
	
	if(document.getElementById("selectUpdate")) {
		const $selectUpdate = document.getElementById("selectUpdate");
		$selectUpdate.onclick = function() {
			location.href = "/pitcrew/user/select/update/myInfo";
		}
	}
	
	if(document.getElementById("updateMyInfo")) {
		
		const $updateMyInfo = document.getElementById("updateMyInfo");
		var newPwd = document.getElementById("newPwd").value;
		var retypeNewPwd = document.getElementById("retypeNewPwd").value;
		
		$updateMyInfo.onclick = function() {
			
			if(newPwd != retypeNewPwd) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			} else {
				location.href = "/pitcrew/user/update/myInfo";
			}
		}

	}
		
}

