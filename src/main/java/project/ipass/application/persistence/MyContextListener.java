package project.ipass.application.persistence;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
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
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            PersistenceManager.saveApplicationToAzure();
            System.out.println("Calendar saved!");
        } catch (IOException e) {
            System.out.println("Failed to save the calendar");
            e.printStackTrace();
        }
    }
}
