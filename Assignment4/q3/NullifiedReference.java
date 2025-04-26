package Assignment4.q3;

public class NullifiedReference {
    private String name;
    public NullifiedReference(String name){
        this.name = name;
        System.out.println(name+" successfully created");
    }
    public void finalise()throws Throwable{
        System.out.println(name+" successfully collected garbage");
    }
    public static void main(String[] args) {
        NullifiedReference ref1 = new NullifiedReference("ref1");
        ref1 = null;
        System.gc();
    }
}
