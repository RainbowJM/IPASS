package project.ipass.application.webservices;

import project.ipass.application.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/Appointment")
public class AppointmentResource {

//    @POST
//    @Path("/addAppointment")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createAppointment(@FormParam("day")LocalDate date,
//                                      @FormParam("hour")int time,
//                                      @FormParam("type-service") Service service,
//                                      @FormParam("client") Client clnt,
//                                      @FormParam("worker") Worker worker){
//        for (Appointment appoint : Calendar.getAllAppointments()){
//            if
//        }
//    }

    @DELETE
    @Path("deleteAppointment/{appointmentid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAppointment(@PathParam("appointmentid") int id){
        return Appointment.removeAppointment(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
