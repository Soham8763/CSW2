package Assignment4.q2;

public class ReassigningReference {
    private String name;
    public ReassigningReference(String name){
        this.name = name;
    }
    public void finalise(){
        System.out.println(name+" garbage successfully done");
    }
    public static void main(String[] args) {
        ReassigningReference ref1 = new ReassigningReference("Obj1");
        ReassigningReference ref2 = new ReassigningReference("Obj2");
        ref1 = ref2;
        System.gc();
    }
}
