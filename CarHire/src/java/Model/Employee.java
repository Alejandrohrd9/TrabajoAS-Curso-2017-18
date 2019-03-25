package Model;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alejandrohd
 */
public class Employee {
    private String name, userName, role;
    public Employee(String name, String userName, String role){
        this.name=name;
        this.userName = userName;
        this.role = role;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getUserName(){
        return this.userName;
    }
    
    public String getRole(){
        return this.role;
    }
    
    
    public String getNameInXml(){
        return "<name>"+name+"</name>";
    }
    
    public String getUserNameInXml(){
        return "<username>"+userName+"</username>";
    }
    
    public String getRoleInXml(){
        return "<role>"+role+"</role>";
    }
    
    public String getEmployeeInXml(){
        return "<employee>"+getNameInXml()+getUserNameInXml()+getRoleInXml()+"</employee>";
    }
}
