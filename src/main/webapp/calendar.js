let today = new Date();
let currentMonth = today.getMonth();
let currentYear = today.getFullYear();
let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

let monthAndYear = document.getElementById("month-and-year");

const calendar = document.querySelector("#application");

const isWeekend = day =>{
    //0 when it's sunday, 6 when it's saturday
    return day % 7 === 0 || day % 7 === 6;
}

showCurrentMonthYear(currentMonth, currentYear);
monthYearInText();

function showCurrentMonthYear(month, year){
    let firstDay = new Date(year, month);
    let daysInMonth = 32 - (new Date(year, month, 32)).getDate();

    calendar.innerHTML = "";

    let date = 1;
    let getFirstDayOfTheMonth = new Date(firstDay.getFullYear(), firstDay.getMonth(), 0).getDay();

    for(let i = 0; i < 6; i++){

        for(let j = 0; j < 7; j++){
            const weekend = isWeekend(date);
            let out = "";

            if((i === 0 && j < getFirstDayOfTheMonth )|| date > daysInMonth){
                out = `<div class="day color"></div>`;
                // let newDiv = document.createElement("div");
                // newDiv.className = "day color";
                // newDiv.appendChild(out);
            }else{
                out = `<a href="#"><div class="day ${weekend? "weekend" : ""}">${date}</div></a>`;
                // let newDiv = document.createElement("div");
                // newDiv.className = "day";
                // let newContent = document.createTextNode(date);
                date++;              
            }
            calendar.insertAdjacentHTML("beforeend",out);            
        }
    }

document.querySelectorAll("#application .day").forEach(
        day =>{
            day.addEventListener("click", event =>{
                console.log(event.currentTarget)
                event.currentTarget.classList.toggle("selected");
            })
        }
    )
}

function monthYearInText(){
    let monthYearText = document.createTextNode(months[currentMonth] + " "+ currentYear);
    monthAndYear.innerHTML = " ";
    monthAndYear.appendChild(monthYearText);
}

function previous(){
    currentYear = currentMonth === 0 ? currentYear  - 1: currentYear;
    currentMonth = currentMonth === 0 ? 11 : currentMonth - 1;
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();

}

function next(){
    currentYear = currentMonth === 11 ? currentYear + 1 : currentYear;
    currentMonth = (currentMonth + 1) % 12;
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();
}

function dayToday(){
    today = new Date();
    currentMonth = today.getMonth();
    currentYear = today.getFullYear();
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();
}