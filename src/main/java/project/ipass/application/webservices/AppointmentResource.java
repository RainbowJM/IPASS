package project.ipass.application.webservices;

import project.ipass.application.model.Appointment;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Appointment")
public class AppointmentResource {

    @DELETE
    @Path("delete/{appointmentid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAppointment(@PathParam("appointmentid") int id){
        return Appointment.removeAppointment(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
