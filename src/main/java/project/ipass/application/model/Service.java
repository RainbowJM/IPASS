package project.ipass.application.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private static List<Service> allServices = new ArrayList<>();
    private int serviceId;
    private  String serviceName;
    private int duration;

    public Service(int serviceId, String serviceName, int duration){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.duration = duration;

        if (!allServices.contains(this)){
            allServices.add(this);
        }
    }

    public Service(int serviceId, String serviceName){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }
    // getters
    public static List<Service> getAllServices(){
        return Collections.unmodifiableList(Service.getAllServices());
    }
    public String getServiceName(){
        return serviceName;
    }

    public int getDuration() {
        return duration;
    }

    public int getServiceId() {
        return serviceId;
    }

}
