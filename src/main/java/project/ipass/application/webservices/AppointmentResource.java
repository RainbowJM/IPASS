package project.ipass.application.webservices;

import project.ipass.application.model.*;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/appointment")
public class AppointmentResource {
//
//    @POST
//    @PermitAll
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createAppointment(@FormParam("day") Date date,
//                                      @FormParam("hour") int time,
//                                      @FormParam("serviceId") int serviceId,
//                                      @FormParam("clientId") int clientId,
//                                      @FormParam("workerId") int workerId){
//
//        for (Appointment appoint : Calendar.getAllAppointments()){
//            if
//        }
//    }

    @DELETE
    @PermitAll
    @Path("deleteAppointment/{appointmentid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAppointment(@PathParam("appointmentid") int id){
        return Appointment.removeAppointment(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
