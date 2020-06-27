package project.ipass.application.setup;

import project.ipass.application.model.*;
import project.ipass.application.persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Date;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("initializing application");

        Worker w1 = new Worker("Jevona", "Magdalena", "jmag@hotmail.com", "test");
        w1.setAdmin();

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
        Service s12 = new Service(12,"Vacation", 8);

        //appointment
        Date a = new Date();
        new Appointment(a, 13,s1, w1);

        try {
            PersistenceManager.loadApplicationFromAzure();
            System.out.println("Calendar loaded!");
        } catch (IOException e) {
            System.out.println("Cannot load calendar!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("terminating application");

        try {
            PersistenceManager.saveApplicationToAzure();
            System.out.println("Calendar saved!");
        } catch (IOException e) {
            System.out.println("Failed to save the calendar");
            e.printStackTrace();
        }
    }
}
