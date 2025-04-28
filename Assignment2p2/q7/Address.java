package Assignment2p2.q7;
import java.util.*;
public class Address {
    private String plotNo;
    private String at;
    private String post;
    public Address(String plotNo,String at,String post){
        this.plotNo = plotNo;
        this.at = at;
        this.post = post;
    }
    public String getPlotNo() {
        return plotNo;
    }
    public String getAt() {
        return at;
    }
    public String getPost() {
        return post;
    }
    public String toString() {
        return "Plot No: " + plotNo + ", At: " + at + ", Post: " + post;
    }
    public static void main(String[] args) {
        TreeMap<String,Address> treeMap = new TreeMap<>();
        treeMap.put("Rahul", new Address("123", "Main St", "CityA"));
        treeMap.put("Ankan", new Address("456", "High St", "CityB"));
        treeMap.put("Shibam", new Address("789", "Park Ave", "CityC"));
        treeMap.put("Debanjan", new Address("101", "Elm St", "CityD"));
        Iterator<Map.Entry<String,Address>> iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Address> entry = iterator.next();
            System.out.println("Name: "+entry.getKey()+" Address: "+entry.getValue());
        }
    }
}