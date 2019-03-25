package Model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    
    private List <Employee> employees;
    
    public Employees(){
        employees = new ArrayList<>();
    }
    
    public void add(Employee e){
        employees.add(e);
    }
    
    public List getEmployees(){
        return employees;
    }
    
    public String getEmployeesInXML(){
        String xmlString ="<employees>";
        for (Employee employee : employees) {
            xmlString+=employee.getEmployeeInXml();
        }
        return xmlString+"</employees>";
    }
}
