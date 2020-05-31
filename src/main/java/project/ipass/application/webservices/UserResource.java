package project.ipass.application.webservices;

import project.ipass.application.model.Application;
import project.ipass.application.model.User;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserResource {

    @GET
    @PermitAll
    @Path("{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userid") int id){
        User user = Application.getTheApplication().getUserId();
    }
}
