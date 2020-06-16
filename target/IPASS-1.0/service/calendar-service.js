export class calendarService{

    constructor(){
        this.calendar = new Map();
    }

    getSignUpInfo(){
        return fetch("http://127.0.0.1:8080/restservices/authentication", {method: 'POST', body: encData})
            .then(function (response) {
                if(response.ok) {
                    return response.json();
                }else {
                throw "Wrong username/password";}
            })
            .then(function(myJson){
                window.sessionStorage.setItem("myJWT", myJson.JWT);
                window.location = "calendar.html";
            })
            .catch(error => console.log(error));
    }
}