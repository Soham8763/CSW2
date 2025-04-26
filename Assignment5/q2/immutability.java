package q2;

public class immutability {
    public static void main(String[] args) {
        String str1 = "hello world";
        String str2 = str1.replace("world","everyone");
        System.out.println("str1: " + str1+"\n"+"str2: "+str2);

        CharSequence charseq = str1;
        System.out.println(charseq.length());
        System.out.println(charseq.charAt(8));
        System.out.println(charseq.subSequence(0, 8));
    }
}