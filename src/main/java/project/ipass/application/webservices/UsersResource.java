package project.ipass.application.webservices;

import project.ipass.application.model.Calendar;
import project.ipass.application.model.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UsersResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(){
        return Calendar.getAllUsers();
    }
}
