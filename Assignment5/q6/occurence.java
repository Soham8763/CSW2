package q6;

public class occurence {
    public static void main(String[] args) {
        String str = "soham ghosh";
        char[] charArr = str.toCharArray();
        int[] occurence = {-1,-1};
        char key = 'o';
        int low = 0,high = charArr.length-1;
        while(low <= high){
            if(charArr[low] == key){
                occurence[0] = low;
            }else if(charArr[high] == key){
                occurence[1] = high;
            }
            low++;
            high--;
        }
        for(char ch:charArr){
            System.out.print(ch+", ");
        }
        System.out.println();
        System.out.println("First and last occurence at: ["+occurence[0]+","+occurence[1]+"]");
    }
}