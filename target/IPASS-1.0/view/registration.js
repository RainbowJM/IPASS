// get element
let firstNameElement = document.getElementById("first-name").value;
let lastNameElement = document.getElementById("last-name").value;
let usrElement = document.getElementById("username").value;
let pswElement = document.getElementById("password").value;

const SIGNUPBUTTON = document.getElementById('signup');

// set listener
SIGNUPBUTTON.addEventListener("click", signup);

function register(){
    if (firstNameElement.trim() === "" || lastNameElement.trim() === "" || usrElement.trim() === "" || pswElement.trim() === ""){
        alert("Please enter your informations")
        return false;
    }else{
        let registerForm = document.getElementById("registerForm");
        let formData = new FormData(registerForm);

        formData.append("firstName", firstNameElement);
        formData.append("lastName", lastNameElement);
        formData.append("username", usrElement);
        formData.append("password", pswElement);

        for(var pair of formData.entries()) {
            console.log("valuepair " + pair[0] + ', '+ pair[1]); 
        }
        let encData = new URLSearchParams(formData.entries());
        for(var pair of encData.entries()) {
            console.log("encddata "+ pair[0] + ', '+ pair[1]); 
        }

        fetch("http://127.0.0.1:8080/restservices/user", {method: 'POST', body: encData})
        .then(function (response) {
            if(response.ok) {
                console.log("hello")
                return response.json();
            }else {
                console.log("HELLO")
            throw "User already exists";}
        })
        .then(function(myJson){
           console.log(myJson);
        })
        .catch(error => console.log(error));
        return true;
    }
}