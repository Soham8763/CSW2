package Assignment2p1.q6;

public class Animal {
    private String name;
    private String color;
    private String type;
    public Animal(String name, String color, String type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getType() {
        return type;
    }
    public String toString() {
        return "Name: " + name + ", Color: " + color + ", Type: " + type;
    }
    public int hashCode(){
        int result = name.hashCode();
        result = color.hashCode();
        result = type.hashCode();
        return result;
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!=obj.getClass()){
            return false;
        }
        Animal animal = (Animal) obj;
        return name.equals(animal.name) && color.equals(animal.color) && type.equals(animal.type);
    }
    public static void main(String[] args) {
        Animal animal1 = new Animal("Lion","Golden", "wild");
        Animal animal2 = new Animal("Dog", "Brown", "pet");
        Animal animal3 = new Animal("Cat", "Black", "pet");
        System.out.println("Hash Code for Lion: " + animal1.hashCode());
        System.out.println("Hash Code for Dog: " + animal2.hashCode());
        System.out.println("Hash Code for Cat: " + animal3.hashCode());
    }
}