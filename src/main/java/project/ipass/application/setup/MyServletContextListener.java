package project.ipass.application.setup;

import project.ipass.application.model.Service;
import project.ipass.application.security.MyUser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("initializing application");
        new MyUser("Isobel", "UJ633");
        new MyUser("Tymon","yZC1H");
        new MyUser("Makenzie","1bMCg");
        new MyUser("Jevona", "test1").setAdmin();

        // service
        new Service(1,"Small Boxbraid",8);
        new Service(2,"Medium Boxbraid",6);
        new Service(3,"Large Boxbraid",4);
        new Service(4,"Small Twistbraid",7);
        new Service(5,"Medium Twistbraid",5);
        new Service(6,"Large Twistbraid",3);
        new Service(7,"Medium Twist",4);
        new Service(8,"Small Twist",3);
        new Service(9,"Medium Braids",3);
        new Service(10,"Small Braida",4);
        new Service(11,"Flat Twist",3);
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("terminating application");
    }
}
