/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessBeans;

import singletonBeans.CarCatalog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.EmployeeCarHire;
import singletonBeans.LogApp;
import singletonBeans.StatisticsApp;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateless
@LocalBean
public class EmployeeBean {

    EmployeeCarHire e0 = new EmployeeCarHire("Antonio José López Espino", "Comercial1", "Comercial");
    EmployeeCarHire e1 = new EmployeeCarHire("Yaiza Hernández Sánchez", "Comercial2", "Comercial");
    TraceGenerator traceG = new TraceGenerator();
    private List<EmployeeCarHire> employees;
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "EmployeeBean::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        employees = new ArrayList<>();
        employees.add(e0);
        employees.add(e1);
    }

    public List<EmployeeCarHire> getEmployeeList(String userName) {
        String trace = "EmployeeBean::getEmployeeList::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("EmployeeBean.java");
            int valueKeyEB = estadisticas.getValue(userName);
            valueKeyEB++;
            estadisticas.addUserValue(userName, valueKeyEB);
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
            traceG.traceDoc(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }

    @PreDestroy
    public void preDestroy() {
        String trace = "EmployeeBean::preDestroy::@PreDestroy";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
            employees.clear();
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
