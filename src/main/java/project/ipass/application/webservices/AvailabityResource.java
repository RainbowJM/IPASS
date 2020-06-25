package project.ipass.application.webservices;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/availabity")
public class AvailabityResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAvailabity(){
        return null;
    }

}
