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
class Tree{
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
    public static void delete(int key){
        root = deleteRec(root,key);
    }
    public static Node deleteRec(Node root, int key){
        if(root == null){
            return null;
        }
        if(key<root.value){
            root.left = deleteRec(root.left, key);
        }else if(key>root.value){
            root.right = deleteRec(root.right, key);
        }else{
            //case 1: leaf nodes
            if(root.left == null & root.right == null){
                return null;
            }
            //case 2: one child
            else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            //case 3: two children
            else{
                Node successor = findSuccessor(root.right);
                root.value = successor.value;
                root.right = deleteRec(root.right, successor.value);
            }
        }
        return root;
    }
    public static Node findSuccessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        bst.delete(30);
    }
}