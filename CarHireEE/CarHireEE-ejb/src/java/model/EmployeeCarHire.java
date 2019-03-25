/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alejandrohd
 */
public class EmployeeCarHire {
    private String name,userName,role;
    
    public EmployeeCarHire(String name, String userName,String role){
        this.name=name;
        this.userName=userName;
        this.role=role;
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
}
