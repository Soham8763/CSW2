package q7;

import java.util.Scanner;
public class replace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String:");
        String str = sc.nextLine();
        String modStr = "";
        System.out.println("Enter the character to search for");
        char sChar = sc.next().charAt(0);
        System.out.println("Enter the character to replace it");
        char rChar = sc.next().charAt(0);
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == sChar && i>0){
                modStr+=str.substring(0, i)+rChar+str.substring(i+1);
                break;
            }
        }
        System.out.println(str);
        System.out.println(modStr);
        sc.close();
    }
}
