package Assignment7.q4;
@FunctionalInterface
interface Shape{
    double area();
}
public class q4 {
    public static void main(String[] args) {
        Shape circle =()->{
            double radius = 5;
            return Math.PI*radius*radius;
        };
        System.out.println("Area of Circle: " + circle.area());
        Shape square=()->{
            double side = 4;
            return side*side;
        };
        System.out.println("Area of the square: "+square.area());
        Shape rectangle = () ->{
            double length = 5;
            double width = 3;
            return length*width;
        };
        System.out.println("Area of the rectangle: "+rectangle.area());
    }
}
