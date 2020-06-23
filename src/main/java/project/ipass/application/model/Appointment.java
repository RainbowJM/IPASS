package project.ipass.application.model;

import java.util.*;

public class Appointment{
    private static List<Appointment> allAppointments = new ArrayList<>();
    private int appointmentId;
    private static int lastAppointmentId = 0;
    private Date date;
    private int hour;
    private Service service;
    private Worker worker;
    private Client client;

    public Appointment(Date date, int hour, Service service, Client client, Worker worker){
        appointmentId = lastAppointmentId++;
        this.date = date;
        this.hour = hour;
        this.service = service;
        this.client = client;
        this.worker = worker;

        if (!allAppointments.contains(this)){
            allAppointments.add(this);
        }
        allAppointments.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return hour == that.hour &&
                date.equals(that.date) &&
                Objects.equals(worker, that.worker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, hour, worker);
    }

    public static  boolean removeAppointment(int id){
        for (Appointment appoint : allAppointments){
            if (appoint.getAppointmentId() == id){
                return allAppointments.remove(appoint);
            }
        }
        return false;
    }


    // getters
    public static List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(allAppointments);
    }

    public Date getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getAppointmentId() {
        return appointmentId;
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
    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
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
