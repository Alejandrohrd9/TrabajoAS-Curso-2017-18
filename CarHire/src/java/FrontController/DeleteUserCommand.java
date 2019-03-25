/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontController;

import ejb.UsersFacade;
import entities.Users;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

/**
 *
 * @author alejandrohd
 */
public class DeleteUserCommand extends FrontCommand {

    @Override
    public void process() {
        UsersFacade users;
        try {
            users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
            List<Users> userDelete = users.findWithUser(request.getParameter("username"));

            if (userDelete.isEmpty()) {
                forward("/ViewEmployee.jsp");
            } else {
                users.deleteUser(request.getParameter("username"));
                forward("/ViewEmployee.jsp");
            }
        } catch (NamingException | ServletException | IOException ex) {
            Logger.getLogger(DeleteUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
