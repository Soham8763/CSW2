package Assignment7.q4;

@FunctionalInterface
interface Shape {
    double area();
    
    default void printArea() {
        System.out.println("Area: " + area());
    }
}

public class q4 {
    public static void main(String[] args) {
        Shape circle = () -> {
            double radius = 5.0;
            return Math.PI * radius * radius;
        };
        
        Shape square = () -> {
            double side = 4.0;
            return side * side;
        };

        Shape rectangle = () -> {
            double length = 6.0;
            double width = 4.0;
            return length * width;
        };

        System.out.println("Circle:");
        circle.printArea();
        
        System.out.println("\nSquare:");
        square.printArea();
        
        System.out.println("\nRectangle:");
        rectangle.printArea();
    }
}