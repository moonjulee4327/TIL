function checkAddMem(){
	//<input type="text" id="productId" name="productId" />
	let memHp = document.getElementById("memHp");
	let memName = document.getElementById("memName");
	//<input type="text" id="name" name="name" />

	// 이름 체크
	if(memName.value == ""){
		alert("이름을 입력하세요");
		return false;
	}
	
	// 휴대폰번호 체크
	if(!check(/^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/
	, memHp 
	, "휴대폰 번호를 확인해 주세요")){
		return false;	//함수 멈춰
	}
	
	//regExp : 정규식 / e : 대상객체 / msg : 메시지
	function check(regExp, e, msg){
		//test() : 맞니?틀리니? / exec() : 찾자
		//i) e.value => P1234
		//ii) e.value => S1234
		//iii) e.value => 1200000.35(o)
		//iv) e.value => 1200000.357(x)
		if(regExp.test(e.value)){
			return true;
		}
		alert(msg);
		e.select();	//글자선택
		e.focus();	//커서위치
		return false; //check()를 호출한곳으로 false를 리턴
	}
	//<form name="newProduct" ...
	document.frm.submit();
}









