/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonBeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alejandrohd
 */
@Singleton
@LocalBean
public class MessageBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    LogApp logContent;
    private String messagesList = "";

    @PostConstruct
    public void create() {
        try {
            logContent = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logContent.logGenerator("MessageBean::create::@PostConstruct");
            StatisticsApp estadisticas = (StatisticsApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/StatisticsApp!singletonBeans.StatisticsApp");
            estadisticas.addAccess("MessageBean.java");
        } catch (NamingException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addMessage(String message) {
        try {
            logContent = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logContent.logGenerator("MessageBean::addMessage::");
            messagesList += message + "<br>";
        } catch (NamingException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getMessages() {
        try {
            logContent = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logContent.logGenerator("MessageBean::addMessage::");

        } catch (NamingException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messagesList;
    }
}
