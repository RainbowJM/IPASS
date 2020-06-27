const DELETEBUTTON = document.getElementById('delete');

// set listener
DELETEBUTTON.addEventListener("click", deleteAppointment);

function deleteAppointment(){
    const APPOINTMENTIDELEMENT = document.getElementById("appointment-id").value;
    console.log("info" + APPOINTMENTIDELEMENT);
    if (APPOINTMENTIDELEMENT.trim() === ""){
        console.log("infom" + APPOINTMENTIDELEMENT);
        alert("Please enter your informations")
        return false;
    }else{
        const DELETEFORM = document.getElementById("deleteForm");
        let formData = new FormData(DELETEFORM);

        formData.append("appointmentId", APPOINTMENTIDELEMENT);

        for(var pair of formData.entries()) {
            console.log("valuepair " + pair[0] + ', '+ pair[1]); 
        }
        let encData = new URLSearchParams(formData.entries());
        for(var pair of encData.entries()) {
            console.log("encddata "+ pair[0] + ', '+ pair[1]); 
        }

        fetch("http://127.0.0.1:8080/restservices/appointment"+ APPOINTMENTIDELEMENT, {method: 'DELETE', body: encData})
        .then(function (response) {
            if(response.ok) {
                console.log("Appointment deleted")
                alert("Appointment has been deleted")
                return response.json();
            } else if (response.status == 404) {
                console.log("Appointment not found")
                alert ("Appointment doesn't exists");
            } else{
                console.log("Something didn't go good")
                alert ("Something when wrong")
            }
        });
    }
}