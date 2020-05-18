package project.ipass.application.model;

import java.util.Date;

public class Appointment {
    private int appointmentId;
    private Date date;
    private int period;
    private Service service;
    private Worker worker;
    private Client client;

    public Appointment(int appointmentId, Date date, int period){
        this.appointmentId = appointmentId;
        this.date = date;
        this.period = period;
    }

    public Date getDate() {
        return date;
    }

    public int getAppointmentId() {
        return appointmentId;
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
