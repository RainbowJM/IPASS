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
    let formData = new FormData(document.querySelector("loginForm"));
    let encData = new URLSearchParams(formData.entries());

}

function signout(){
    localStorage.removeItem("username");
}