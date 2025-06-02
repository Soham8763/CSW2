package Assignment6;
class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
        this.left = this.right = null;
    }
    private Node root;
    public void insert(int value){
        root = insertRec(root,value);
    }
    public Node insertRec(Node root,int value){
        if(root == null){
            return null;
        }
        if(value<root.value){
            root.left = insertRec(root.left, value);
        }else if(value>root.value){
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    public void inOrder(){
        if(this.left!=null){
            this.left.inOrder();
        }
        System.out.print(this.value+" ");
        if(this.right!=null){
            this.right.inOrder();
        }
    }
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.left.postOrder();
        }
        System.out.print(this.value+" ");
    }
    public void preOrder(){
        System.out.print(this.value+" ");
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
public class q1 {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);
        root.insert(7);
        root.insert(12);
        root.insert(18);
        System.out.println("Pre-order traversal:");
        root.preOrder();
        System.out.println("\nIn-order traversal:");
        root.inOrder();
        System.out.println("\nPost-order traversal:");
        root.postOrder();
    }
}
