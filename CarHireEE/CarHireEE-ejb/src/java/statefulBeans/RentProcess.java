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
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateful
@LocalBean
public class RentProcess {

    private Map<String, String> userData;
    private String responsible;
    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "RentProcess::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            userData = new LinkedHashMap<>();
            userData.put("Comercial responsable", "Comercial1");
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setResponsible(String responsible, String userName) {
        String trace = "RentProcess::setResponsible::" + userName;
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.responsible = responsible;
    }

    public String getResponsible(String userName) {
        String trace = "RentProcess::getResponsible::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responsible;
    }

    public void addResponsible(String responsible, String userName) {
        String trace = "RentProcess::addResponsible::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Comercial", responsible);
    }

    public void addClientName(String name, String userName) {
        String trace = "RentProcess::addClientName::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Nombre del arrendatario", name);
    }

    public void addClientAddress(String address, String userName) {
        String trace = "RentProcess::addClientAddress::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Dirección", address);
    }

    public void addNationality(String nationality, String userName) {
        String trace = "RentProcess::addNationality::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Nacionalidad", nationality);
    }

    public void addPassportNumber(String pasNum, String userName) {
        String trace = "RentProcess::addPassportNumber::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("DNI", pasNum);
    }

    public void addBirth(String birth, String userName) {
        String trace = "RentProcess::addBirth::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Nacimiento", birth);
    }

    public void addLicenseNum(String num, String userName) {
        String trace = "RentProcess::addLicenseNum::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Permiso conducir", num);
    }

    public void addCar(String carModel, String userName) {
        String trace = "RentProcess::addCar::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Vehículo", carModel);
    }

    public void addPayForm(String payForm, String userName) {
        String trace = "RentProcess::addPayForm::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Pago", payForm);
    }

    public void addDays(String days, String userName) {
        String trace = "RentProcess::addDays::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        userData.put("Días", days);
    }

    public String verData(String userName) {
        String datas = "";
        String trace = "RentProcess::verData::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("RentProcess.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            estadisticas.addUserValue(userName, valueKeyP);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = userData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            datas += e.getKey() + " : " + e.getValue() + "\n";
        }
        return datas;
    }

    @PrePassivate
    public void prePassivate() {
        String trace = "RentProcess::prePassivate::@PrePassivate";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PostActivate
    public void postActivate() {
        String trace = "RentProcess::postActivate::@PostActivate";
        try {
            LogApp logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PreDestroy
    public void removeData() {
        String trace = "RentProcess::removeData::@PreDestroy";
        try {
            LogApp logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            userData.clear();
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(RentProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
