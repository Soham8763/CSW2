package Assignment4.q4;

public class AnonymousObject {
    private String name;
    public AnonymousObject(String name){
        this.name = name;
    }
    public void finalise()throws Throwable{
        System.out.println(name+"garbage collected");
    }
    public static void main(String[] args) {
        new AnonymousObject("Obj");
        System.gc();
    }
}