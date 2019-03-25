/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonBeans;

import java.io.IOException;
import trace.TraceGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alejandrohd
 */
@Singleton
@LocalBean
public class CarCatalog {

    private List<String> cars;
    String[] carsArray = {"Opel Corsa 34", "Volkswagen Golf 38", "Peugeot 308 42", "Jeep Renegade 76",
        "Fiat 500 45"};
    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "CarCatalog::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            cars = new ArrayList<>();
            for (String car : carsArray) {
                cars.add(car);
            }
        } catch (NamingException ex) {
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addCar(String car, String userName) {
        String trace = "CarCatalog::addCar::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            cars.add(car);
        } catch (NamingException ex) {
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String> getCars(String userName) {
        String trace = "CarCatalog::getCars::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cars;
    }

    public String[] catalogArray(String userName) {
        String trace = "CarCatalog::catalogArray::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] strArray = (String[]) cars.toArray(new String[0]);
        return strArray;
    }

    @Remove
    public void remove() {
        String trace = "CarCatalog::remove::@Remove";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            cars.clear();
        } catch (NamingException ex) {
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
