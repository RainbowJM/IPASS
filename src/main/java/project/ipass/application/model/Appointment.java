package project.ipass.application.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Appointment{
    private static  List<Appointment> allAppointments = new ArrayList<>();
    private  static int appointmentId = 0;
    private LocalDate date;
    private int period;
    private Service service;
    private Worker worker;
    private Client client;

    public Appointment(LocalDate date, int period{
        appointmentId = appointmentId++;
        this.date = date;
        this.period = period;

//        String convertedDateToString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));

    }

//    public void addAppointment(LocalDate date, String serviceName, Client firstName, Worker wFirstName, int period){
//        String convertedDateToString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
//        String appointment = firstName + convertedDateToString + serviceName + wFirstName + period;
//
//        allAppointments.add(appointment);
//    }

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
