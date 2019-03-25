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
import model.DayWeek;
import singletonBeans.LogApp;
import singletonBeans.StatisticsApp;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateless
@LocalBean
public class PlanningWeek {

    String[] lunesArray = {"Antonio José", "Yaiza"};
    DayWeek lunes = new DayWeek("Lunes", lunesArray);
    String[] martesArray = {"Yaiza", "Antonio José"};
    DayWeek martes = new DayWeek("Martes", martesArray);
    String[] miercolesArray = {"Yaiza", "Antonio José"};
    DayWeek miercoles = new DayWeek("Miércoles", miercolesArray);
    String[] juevesArray = {"Yaiza", "Antonio José"};
    DayWeek jueves = new DayWeek("Jueves", juevesArray);
    String[] viernesArray = {"Yaiza", "Antonio José"};
    DayWeek viernes = new DayWeek("Viernes", viernesArray);
    String[] sabadoArray = {"Yaiza", "Antonio José"};
    DayWeek sabado = new DayWeek("Sábado", sabadoArray);
    String[] domingoArray = {"Yaiza", "Antonio José"};
    DayWeek domingo = new DayWeek("Domingo", domingoArray);

    private List<DayWeek> planningDays;
    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "PlanningWeek::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(PlanningWeek.class.getName()).log(Level.SEVERE, null, ex);
        }
        planningDays = new ArrayList<>();
        planningDays.add(lunes);
        planningDays.add(martes);
        planningDays.add(miercoles);
        planningDays.add(jueves);
        planningDays.add(viernes);
        planningDays.add(sabado);
        planningDays.add(domingo);
    }

    public List<DayWeek> getListDays(String userName) {
        String trace = "PlanningWeek::getListDays::" + userName;
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("PlanningWeek.java");
            int valueKeyP = estadisticas.getValue(userName);
            valueKeyP++;
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            estadisticas.addUserValue(userName, valueKeyP);
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException | NamingException ex) {
            logApp.logGenerator(trace + "IOException | NamingException");
            Logger.getLogger(PlanningWeek.class.getName()).log(Level.SEVERE, null, ex);
        }
        return planningDays;
    }

    @PreDestroy
    public void preDestroy() {
        String trace = "PlanningWeek::preDestroy::@PreDestroy";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
            planningDays.clear();
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(PlanningWeek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
