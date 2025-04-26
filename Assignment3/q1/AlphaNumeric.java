package Assignment3.q1;

public class AlphaNumeric {
    public static void main(String[] args) {
        String str = null;
        try{
            for (int i = 0; i < str.length(); i++) {
                if((int)str.charAt(i)>=48 && (int)str.charAt(i)<=57){
                    System.out.println(str.charAt(i));
                }
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}