package project.ipass.application.model;

public class Service {
    private int serviceId;
    private  String serviceName;
    private int duration;
    private String description;

    public Service(int serviceId, String serviceName, int duration, String description ){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.duration = duration;
        this.description = description;
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

    public String getDescription() {
        return description;
    }
}
