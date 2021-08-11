window.onload = function() {
	
	if(document.getElementById("selectUpdate")) {
		const $selectUpdate = document.getElementById("selectUpdate");
		$selectUpdate.onclick = function() {
			location.href = "/pitcrew/user/select/update/myInfo";
		}
	}
	
	if(document.getElementById("updateMyInfo")) {

		var newPwd = document.getElementById("newPwd").value;
		var retypeNewPwd = document.getElementById("retypeNewPwd").value;
		if(newPwd != retypeNewPwd) {
			$updateMyInfo.onclick = function() {
				alert("비밀번호가 일치하지 않습니다.ㅃㅃ");
				return false;
			}
		} else {
			$updateMyInfo.onclick = function() {
				location.href ="/pitecrew/user/update/myInfo";
			}
		}
	}
		
}

