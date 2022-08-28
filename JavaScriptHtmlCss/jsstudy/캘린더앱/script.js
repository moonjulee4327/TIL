let nav = 0; // 이동을 위한 변수 선언
let clicked = null; // 클릭시 ?? 변수선언

// 로컬에 있는지 확인
let event = localStorage.getItem("events") ? JSON.parse(localStorage.getItem("events")) : [] ;

const calendar = document.getElementById("calendar");
// 요일 상수 설정
const weekdays = ["일","월","화","수","목","금","토"];

function load(){
    // 데이트 객체를 통한 추출
    const dt = new Date();

    const year = dt.getFullYear();
    const month = dt.getMonth();
    const day = dt.getDate();

    // 이전달의 마지막 일자 확인
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    // 이번 달의 첫번째 일자 확인
    const firstDayOfMonth = new Date(year, month, 1);
    // 날짜 형식 설정
    const dateString = firstDayOfMonth.toLocaleDateString('en-ko', {
        weekday: "long",
        year: "numeric",
        momth:"numeric",
        day: "numeric",
    });

    // 달의 시작날짜 앞의 빈 공간
    const paddingDays = weekdays.indexOf(dateString.split(' ')[1]);

    // 빈 공간을 나타내는 for문
    for(let i=1; i<=paddingDays+daysInMonth; i++){

    }

    console.log(dateString);
}

load();