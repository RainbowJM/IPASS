package project.ipass.application.model;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Application implements Serializable {
    private static Application theApplication = new Application();

    public static Application getTheApplication(){
        return theApplication;
    }
    public List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(Appointment.getAllAppointments());
    }
}
