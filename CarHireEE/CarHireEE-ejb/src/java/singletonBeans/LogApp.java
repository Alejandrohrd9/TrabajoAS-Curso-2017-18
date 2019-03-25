/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonBeans;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alejandrohd
 */
@Singleton
@LocalBean
public class LogApp {

    String logNew;
    String logOld;
    String logLine="";

    @Resource
    TimerService timerService;
    
    @PostConstruct
    public void create(){
        timerService.createSingleActionTimer(5000, new TimerConfig());
    }
    
    public void logGenerator(String logTrace){
        logLine+=logTrace+"\n";
    }
    
    public String getLog(){
        return logLine;
    }
    
    @Timeout
    public void timerWithoutInteraction(Timer timer){
        try {
            LogApp logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logNew = logApp.getLog();
            if(!logNew.equals(logOld)){
                logOld = logNew;
            }else{
                logApp.logGenerator("Ningún usuario ha interaccionado en estos últimos 5 segundos");
            }
        } catch (NamingException ex) {
            Logger.getLogger(LogApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer=timerService.createSingleActionTimer(5000, new TimerConfig());
    }
    
}
