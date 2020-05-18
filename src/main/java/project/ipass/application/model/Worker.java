package project.ipass.application.model;

import java.util.ArrayList;
import java.util.List;

public final class Worker extends User {
    private List<Appointment> appointments = new ArrayList<>();
    private Availability availability;

    public Worker(int userId, String firstName, String lastName, String username, String password) {
        super(userId, firstName, lastName, username, password);
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
