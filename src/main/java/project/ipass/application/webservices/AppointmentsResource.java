package project.ipass.application.webservices;

import project.ipass.application.model.Appointment;
import project.ipass.application.model.Calendar;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/appointments")
public class AppointmentsResource {

    @GET
    @PermitAll
    @Produces
    public List<Appointment> getAllAppointments(){
        return Calendar.getAllAppointments();
    }
}
