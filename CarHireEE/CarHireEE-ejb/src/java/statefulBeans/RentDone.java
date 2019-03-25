/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefulBeans;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import singletonBeans.LogApp;
import singletonBeans.StatisticsApp;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateful
@LocalBean
public class RentDone {

    private Map<String, String> rents;
    private Set<String> keyRents;
    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "RentDone::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (NamingException | IOException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentDone.class.getName()).log(Level.SEVERE, null, ex);
        }
        rents = new LinkedHashMap<>();
    }

    public void setRentCompleted(String rentDone, String DNI, String userName) {
        String trace = "RentDone::setRentCompleted::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentDone.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        rents.put(DNI, rentDone);
    }

    public String getRents(String userName) {
        String trace = "RentDone::getRents::" + userName;
        String datas = "";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentDone.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = rents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            datas += e.getKey() + "\n";
        }
        return datas;
    }

    public String getValue(String key, String userName) {
        String trace = "RentDone::GetValue::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rents.get(key);
    }

    @PrePassivate
    public void prePassivate() {
        String trace = "RentDone::prePassivate::@PrePassivate";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostActivate
    public void postActivate() {
        String trace = "RentDone::postActivate::@PostActivate";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRentValue(String key, String userName) {
        String trace = "RentDone::getRentValue::" + userName;
        String datas = "";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentDone.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = rents.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            if (e.getKey().equals(key)) {
                datas = e.getValue().toString();
            }
        }
        return datas;
    }

    public String[] getKeyArray(String userName) {
        String trace = "RentDone::getKeyArray::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        keyRents = rents.keySet();
        String[] keysArray = keyRents.toArray(new String[keyRents.size()]);
        return keysArray;
    }
}
