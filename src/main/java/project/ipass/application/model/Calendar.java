package project.ipass.application.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Calendar implements Serializable {
    private static Calendar theCalendar = new Calendar();

    // getters
    public static Calendar getTheCalendar(){
        return theCalendar;
    }
    public List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(Appointment.getAllAppointments());
    }
    public List<User> getAllUsers(){
        return Collections.unmodifiableList(User.getAllUsers());
    }

    // setters
    public static void setTheCalendar(Calendar calendar){
        theCalendar = calendar;
    }
}
