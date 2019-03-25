package FrontController;

import ejb.CarDetailsFacade;
import entities.Car;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import singletonBeans.StatisticsApp;

public class EditCarCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("EditCarCommand.java");
            int valueKeyECommand = estadisticas.getValue((String) request.getSession().getAttribute("usuario"));
            valueKeyECommand++;
            estadisticas.addUserValue((String) request.getSession().getAttribute("usuario"), valueKeyECommand + 1);
            try {
                CarDetailsFacade carsDetail = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarDetailsFacade!ejb.CarDetailsFacade");
                Double d = Double.parseDouble(request.getParameter("price"));
                System.out.println(d);
                carsDetail.updateCar(request.getParameter("matricula"), Integer.parseInt(request.getParameter("doors")), BigDecimal.valueOf(d), Integer.parseInt(request.getParameter("idCarUp")));
                forward("/ViewCar.jsp");
            } catch (ServletException | IOException ex) {
                Logger.getLogger(EditCarCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(EditCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
