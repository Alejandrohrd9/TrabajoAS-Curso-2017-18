package FrontController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import singletonBeans.StatisticsApp;

public class NewCarCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("NewCarCommand.java");
            int valueKeyNCar = estadisticas.getValue((String) request.getSession().getAttribute("usuario"));
            valueKeyNCar++;
            estadisticas.addUserValue((String) request.getSession().getAttribute("usuario"), valueKeyNCar + 1);
            try {
                forward("/ViewCar.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(NewCarCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(NewCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
