/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontController;

import ejb.CarDetailsFacade;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

/**
 *
 * @author alejandrohd
 */
public class DeleteCarCommand extends FrontCommand {

    @Override
    public void process() {
        try { 
            CarDetailsFacade carsDetail = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/CarDetailsFacade!ejb.CarDetailsFacade");
            carsDetail.deleteCar(Integer.parseInt(request.getParameter("idCar")));
            forward("/ViewCar.jsp?");
            
        } catch (NamingException | ServletException | IOException ex) {
            Logger.getLogger(DeleteCarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
