/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statefulBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
public class Receipt {

    private List<String> receipt;
    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "Receipt::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
            receipt = new ArrayList<String>();
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addDataRent(String dataRent, String userName) {
        String trace = "Receipt::addDataRent::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Receipt.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        receipt.add(dataRent);
    }

    public void addDataCard(String dataCard, String userName) {
        String trace = "Receipt::addDataCard::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Receipt.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        receipt.add(dataCard);
    }

    public void addPrice(String price, String userName) {
        String trace = "Receipt::addPrice::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Receipt.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        receipt.add(price);
    }

    @PrePassivate
    public void prePassivate() {
        String trace = "Receipt::prePassivate::@PrePassivate";
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
        String trace = "Receipt::postActivate::@PostActivate";
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

    public String[] listReceiptToArray(String userName) {
        String trace = "Receipt::listReceiptToArray::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Receipt.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addUserValue(userName, valueKeyP);
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] strArray = (String[]) receipt.toArray(new String[0]);
        return strArray;
    }

    @PreDestroy
    public void preDestroy() {
        String trace = "Receipt::preDestroy::@PreDestroy";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
            receipt.clear();
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
