package project.ipass.application.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Client extends User {
    private static List<Client> allClient = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public Client(String firstName, String lastName, String username, String password) {
        super(firstName, lastName, username, password);

        if (allClient.contains(this)){
            allClient.add(this);
        }
    }

    // getters
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public static List<Client> getClients(){return Collections.unmodifiableList(allClient);
    }
}
