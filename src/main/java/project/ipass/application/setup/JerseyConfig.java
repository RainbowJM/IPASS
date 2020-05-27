package project.ipass.application.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){
        packages("project.ipass.application.webservices", "project.ipass.application.security");
        register(RolesAllowedDynamicFeature.class);
    }
}
