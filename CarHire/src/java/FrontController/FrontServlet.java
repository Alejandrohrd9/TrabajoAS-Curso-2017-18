package FrontController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import singletonBeans.LogApp;
import singletonBeans.StatisticsApp;

@WebServlet(name = "FrontServlet", urlPatterns = {"/FrontServlet"})
public class FrontServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException, IllegalAccessException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("FrontServlet.java");
            LogApp logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            FrontCommand command = getCommand(request);
            logApp.logGenerator("FrontServlet::" + request.getParameter("command")+"::");
            command.init(getServletContext(), request, response);
            command.process();
        }
    }

    private FrontCommand getCommand(HttpServletRequest request) {
        try {
            FrontCommand f = (FrontCommand) getCommandClass(request).newInstance();
            return f;
        } catch (Exception e) {
            return null;
        }

    }

    private Class getCommandClass(HttpServletRequest request) {
        Class result;
        final String command = "FrontController." + (String) request.getParameter("command");
        try {
            result = Class.forName(command);
        } catch (ClassNotFoundException e) {
            result = UnknownCommand.class;
        }
        return result;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
