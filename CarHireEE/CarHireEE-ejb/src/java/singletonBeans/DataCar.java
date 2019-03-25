/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletonBeans;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import trace.TraceGenerator;

/**
 *
 * @author alejandrohd
 */
@Singleton
@LocalBean
public class DataCar {

    private String marca, modelo, matricula, puertas;
    LogApp logApp;

    TraceGenerator traceG = new TraceGenerator();

    public void setMarca(String marca) {
        String trace = "DataCar::setMarca::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        String trace = "Data::setModelo::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        String trace = "DataCar::setMatricula::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.matricula = matricula;
    }

    public void setPuertas(String puertas) {
        String trace = "DataCar::setPuertas::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.puertas = puertas;
    }

    public String getMarca() {
        String trace = "DataCar::getMarca::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return marca;
    }

    public String getModelo() {
        String trace = "DataCar::getModelo::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }

    public String getMatricula() {
        String trace = "DataCar::getMatricula::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matricula;
    }

    public String getPuertas() {
        String trace = "DataCar::getPuertas::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puertas;
    }

    public String[] catalogArray(List<String> dataCar) {
        String trace = "DataCar::catalogArray::";
        try {
            logApp = (LogApp) InitialContext.doLookup("java:global/CarHireEE/CarHireEE-ejb/LogApp!singletonBeans.LogApp");
            logApp.logGenerator(trace);
        } catch (NamingException ex) {
            Logger.getLogger(DataCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] strArray = (String[]) dataCar.toArray(new String[0]);
        return strArray;
    }
}
