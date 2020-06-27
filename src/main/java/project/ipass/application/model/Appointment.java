package project.ipass.application.model;

import project.ipass.App;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Appointment{
    private static List<Appointment> allAppointments = new ArrayList<>();
    private int appointmentId;
    private static int lastAppointmentId = 0;
    private Date date;
    private int hour;
    private Service service;
    private Worker worker;
//    private Client client;

    public Appointment(Date date, int hour, Service service, Worker worker){
        appointmentId = lastAppointmentId++;
        this.date = date;
        this.hour = hour;
        this.service = service;
        this.worker = worker;

        if (!allAppointments.contains(this)){
            allAppointments.add(this);
        }
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

    public static boolean removeAppointment(int id){
        if (id>0){
            return allAppointments.remove(allAppointments.indexOf(Appointment.getAppointment(id))) != null;
        }
        return false;
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    // getters

    public static List<Appointment> getAllAppointments(){
        return Collections.unmodifiableList(allAppointments);
    }

    public static Appointment getAppointment(int id){
        return allAppointments.stream().filter(e -> e.appointmentId == id).findFirst().orElse(null);
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

//    public Client getClient() {
//        return client;
//    }

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

//    public void setClient(Client client) {
//        this.client = client;
//    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
