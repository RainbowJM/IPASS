package project.ipass.application.webservices;

import project.ipass.application.model.Calendar;
import project.ipass.application.model.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("/user")
public class UserResource {

    @GET
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser(){
        return Calendar.getAllUsers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@FormParam("firstName")String fname,
                               @FormParam("lastName") String lname,
                               @FormParam("username") String username,
                               @FormParam("password") String pwd ){
        for (User user : User.getAllUsers()){
            if (user.getFirstName().equals(fname)){
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(new AbstractMap.SimpleEntry<String, String>("error", "User already exists"))
                        .build();
            }
        }
        return Response.ok(new User(fname,lname, username, pwd)).build();
    }
}
