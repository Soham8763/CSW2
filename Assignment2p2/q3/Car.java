package Assignment2p2.q3;

public class Car {
    private int modelNo;
    private String name;
    private int stock;
    public Car(int modelNo,String name,int stock){
        this.modelNo = modelNo;
        this.name = name;
        this.stock = stock;
    }
    public int getModelNo() {
        return modelNo;
    }
    public String getName() {
        return name;
    }
    public int getStock() {
        return stock;
    }
    public int compareTo(Car car){
        return Integer.compare(stock, car.stock);
    }
    public String toString(){
        return "Model no: "+modelNo+" Name: "+name+" Stock: "+stock;
    }
}