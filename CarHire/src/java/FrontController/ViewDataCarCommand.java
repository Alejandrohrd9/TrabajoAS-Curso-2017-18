package FrontController;

import FrontController.FrontCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import singletonBeans.StatisticsApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alejandrohd
 */
public class ViewDataCarCommand extends FrontCommand {

    @Override
    public void process() {

        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("ViewDataCarCommand.java");
            int valueKeyDCar = estadisticas.getValue((String) request.getSession().getAttribute("usuario"));
            valueKeyDCar++;
            estadisticas.addUserValue((String) request.getSession().getAttribute("usuario"), valueKeyDCar + 1);
            try {
                forward("/ViewDataCar.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(ViewDataCarCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(ViewDataCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
