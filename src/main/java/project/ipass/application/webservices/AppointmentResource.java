package project.ipass.application.webservices;

import project.ipass.application.model.*;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.Date;

@Path("/appointment")
public class AppointmentResource {

//    @POST
//    @PermitAll
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response createAppointment(@FormParam("day") Date date,
//                                      @FormParam("hour") int time,
//                                      @FormParam("serviceId") Service service,
//                                      @FormParam("workerId") int workerId){
//        for (Service serv : Calendar.getAllServices()){
//            if (service.equals(serv.getService())){
//                String servName = serv.getServiceName();
//            }
//        }
//        for (Appointment appoint : Calendar.getAllAppointments()){
//            if (appoint.getDate().equals(date)){
//                if (appoint.getHour() == time){
//                    return Response
//                            .status(Response.Status.CONFLICT)
//                            .entity(new AbstractMap.SimpleEntry<String, String>("Error", "Can't make a appointment at this time"))
//                            .build();
//                }
//
//            }
//        }
//        return Response.ok(new Appointment(date, time, service, workerId));
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
