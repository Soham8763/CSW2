package Assignment2p1.q3;
public class Car implements Comparable<Car>{
    String model;
    String color;
    double speed;
    public Car(String model, String color, double speed) {
        this.model = model;
        this.color = color;
        this.speed = speed;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public String toString() {
        return "Car Model: " + model + ", Color: " + color + ", Speed: " + speed+ " km/h";
    }
    public int compareTo(Car o) {
        return Double.compare(this.speed, o.speed);
    }
    public static void main(String[] args) {
        Car car1 = new Car("Fortuner", "White", 220.5);
        Car car2 = new Car("Scorpio", "Black", 210.3);
        Car fasterCar = (car1.compareTo(car2)>0)?car1:car2;
        System.out.println(fasterCar.toString());
    }
}