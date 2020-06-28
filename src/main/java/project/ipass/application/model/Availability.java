package project.ipass.application.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Availability {
    private static List<Availability> allAvailability = new ArrayList<>();
    private Date from;
    private Date till;
    private String description;

    public Availability(Date from, Date till){
        this.from = from;
        this.till = till;
    }

    public Availability(Date from, Date till, String description){
        this.from = from;
        this.till = till;
        this.description = description;
    }
    //getters
    public static List<Availability> getAllAvailability(){
        return Collections.unmodifiableList(allAvailability);
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