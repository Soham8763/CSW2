package Assignment4.q1;

public class UnreachableObject {
    private String name;
    public UnreachableObject(String name){
        this.name = name;
    }
    public void show(){
        UnreachableObject obj1 = new UnreachableObject("Show method");
        obj1.display();
        obj1 = null;
    }
    public void display(){
        UnreachableObject obj2 = new UnreachableObject("Show method");
        obj2 = null;
    }
    public void finalise() throws Throwable{
        System.out.println(name+" is garbage collected");
    }
    public static void main(String[] args) {
        UnreachableObject obj = new UnreachableObject("object");
        obj.show();
        obj = null;
        System.gc();
    }
}
