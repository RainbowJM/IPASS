package project.ipass.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment{
    private static List<Appointment> allAppointments = new ArrayList<>();
    private static int appointmentId = 0;
    private LocalDate date;
    private int hour;
    private Service service;
    private Worker worker;
    private Client client;

    public Appointment(LocalDate date, int hour, String serviceName, String cName, String wName){
        appointmentId = appointmentId++;
        this.date = date;
        this.hour = hour;
        serviceName = getService().getServiceName();
        cName = getClient().getName();
        wName = getWorker().getName();

        if (!allAppointments.contains(this)){
            allAppointments.add(this);
        }
    }

    // calendarArray [2004][12][25][13][20] = appA
    public void addAppointment(LocalDate date, int hour, String serviceName, String cName, String wName){
        serviceName = getService().getServiceName();
        cName = getClient().getName();
        wName = getWorker().getName();
        for (Appointment appointment : allAppointments){
            if (date == appointment.getDate()){
                if (hour == appointment.getHour()){
                    break;
                }else{
                    allAppointments.add(new Appointment(date, hour, serviceName, cName, wName));
                }
            }
        }
    }

    // getters
    public static List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(allAppointments);
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
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
