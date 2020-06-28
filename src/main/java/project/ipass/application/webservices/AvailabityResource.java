package project.ipass.application.webservices;

import project.ipass.application.model.Appointment;
import project.ipass.application.model.Availability;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.Date;

@Path("/availabity")
public class AvailabityResource {

    @POST
//    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAvailabity(@FormParam("from")String dateF,
                                     @FormParam("till")String dateT,
                                     @FormParam("description")String desc){
        Date df = Appointment.parseDate(dateF);
        Date dt = Appointment.parseDate(dateT);
        for (Availability avai : Availability.getAllAvailability()){
            if (avai.getFrom().equals(df) && avai.getTill().equals(dt)){
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(new AbstractMap.SimpleEntry<String, String>("Error", "The time period is already booked"))
                        .build();
            }
        }
        return Response.ok(new Availability(df, dt,desc)).build();
    }

}
