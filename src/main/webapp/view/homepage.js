function validateLogin(){
    let unameElement = document.getElementById("username");
    let pswElement = document.getElementById("password").value;
    if(unameElement.value.trim() === "" || pswElement.value.trim() === ""){
        alert("Please enter username and password");
        return false;
    }else{
        return true;
    }
}

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
        formData.append("a","b");
        console.log("your dick", formData.values());
        let encData = new URLSearchParams(formData.entries());
        // console.log(formData, encData);

        fetch("http://127.0.0.1:8080/restservices/authentication", {method: 'POST', body: encData})
        .then(function (response) {
            if(response.ok) {
                alert(ok);
                console.log(respone.json());
                return response.json();
            }else {
                alert("wrong");
            throw "Wrong username/password";
        }
            
        })
        .then(myJson => window.sessionStorage.setItem("myJWT", myJson.JWT))
        .catch(error => alert(error) );
        return true;
    }
}


document.querySelector("#login").addEventListener("click", login);

function signout(){
    localStorage.removeItem("username");
}