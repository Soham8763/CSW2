package Assignment3.q5;

public class Nested {
    public static void main(String[] args) {
        String num = "4";
        try{
            int number = Integer.parseInt(num);
            try{
                if(number<0){
                    throw new ArithmeticException("Negative daala hai tune");
                }else{
                    System.out.println((int)Math.sqrt(number));
                }
            }catch(ArithmeticException e){
                e.printStackTrace();
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
}