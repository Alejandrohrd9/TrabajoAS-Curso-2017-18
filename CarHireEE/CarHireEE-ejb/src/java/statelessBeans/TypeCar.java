/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessBeans;

import singletonBeans.DataCar;
import singletonBeans.CarCatalog;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import singletonBeans.LogApp;
import singletonBeans.StatisticsApp;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateless
@LocalBean
public class TypeCar {

    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;
    
    @PostConstruct
    public void create() {
        String trace = "TypeCar::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace+"IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace+"NamingException");
            Logger.getLogger(TypeCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String typeCar(String modelo, String puertas, String userName) {
        String trace = "TypeCar::typeCar::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addAccess("TypeCar.java");
            int valueKeyTP = estadisticas.getValue(userName);
            valueKeyTP++;
            estadisticas.addUserValue(userName, valueKeyTP);
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace+"IOException");
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace+"NamingException");
            Logger.getLogger(TypeCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (puertas.equals("3 puertas")) {
            if (modelo.equals("Corsa")) {
                return "Económico";
            }
            return "Compacto";
        }

        if (puertas.equals("5 puertas")) {
            if (modelo.equals("Renegade")) {
                return "Todo terreno";
            }
            if (modelo.equals("Corsa") || modelo.equals("Golf")) {
                return "Compacto";
            }
        }
        return "Monovolumen";
    }

    @PreDestroy
    public void preDestroy() {
        String trace = "TypeCar::preDestroy::@PreDestroy";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace+"IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace+"NamingException");
            Logger.getLogger(TypeCar.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
