/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontController;

import ejb.UsersFacade;
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
public class EditUserCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
            users.updateUser(request.getParameter("nameUser"), request.getParameter("surnameUser"), request.getParameter("usernameUser"), request.getParameter("passwordUser"), request.getParameter("userTypeForm"), Integer.parseInt(request.getParameter("id")));
            request.getRequestDispatcher("/ViewEmployee.jsp").forward(request, response);
        } catch (NamingException | ServletException | IOException ex) {
            Logger.getLogger(EditUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
