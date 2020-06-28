// import {calendarService} from "../service/calendar-service.js";

// get element
const LOGINBUTTON = document.getElementById("login");

// set listener
LOGINBUTTON.addEventListener("click", signin);


function validateEmail(email){
    const REGX = /^([a-zA-Z0-9\.-_]+)@([a-zA-Z0-9-]+).([a-z]{2,10})$/;
    return REGX.test(String(email).toLowerCase());
}

function signin(event){
    let unameElement = document.getElementById("username").value;
    let pswElement = document.getElementById("password").value;
    console.log("elementValue", unameElement, pswElement);
    if(unameElement.trim() === "" || pswElement.trim() === ""){
        alert("Please enter username and password");
        return false;
    }else{
        let loginform = document.getElementById("loginForm");
        let formData = new FormData(loginform);
        formData.append('username',unameElement);
        formData.append('password',pswElement);
        for(var pair of formData.entries()) {
            console.log("valuepair " + pair[0]+ ', '+ pair[1]); 
        }
        let encData = new URLSearchParams(formData.entries());
        for(var pair of encData.entries()) {
            console.log("encddata "+pair[0]+ ', '+ pair[1]); 
        }
        fetch("http://127.0.0.1:8080/restservices/authentication", {method: 'POST', body: encData})
        .then(function (response) {
            if(response.ok) {
                console.log("h");
                return response.json();
            }else {
                console.log("HH")
            throw "Wrong username/password";}
        })
        .then(function(myJson){
            window.sessionStorage.setItem("myJWT", myJson.JWT);
            window.location = "calendar.html";
        })
        .catch(error => console.log(error));
        return true;
    }
}

