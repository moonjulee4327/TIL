let CDate = new Date();
let today = new Date();

buildCalender();

function buildCalender(){
    let prevLast = new Date(CDate.getFullYear(), CDate.getMonth(), 0);
    let thisFirst = new Date(CDate.getFullYear(), CDate.getMonth(), 1);
    let thisLast = new Date(CDate.getFullYear(), CDate.getMonth() + 1, 0);
    document.querySelector(".yearTitle").innerHTML = CDate.getFullYear();
    document.querySelector(".monthTitle").innerHTML = CDate.getMonth() + 1;
    let dates = [];
    if(thisFirst.getDay()!=0){
        for(let i = 0; i < thisFirst.getDay(); i++){
            dates.unshift(prevLast.getDate()-i);
        }
    }
    for(let i = 1; i <= thisLast.getDate(); i++){
        dates.push(i);
    }
    for(let i = 1; i <= 13 - thisLast.getDay(); i++){
        dates.push(i);
    }
    let htmlDates = '';
    for(let i = 0; i < 42; i++){
        if(today.getDate()==dates[i] && today.getMonth()==CDate.getMonth() && today.getFullYear()==CDate.getFullYear()){
            htmlDates += `<div class="date today">`+ dates[i] +`</div>`;
        }
        else{
            htmlDates += `<div class="date">${dates[i]}</div>`;
        }
    }
    document.querySelector(".dates").innerHTML = htmlDates;
}

function prevCal(){
    CDate.setMonth(CDate.getMonth()-1);
    buildCalender();
}

function nextCal(){
    CDate.setMonth(CDate.getMonth()+1);
    buildCalender();
}
