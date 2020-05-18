package project.ipass.application.model;

import java.util.Date;

public class Availability {
    private Date from;
    private Date till;
    private String description;

    public Availability(int userId, Date from, Date till){
        this.from = from;
        this.till = till;
    }

    public Availability(int userId, Date from, Date till, String description){
        this.from = from;
        this.till = till;
        this.description = description;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTill() {
        return till;
    }

    public String getDescription() {
        return description;
    }
}