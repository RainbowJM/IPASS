package project.ipass.application.webservices;

import project.ipass.application.model.Calendar;
import project.ipass.application.model.Worker;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/workers")
public class WorkersResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<Worker> getAllworker(){
        return Calendar.getAllWorkers();
    }
}
