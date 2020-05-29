let today = new Date();
let currentMonth = today.getMonth();
let currentYear = today.getFullYear();
let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

let monthAndYear = document.getElementById("month-and-year");

const card = document.querySelector("#application");

const isWeekend = day =>{
    //0 when it's sunday, 6 when it's saturday
    return day % 7 === 0 || day % 7 === 6;
}

showCurrentMonthYear(currentMonth, currentYear);
monthYearInText();

function showCurrentMonthYear(month, year){
    let firstDay = new Date(year, month).getDay();
    let daysInMonth = 32 - (new Date(year, month, 32)).getDate();

    card.innerHTML= "";

    let date = 1

    // i is row
    for(let i = 0; i < 6; i++){
        

        for(let j = 0; j < 7; j++){
            if(i === 0 && j< firstDay){
                let cell = document.createElement("td")
                let cellText = document.createTextNode("");
                cell.appendChild(cellText);
                row.appendChild(cell);
            } else if(date> daysInMonth){
                break;
            }else{
                let cell = document.createElement("td")
                let cellText = document.createTextNode(date);
                cell.appendChild(cellText);
                row.appendChild(cell);
            }
            date++;
        }
        table.appendChild(row);
    }
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

function today(){
    today = new Date();
    currentMonth = today.getMonth();
    currentYear = today.getFullYear();
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();
}