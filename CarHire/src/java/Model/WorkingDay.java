package Model;

/**
 *
 * @author alejandrohd
 */
public class WorkingDay {
    
    private String hour,employee;
    
    public WorkingDay(String hour,String employee){
        this.hour = hour;
        this.employee = employee;
    }

    
    public String getHour(){
        return this.hour;
    }
    
    public String getEmployee(){
        return this.employee;
    }
    
    
    public String getHourInXml(){
        return "<hora>"+getHour()+"</hora>";
    }
    
    public String getEmployeeInXml(){
        return "<lunes>"+getEmployee()+"</lunes>";
    }
    
    public String getWorkingDayXml(){
        return "<week><planning><hora>"+getHour()+"</hora><lunes>"+getEmployee()+"</lunes><martes>"+getEmployee()+
                "</martes><miercoles>"+getEmployee()+"</miercoles><jueves>"+getEmployee()+"</jueves><viernes>"+getEmployee()+
                "</viernes><sabado>"+getEmployee()+"</sabado><domingo>"+getEmployee()+"</domingo></planning></week>";
    }
    
}
