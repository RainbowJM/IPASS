package project.ipass.application.model;

import java.util.ArrayList;
import java.util.List;

public final class Client extends User {
    private List<Appointment> appointments = new ArrayList<>();

    public Client(int userId, String firstName, String lastName, String username, String password) {
        super(userId, firstName, lastName, username, password);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
