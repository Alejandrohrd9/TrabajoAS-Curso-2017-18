package Model;

/**
 *
 * @author alejandrohd
 */
public class WorkStation {
    
    private String name,workStation;
    
    public WorkStation(String name, String workStation){
        this.name= name;
        this.workStation = workStation;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getStation(){
        return this.workStation;
    }
    
    public String getNameToXSLTSV(){
        return "<cell>"+name+"</cell>";
    }
    
    public String getStationToXSLTSV(){
        return "<cell>"+workStation+"</cell>";
    }
    
    public String getWorkStationXML(){
        return "<screen><table><row>"+getNameToXSLTSV()+getStationToXSLTSV()+"</row></table></screen>";
    }
}
