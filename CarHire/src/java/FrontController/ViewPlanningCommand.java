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
public class ViewPlanningCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("ViewPlanningCommand.java");
            int valueKeyPlanning = estadisticas.getValue((String) request.getSession().getAttribute("usuario"));
            valueKeyPlanning++;
            estadisticas.addUserValue((String) request.getSession().getAttribute("usuario"), valueKeyPlanning + 1);
            try {
                forward("/ViewPlanning.jsp");
            } catch (IOException | ServletException ex) {
                Logger.getLogger(ViewPlanningCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(ViewPlanningCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
