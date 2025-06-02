package Assignment6;
class Node {
    static int value;
    static Node left;
    static Node right;
    public Node(int value){
        this.value = value;
        this.left = this.right = null;
    }
}
public class q2 {
    public static Node createTree(int[] arr,int low,int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;
        Node root = new Node(arr[mid]);
        root.left = createTree(arr, low, mid-1);
        root.right = createTree(arr, mid+1, high);
        return root;
    }
    public static void main(String[] args) {
        q2 tree = new q2();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        tree.createTree(arr, 0, arr.length-1);
    }
}
