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
import singletonBeans.CarCatalog;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateful
@LocalBean
public class Payment {

    private Map<String, String> paymentData;
    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "Payment::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            paymentData = new LinkedHashMap<>();
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addTypeCard(String creditCardType, String userName) {
        String trace = "Payment::addTypeCard::" + userName;

        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        paymentData.put("Tipo de tarjeta", creditCardType);
    }

    public void addNumber(String creditCardNumber, String userName) {
        String trace = "Payment::addNumber::" + userName;
        try {
            traceG.traceDoc(trace);
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            LogApp logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        paymentData.put("Número de la tarjeta", creditCardNumber);
    }

    public void addCardMonth(String creditCardMonth, String userName) {
        String trace = "Payment::addCardMonth::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            traceG.traceDoc(trace);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        paymentData.put("Expiración: Mes", creditCardMonth);
    }

    public void addCardYear(String creditCardYear, String userName) {
        String trace = "Payment::addCardYear::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            traceG.traceDoc(trace);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }

        paymentData.put("Expiración: Año", creditCardYear);
    }

    public void addTotalPrice(String totalPrice, String userName) {
        String trace = "Payment::addTotalPrice::" + userName;

        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        paymentData.put("Precio total €", totalPrice);
    }

    public void addReturnMoney(String returnMoney, String userName) {
        String trace = "Payment::addReturnMoney::" + userName;

        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        paymentData.put("Devolución €", returnMoney);
    }

    public String verDataCredit(String userName) {
        String trace = "Payment::verDataCredit::" + userName;
        String datas = "";
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            traceG.traceDoc(trace);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = paymentData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            datas += e.getKey() + " : " + e.getValue() + "\n";
        }
        return datas;
    }

    public String verPrecio(String userName) {
        String trace = "Payment::verPrecio::" + userName;
        String datas = "";
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("Payment.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            traceG.traceDoc(trace);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = paymentData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            if (e.getKey() == "Precio total €" || e.getKey() == "Devolución €") {
                datas += e.getKey() + " : " + e.getValue() + "\n";
            }
        }
        return datas;
    }

    @PrePassivate
    public void prePassive() {
        String trace = "Payment::prePassive::@PrePassive";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostActivate
    public void postActivate() {
        String trace = "Payment::postActivate::@PostActivate";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    public void removeCard() {
        String trace = "Payment::removeCard::@PreDestroy";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            paymentData.clear();
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
