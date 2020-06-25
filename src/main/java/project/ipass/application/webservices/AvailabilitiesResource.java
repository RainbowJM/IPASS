package project.ipass.application.webservices;

import project.ipass.application.model.Availability;
import project.ipass.application.model.Calendar;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/availabilities")
public class AvailabilitiesResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<Availability> getAllAvailabities(){
        return Calendar.getAllAvailibalities();
    }
}
