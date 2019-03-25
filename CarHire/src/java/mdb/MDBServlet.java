/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import ejb.MessagesFacade;
import entities.Messages;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import singletonBeans.MessageBean;

/**
 *
 * @author alejandrohd
 */
@WebServlet(name = "MDBServlet", urlPatterns = {"/MDBServlet"})
public class MDBServlet extends HttpServlet {

    @Resource(mappedName = "jms/dest")
    private Queue dest;

    @Resource(mappedName = "jms/queue")
    private QueueConnectionFactory context;
    
    

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
            throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            //MessageBean mensaje = (MessageBean) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/MessageBean!singletonBeans.MessageBean");
            String msg = request.getParameter("mensajeText");
            Date myDate = new Date();
            MessagesFacade mensaje = InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/MessagesFacade!ejb.MessagesFacade");
            Messages sms = new Messages();
            if (msg != null) {
                Connection connection = context.createConnection();
                Session sessionConnect = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer producer = (MessageProducer) sessionConnect.createProducer(dest);
                TextMessage tm = sessionConnect.createTextMessage();
                tm.setText(msg + " [" + new SimpleDateFormat("hh:mm:ss dd-MM-yyyy ").format(myDate) + " " + request.getSession().getAttribute("usuario") + "]");
                producer.send(tm);
                //sms.setNameUser((String) request.getSession().getAttribute("usuario"));
                //sms.setTextMessage(msg);
                //sms.setDateMessage(new SimpleDateFormat("hh:mm:ss dd-MM-yyyy ").format(myDate));
                //mensaje.create(sms);
                mensaje.insertMessages((String) request.getSession().getAttribute("usuario"), msg,new SimpleDateFormat("hh:mm:ss dd-MM-yyyy ").format(myDate));
                /*boolean stateMessage = mensaje.messageState();
                while (stateMessage == false) {
                    stateMessage = mensaje.messageState();
                }
                mensaje.notSendMessage();*/

            }
            response.sendRedirect("Messages.jsp");
        } catch (JMSException ex) {
            Logger.getLogger(MDBServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(MDBServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
