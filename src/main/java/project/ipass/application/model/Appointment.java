package project.ipass.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment{
    private static List<Appointment> allAppointments = new ArrayList<>();
    private static int appointmentId = 0;
    private LocalDate date;
    private int period;
    private Service service;
    private Worker worker;
    private Client client;

    public Appointment(LocalDate date, int period,Service serviceName, Client cName, Worker wName){
        appointmentId = appointmentId++;
        this.date = date;
        this.period = period;

        if (!allAppointments.contains(this)){
            allAppointments.add(this);
        }
    }


    // getters
    public static List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(allAppointments);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPeriod() {
        return period;
    }

    public Client getClient() {
        return client;
    }

    public Service getService() {
        return service;
    }

    public Worker getWorker() {
        return worker;
    }

    // setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
