package project.ipass.application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Appointment{
    private List<Service> allServices= new ArrayList<>();
    private List<Worker> allWorkers = new ArrayList<>();
    private List<Client> allClient = new ArrayList<>();
    private int appointmentId;
    private LocalDate date;
    private int period;
    private Service service;
    private Worker worker;
    private Client client;

    public Appointment(int appointmentId, LocalDate date, int period){
        this.appointmentId = appointmentId;
        this.date = date;
        this.period = period;
    }

    public LocalDate getDate() {
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

    public void addAppointment(LocalDate date, String serviceName,int serviceId, String firstName){

    }
}
