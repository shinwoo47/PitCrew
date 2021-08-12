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
	
	if(document.getElementById("cleana")) {
		const $cleana = document.getElementById("cleana");
		$cleana.onclick = function() {
			console.log(1);
			location.href = "/pitcrew/user/clean/select?number=" + 1;
			
		}
	}
	if(document.getElementById("cleanb")) {
		const $cleanb = document.getElementById("cleanb");
		$cleanb.onclick = function() {
			location.href = "/pitcrew/user/clean/select?number=" + 2;
		}
	}
	if(document.getElementById("cleanc")) {
		const $cleanc = document.getElementById("cleanc");
		$cleanc.onclick = function() {
			location.href = "/pitcrew/user/clean/select?number=" + 3;
		}
	}
	
		
}

