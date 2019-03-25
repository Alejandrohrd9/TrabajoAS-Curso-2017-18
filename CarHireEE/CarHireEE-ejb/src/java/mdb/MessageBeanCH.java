/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import singletonBeans.LogApp;
import singletonBeans.MessageBean;
import singletonBeans.StatisticsApp;

/**
 *
 * @author alejandrohd
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/dest")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageBeanCH implements MessageListener {

    @EJB
    MessageBean mensaje;
    LogApp logContent;

    public MessageBeanCH() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            logContent = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            mensaje = (MessageBean) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/MessageBean!singletonBeans.MessageBean");
            logContent.logGenerator("MessageBeanCH::onMessage::");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("MessageBeanCH.java");
            TextMessage tmsg = (TextMessage) message;
            mensaje.addMessage(tmsg.getText());
            System.out.println("El mensaje es:" + tmsg.getText());
        } catch (NamingException | JMSException ex) {
            Logger.getLogger(MessageBeanCH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
