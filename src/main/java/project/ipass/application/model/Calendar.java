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
    public static List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(Appointment.getAllAppointments());
    }
    public static List<User> getAllUsers(){
        return Collections.unmodifiableList(User.getAllUsers());
    }
    public static List<Worker> getAllWorkers(){
        return Collections.unmodifiableList(Worker.getWorkers());
    }
    public static List<Client> getAllClients(){ return Collections.unmodifiableList(Client.getClients());}
    public static List<Availability> getAllAvailibalities(){return  Collections.unmodifiableList(Availability.getAllAvailability());}
    public static List<Service> getAllServices(){return  Collections.unmodifiableList(Service.getAllServices());}
    // setters
    public static void setTheCalendar(Calendar calendar){
        theCalendar = calendar;
    }
}
