package project.ipass.application.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Worker extends User {
    private List<Appointment> appointments = new ArrayList<>();
    private static List<Worker> allWorker = new ArrayList<>();
    private Availability availability;

    public Worker(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);

        if (!allWorker.contains(this)){
            allWorker.add(this);
        }
    }
    //getters
    public static  Worker getWorker(int id){
        return allWorker.stream().filter(e -> e.getUserId() == id).findFirst().orElse(null);
    }
    public static List<Worker> getWorkers(){
        return Collections.unmodifiableList(allWorker);
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public Availability getAvailability() {
        return availability;
    }

    // setters
    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

}
