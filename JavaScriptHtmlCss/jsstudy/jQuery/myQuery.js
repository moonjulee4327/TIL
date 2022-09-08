!function(){
    let $ = function(p_sel) {
            return new myDom(p_sel);
        }

    let myDom = function(p_sel) {
        let l_elems = document.querySelectorAll(p_sel);
        // 최초 넘어온 선택자 값을 저장만 해둠
        // jquery방식과 지금방식은 사용 상황에 따라 득과실이 다름
        this.prev = p_sel; // 실제 jquery는 이렇게 하지 않음
        this.length = l_elems.length;
        for(let i=0; i<l_elems.length; i++) { 
            this[i] = l_elems[i];
        }
        return this; 
    }

    myDom.prototype.메소드명 = function(){
        
    }

    
    window.$=$;
    $.fn = myDom.prototype; 
}();

// 메소드들
$.fn.eq = function(p_index){ 
    // 실제 jquery eq(index) 처럼 만들어 보기(메소드 체인닝 가능하게)
    // console.log(this[p_index]); 
    // console.log(this); 
    // return this[p_index];
    // 선택된 객체 1개만 남기고 this(여기선 myDom)을 리턴해야 함
    this[0] = this[p_index]; // 선택된 객체를 맨앞으로 옮기고
    for(let i = 0; i< this.length; i++){
        delete this[i];
    }
    this.length = 1; // eq는 무조건 1개
    return this; // 선택된 객체 1개만 가진 myDom타입 객체 리턴
}

// innerHTML속성을 컨트롤 하는 메소드, 필수 메소드
$.fn.html = function(p_arg){
    if(!p_arg){ // 읽기
        return this[0].innerHTML;
    }

    if(typeof(p_arg) == "string"){ // 쓰기
        for(let i = 0; i < this.length; i++){ 
            this[i].innerHTML = p_arg;
        }
        return this; // 메소드 체인닝이 구현됨
    }

    if(typeof(p_arg) == "function"){ // 쓰기
        for(let i = 0; i<this.length; i++) {
            this[i].innerHTML = p_arg.call(this[i], i, this[i].innerHTML);
        }
        return this; // 메소드 체인닝이 구현됨
    }
}

// 필수 메소드 태그의 속성을 제어하는 메소드, set/get attribute, .속성명
$.fn.attr = function(p_arg1, p_arg2){
    // alert(typeof(p_arg1)); //?
    if(typeof(p_arg1) == "string" && !p_arg2){ // 읽기
        return this[0][p_arg1]; // 첫번째 요소의 해당 속성값만 리턴
    }
    
    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "string"){ // 쓰기
        for(let i = 0; i< this.length; i++){
            this[i][p_arg1] = p_arg2; // .이 아니라 [][] json을 알기(배열식 접근법)
        }
        return this;
    }
    
    if(typeof(p_arg1) == "object" && !p_arg2){
        for(let i = 0; i < this.length; i++) {
            // 오타가 들어오면 속성이 들어와지기 때문에 체크 해야하지만 생략
            for(let l_attr in p_arg1){ // 객체 속성 loop -> for-in 문
                this[i][l_attr] = p_arg1[l_attr];
            }
        }
        return this;
    }

    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "function"){ // 플렉서블한 쓰기
        for(let i = 0; i< this.length; i++){
            console.log(this[i]);
            this[i][p_arg1] = p_arg2.call(this[i], i, this[i][p_arg1]);
        }
        return this;
    }
    
}

// val()메소드는 속성 value만 전문적으로 취급하기 위해 만들어졌다.
$.fn.val = function(p_arg){
    if(!p_arg){
        return this[0].value;
    }

    if(typeof(p_arg) == "string"){
        for(let i = 0; i < this.length; i++){
            // console.log(this[i].value);
            this[i].value = p_arg;
        }
        return this;
    }

    if(typeof(p_arg) == "function"){
        for(let i = 0; i<this.length; i++) {
            console.log(this[i]);
            this[i].value = p_arg.call(this[i], i, this[i].value);
        }
        return this;
    }
}

$.fn.click = function(p_cb){
    for(let i = 0; i <this.length; i++){
        this[i].onclick = p_cb;
    }
    return this; // 메소드 체인닝
}

$.fn.on = function(p_eName, p_cb){
    for(let i = 0; i < this.length; i++){
        this[i].addEventListener(p_eName, p_cb);
    }
    return this; // 메소드 체인닝
}

$.fn.empty = function(){
    for(let i = 0; i < this.length; i++){
        this[i].innerHTML = "";
    }
    return this; // 메소드 체인닝
}

// style객체를 다루는 메소드
$.fn.css = function(p_arg1, p_arg2){
    if(typeof(p_arg1) == "string" && !p_arg2){ // 읽기
        return this[0].style[p_arg1];
    }

    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "string"){ // 쓰기
        for(let i = 0; i< this.length; i++){
            this[i].style[p_arg1] = p_arg2;
        }
        return this; // 메소드 체인닝
    }
    
    if(typeof(p_arg1) == "string" && typeof(p_arg2) == "function"){ // 쓰기
        for(let i = 0; i< this.length; i++){
            this[i].style[p_arg1] = p_arg2.call(this[i], i, this[i].style[p_arg1]);
        }
        return this; // 메소드 체인닝
    }
}

$.fn.end = function(){
    // console.log($(this.prev)); // 이미 저장해둔 선택자 값으로 다시 생성
    return $(this.prev);
}

// jquery 메소드의 일관된 패턴(읽기, 전부 쓰기, 골라서 쓰기)
