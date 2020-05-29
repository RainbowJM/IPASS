package project.ipass.application.model;

public class Service {
    private int serviceId;
    private  String serviceName;
    private int duration;

    public Service(int serviceId, String serviceName, int duration){
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.duration = duration;
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
