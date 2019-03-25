/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import singletonBeans.StatisticsApp;

/**
 *
 * @author alejandrohd
 */
public class ViewEmployeeCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("ViewEmployeeCommand.java");
            int valueKeyVEmployee = estadisticas.getValue((String) request.getSession().getAttribute("usuario"));
            valueKeyVEmployee++;
            estadisticas.addUserValue((String) request.getSession().getAttribute("usuario"), valueKeyVEmployee + 1);
            try {
                forward("/ViewEmployee.jsp");

            } catch (ServletException | IOException ex) {
                Logger.getLogger(ViewEmployeeCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(ViewEmployeeCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
