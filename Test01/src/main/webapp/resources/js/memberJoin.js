

function formCheck(){
	
	var memberId = document.getElementById("memberId").value;
	// id중복 체크 여부확인
	if(memberId.length < 3 || memberId.length > 10){
		alert("ID는 3~10자 사이로 입력해 주세요.");
		return false;
	}
	
	var memberPw = document.getElementById("memberPw").value;	
	
	if(memberPw.length < 3 || memberPw.length > 10){
		alert("비밀번호는 3~10글자 사이로 입력해주세요.");
		
		return false;
	}
	
	var memberName = document.getElementById("memberName").value;
	
	if(memberName.length < 1){
		alert("이름을 입력해주세요.");
		
		return false;
	}
	
	return true;
}


