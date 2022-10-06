function addBookCheck() {
    let form = document.newBook;

    let id = form.bookId.value;
    let name = form.name.value;
    let price = form.unitPrice.value;
    let stock = form.unitsInStock.value;
	
	let idCheck = /^ISBN[0-9]{1,8}$/;
    let nameCheck = /^.{4,12}$/;

	if(!idCheck.test(id)){
		alert("ISBN과 숫자를 조합하여 5~12자까지 입력하세요!\n첫글자는 반드시 ISBN로 시작하세요!");
        return false;
	}

    if(!nameCheck.test(name)){
        alert("도서 명의 길이는 4~12글자로 등록해주세요!");
        return false;
    }


    if(price == "" || price<0 || isNaN(price)){
        alert("가격 설정을 다시 해주세요!");
        return false;
    }

    if(isNaN(stock)){
        alert("재고수를 확인해주세요!");
        return false;
    }

}