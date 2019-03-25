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
public class DayWeek {
    
    private String day;
    private String employeesArray[];
    
    public DayWeek(String day, String [] employeeArray){
        this.day=day;
        this.employeesArray=employeeArray;
    }
    
    public String getDay(){
        return this.day;
    }
    
    public String [] getEmployeeArray(){
        return this.employeesArray;
    }
}
