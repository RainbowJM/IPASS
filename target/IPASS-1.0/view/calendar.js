let today = new Date();
let currentMonth = today.getMonth();
let currentYear = today.getFullYear();
let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

let monthAndYear = document.getElementById("month-and-year");

const CALENDAR = document.querySelector("#application");

const SETDATE = document.getElementById("selectDay");

const ISWEEKEND = day =>{
    //0 when it's sunday, 6 when it's saturday
    return day % 7 === 0 || day % 7 === 6;
}

showCurrentMonthYear(currentMonth, currentYear);
monthYearInText();

function showCurrentMonthYear(month, year){
    let firstDay = new Date(year, month);
    let daysInMonth = 32 - (new Date(year, month, 32)).getDate();

    CALENDAR.innerHTML = "";

    let date = 1;
    let getFirstDayOfTheMonth = new Date(firstDay.getFullYear(), firstDay.getMonth(), 0).getDay();

    for(let i = 0; i < 6; i++){

        for(let j = 0; j < 7; j++){
            const weekend = ISWEEKEND(date);
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
            CALENDAR.insertAdjacentHTML("beforeend",out);            
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
// function to move to the previous month on the calendar
function previous(){
    currentYear = currentMonth === 0 ? currentYear  - 1: currentYear;
    currentMonth = currentMonth === 0 ? 11 : currentMonth - 1;
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();

}
// function to move to the next month on the calendar
function next(){
    currentYear = currentMonth === 11 ? currentYear + 1 : currentYear;
    currentMonth = (currentMonth + 1) % 12;
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();
}
// function to move to today on calendar
function dayToday(){
    today = new Date();
    currentMonth = today.getMonth();
    currentYear = today.getFullYear();
    showCurrentMonthYear(currentMonth, currentYear);
    monthYearInText();
}

// get modal element
const MODAL = document.getElementById("appointmentModal");
// get open modal button
const MODALBUTTON = document.getElementById("add-appointment");
// get close modal button
const MODALCLOSEBUTTON = document.getElementsByClassName("close-button")[0];

// listener for open modal click
MODALBUTTON.addEventListener("click", openModal);
// listener for close modal click
MODALCLOSEBUTTON.addEventListener("click", closeModal);
// listener for outside click
window.addEventListener("click", clickOutside);

// function to open modal
function openModal(){
    MODAL.style.display = "block";
}
// function to close modal 
function closeModal(){
    MODAL.style.display = "none";
}
// function to close modal from a outside click
function clickOutside(e){
    if(e.target == MODAL){
        MODAL.style.display = "none";
    }
}
// function openModal(modal) {
//     if (modal == null) return

//     currentDay = event.currentTarget.textContent

//     const isUnderTen = number =>{
//         return number < 10;
//     }

//     if(currentDay === 'Add Time'){
//         dateSetter.innerHTML=`<label for="selectedDay">Select a day</label>
//         <input type="date" name="selectedDay" id="selectedDay" value="${currentYear}-${isUnderTen(currentMonth) ? "0" + currentMonth : currentMonth}-01">`;
//     }else{
//         dateSetter.innerHTML=`<label for="selectedDay">Select a day</label>
//         <input type="date" name="selectedDay" id="selectedDay" value="${currentYear}-${isUnderTen(currentMonth) ? "0" + currentMonth : currentMonth}-${isUnderTen(currentDay) ? "0" + currentDay : currentDay}">`;
//     }    
//     modal.classList.add('active')
//     overlay.classList.add('active')
// }

// function closeModal(modal) {
//     if (modal == null) return
//     modal.classList.remove('active')
//     overlay.classList.remove('active')
// }