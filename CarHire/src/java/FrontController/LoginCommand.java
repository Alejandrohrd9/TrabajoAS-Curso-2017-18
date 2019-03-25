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
import javax.servlet.http.HttpSession;
import singletonBeans.StatisticsApp;

/**
 *
 * @author alejandrohd
 */
public class LoginCommand extends FrontCommand {

    @Override
    public void process() {
        try {
            HttpSession session = request.getSession();
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            UsersFacade users = (UsersFacade) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/UsersFacade!ejb.UsersFacade");
            String username = request.getParameter("username");
            String password = request.getParameter("pass");
            if (username != null && password != null) {
                if (!users.findWithUserPassword(username, password).isEmpty()) {
                    estadisticas.addUserAcces("Usuarios");
                    session.setAttribute("usuario", username);
                    session.setAttribute("password", password);
                    estadisticas.addUserKey((String) session.getAttribute("usuario"));
                    estadisticas.addAccess("LoginCommand.java");
                    int valueKeyLogin = estadisticas.getValue((String) request.getSession().getAttribute("usuario"));
                    valueKeyLogin++;
                    estadisticas.addUserValue((String) request.getSession().getAttribute("usuario"), valueKeyLogin + 1);
                    try{
                        if(users.getTypeUser(username, password).equals("Gerente")){
                            forward("/PrincipalManagerScreen.jsp");
                        }else{
                            forward("/PrincipalComercialScreen.jsp");
                        }
                    }catch (ServletException | IOException ex) {
                        Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    try {
                        forward("/PrincipalApp.jsp");
                    } catch (ServletException | IOException ex) {
                        Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                try {
                    forward("/PrincipalApp.jsp");
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /*try {
                if (session.getAttribute("usuario").equals("Comercial1")) {
                    forward("/PrincipalComercialScreen.jsp");
                } else {
                    forward("/PrincipalManagerScreen.jsp");
                }
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch (NamingException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
