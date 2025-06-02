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
public class q3 {
    private static Node root;
    public static void insert(int key){
        root = insertRec(root,key);
    }
    public static Node insertRec(Node root,int key){
        if(root == null){
            return new Node(key);
        }
        if(key<root.value){
            root.left = insertRec(root.left, key);
        }else{
            root.right = insertRec(root.right, key);
        }
        return root;
    }
    private static boolean isBst(Node root){
        return isBstHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean isBstHelper(Node root,long min,long max){
        if(root == null){
            return true;
        }
        if(root.value<=min || root.value>=max){
            return false;
        }
        return isBstHelper(root.left, min, root.value) && isBstHelper(root.right, root.value, max);
    }
    public static void main(String[] args) {
        q3 bst = new q3();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
    }
}
