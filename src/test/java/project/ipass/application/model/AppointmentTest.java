package project.ipass.application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppointmentTest {

    @BeforeEach
    public void init(){
        Worker w1 = new Worker("Jevona", "Magdalena", "jmag@hotmail.com", "test");
        Worker w2 = new Worker("Elisa", "Copra", "ecopra@hotmail.com", "123");

        Client c1 = new Client("Isobel", "Hook", "Iso@hotmail.com","test3");
        Client c2 = new Client("Tymon", "Bird", "ty@hotmail.com","test2");
        Client c3 = new Client("Makenzie", "Castro","castro@hotmail.com","test1");

        // service
        Service s1 = new Service(1,"Small Boxbraid",8);
        Service s2 = new Service(2,"Medium Boxbraid",6);
        Service s3 = new Service(3,"Large Boxbraid",4);
        Service s4 = new Service(4,"Small Twistbraid",7);
        Service s5 = new Service(5,"Medium Twistbraid",5);
        Service s6 = new Service(6,"Large Twistbraid",3);
        Service s7 = new Service(7,"Medium Twist",4);
        Service s8 = new Service(8,"Small Twist",3);
        Service s9 = new Service(9,"Medium Braids",3);
        Service s10 = new Service(10,"Small Braids",4);
        Service s11 = new Service(11,"Flat Twist",3);
//        Service s12 = new Service(12,"Vacation", 8);

        //appointment
        Date a = Appointment.parseDate("24/5/2020");
        Appointment app1 = new Appointment(a, 13,s1, w1);

        Date b = Appointment.parseDate("28/6/2020");
        Appointment app2 = new Appointment(b,10, s3, w1);
    }

    @Test
    void amountOfService(){
    }
}