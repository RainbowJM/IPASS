//package project.ipass.application.persistence;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//import java.io.IOException;
//
//@WebListener
//public class MyContextListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        try {
//            PersistenceManager.loadApplicationFromAzure();
//            System.out.println("World loaded!");
//        } catch (IOException e) {
//            System.out.println("Cannot load world!");
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println();
//        }
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//        try {
//            PersistenceManager.saveApplicationToAzure();
//            System.out.println("World saved!");
//        } catch (IOException e) {
//            System.out.println("Failed to save the world");
//            e.printStackTrace();
//        }
//    }
//}
