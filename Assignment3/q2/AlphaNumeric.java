package Assignment3.q2;
public class AlphaNumeric {
    public static void main(String[] args) {
        String str = null;
        try{
            if(str == null){
                throw new CustomNullPointerException("null string hai chomu");
            }
        }catch(CustomNullPointerException e){
            e.printStackTrace();
        }
    }
}