package project.ipass.application.webservices;

import project.ipass.application.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("/user")
public class UserResource {

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

    @DELETE
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") int id){
        return User.removeUser(id)
                ? Response.ok().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
