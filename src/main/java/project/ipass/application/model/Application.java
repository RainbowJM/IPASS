package project.ipass.application.model;


import project.ipass.App;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Application implements Serializable {
    private static Application theApplication = new Application();

    // getters
    public static Application getTheApplication(){
        return theApplication;
    }
    public List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(Appointment.getAllAppointments());
    }
    public List<User> getAllUsers(){
        return Collections.unmodifiableList(User.getAllUsers());
    }

    // setters
    public static void setTheApplication(Application application){
        theApplication = application;
    }
}
