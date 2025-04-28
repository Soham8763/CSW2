package Assignment2p2.q3;

import java.util.*;

public class CarApp {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(87654, "Mustang GT", 4));
        cars.add(new Car(87654, "Dodge Charger R/T", 1));
        cars.add(new Car(87654, "Lambo Urus", 7));
        cars.add(new Car(87654, "RB12", 2));
        cars.add(new Car(87654, "Aston Martin Vantage", 1));
        Collections.sort(cars,new Comparator<Car>(){
            public int compare(Car c1,Car c2){
                return Integer.compare(c1.getStock(), c2.getStock());
            }
        });
        for(Car car:cars){
            System.out.println(car);
        }
    }
}