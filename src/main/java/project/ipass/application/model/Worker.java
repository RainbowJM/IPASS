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

    public static List<Worker> getWorkers(){
        return Collections.unmodifiableList(allWorker);
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Availability getAvailability() {
        return availability;
    }
}
