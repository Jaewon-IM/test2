function idCheck(){
	window.open("/member/idCheck", "_blank", "width=600, height=600");
	
}
			
function formCheck(){
	
	var memberId = document.getElementById("id").value;
	var memberPw = document.getElementById("password").value;	
	var checkPw = document.getElementById("checkPw").value;
	var memberName = document.getElementById("name").value;
	
	// ID 공백, 글자수 체크
	/*if(!checkUserId(memberId)){
		return false;
	}*/
	
	// PW 공백, 글자수 체크
	if(!checkUserPw(memberId, memberPw, checkPw)){
		return false;
	}
	
	// 이름 공백, 글자수 체크
	if(!checkUserName(memberName)){
		return false;
	}

	// 생년월일 작성 여부
	if(!checkBirth()){
		return false;
	}

	// 성별 선택 여부 체크
	if(!checkGender()){
		return false;
	}

	// 휴대폰 번호 작성 여부 체크
	if(!phoneCheck()){
		return false;
	}

	alert("회원가입이 성공했습니다!");
	return true;
}

// 공백 체크(필수 입력)
function checkExistData(value, dataName){
	if(value == ""){
		alert(dataName + "을(를) 입력해주세요!");
		return false;
	}
	return true;
}

// ID 공백, 글자수 체크
function checkUserId(id){
	if(!checkExistData(id, "아이디")){ 
		return false;
	}
	
	if(id.length < 4 || id.length > 12){ // 유효성 검사 통과하지 못한 경우
		alert("ID는 4~12글자 사이로 입력하세요.");
		return false;
	}
	
	return true;
}

//PW 공백, 글자수 체크
function checkUserPw(id, password, checkPw){
	if(!checkExistData(password, "비밀번호")){ 
		return false;
	}
	
	if(!checkExistData(checkPw, "비밀번호 확인")){ 
		return false;
	}
	
	
	if(password.length < 5 || password.length > 8){ // 유효성 검사 통과하지 못한 경우
		alert("PW는 5~8글자 사이로 입력하세요.");
		return false;
	}
	
	if(password != checkPw){
		alert("비밀번호가 같지 않습니다.");
		return false;
	}
	
	if(id == password){
		alert("아이디와 비밀번호는 같을 수 없습니다!");
		return false;
	}
	
	return true;
}

// 이름 공백,글자수 체크
function checkUserName(name){
	if(!checkExistData(name, "이름")){ 
		return false;
	}
	
	if(name.length < 2 || name.length > 10){ // 유효성 검사 통과하지 못한 경우
		alert("이름은 2~10글자 사이로 입력하세요.");
		return false;
	}
	
	return true;
}

// 생년월일
function checkBirth(){
	var birth = document.form;
	
	// 년도가 비어있다면
	if(birth.birth.value == ""){
		alert("생년월일을 입력해 주세요.");
		return false;
	}
		
	return true;
}

// 통신사 선택 여부 체크
function checkGender(){
	// 변수에 radio버튼 값을 저장
	var gender = document.getElementsByName("gender");
	
	// 그 값중 하나라도 체크가 되있으면 true를 반환
	for(var i=0;i<gender.length;i++){
		if(gender[i].checked == true){
			return true;
		}
	}
	
	alert("성별을 선택해주세요.");
	return false;
}

// 휴대폰 번호 작성여부
function phoneCheck(){
	var phone = document.form;
	var chk = /[^0-9]/g;
	
	// 휴대폰 입력이 공백이라면
	if(phone.phone.value == ""){
		alert("휴대폰 번호를 입력하세요");
		return false;
	}

	// 휴대폰 번호는 숫자만 입력 가능
	if(chk.test(phone.phone.value)){
		alert("휴대폰 번호는 숫자만 입력해 주세요");
		return false;
	}
	
	return true;
}



