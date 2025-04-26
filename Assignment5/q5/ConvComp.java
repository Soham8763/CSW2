package q5;

public class ConvComp {
    public static void main(String[] args) {
        String str1 = "lOrEM";
        String str2 = "lorem";
        String lower1 = str1.toLowerCase();
        System.out.println(lower1);
        String lower2 = str2.toLowerCase();
        System.out.println(lower2);

        String upper1 = str1.toUpperCase();
        System.out.println(upper1);
        String upper2 = str2.toUpperCase();
        System.out.println(upper2);

        System.out.println(lower1.equals(upper1));
        System.out.println(lower2.equals(upper2));
    }
}
