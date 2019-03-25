/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statelessBeans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import singletonBeans.CarCatalog;
import singletonBeans.LogApp;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Stateless
@LocalBean
public class PaymentController {

    TraceGenerator traceG = new TraceGenerator();
    LogApp logApp;

    @PostConstruct
    public void create() {
        String trace = "PaymentController::create::@PostConstruct";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(TypeCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int returnMoney(String total, String deliver) {
        int totalMoney = Integer.parseInt(total);
        int deliverMoney = Integer.parseInt(deliver);
        if (deliverMoney >= totalMoney) {
            return deliverMoney - totalMoney;
        }

        return -1;
    }

    @PreDestroy
    public void preDestroy() {
        String trace = "PaymentController::preDestroy::@PreDestroy";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            traceG.traceDoc(trace);
            logApp.logGenerator(trace);
        } catch (IOException ex) {
            logApp.logGenerator(trace + "IOException");
            Logger.getLogger(CarCatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            logApp.logGenerator(trace + "NamingException");
            Logger.getLogger(TypeCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
