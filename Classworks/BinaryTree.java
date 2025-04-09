package Classworks;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    public BinaryTree() {
        root = null;
    }

    public void preorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    
    public void inorder(Node node) {
        if (node == null)
            return;
            
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    
    public void postorder(Node node) {
        if (node == null)
            return;
            
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
    
    public void preorderTraversal() {
        preorder(root);
        System.out.println();
    }
    
    public void inorderTraversal() {
        inorder(root);
        System.out.println();
    }
    
    public void postorderTraversal() {
        postorder(root);
        System.out.println();
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
            
        return root;
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int[] toArray() {
        int height = getHeight(root);
        int size = (int) Math.pow(2, height) - 1;
        int[] array = new int[size];
        toArrayHelper(root, array, 0);
        return array;
    }

    private void toArrayHelper(Node node, int[] array, int index) {
        if (node == null) {
            if (index < array.length) {
                array[index] = -1;
            }
            return;
        }

        array[index] = node.data;
        toArrayHelper(node.left, array, 2 * index + 1);
        toArrayHelper(node.right, array, 2 * index + 2);
    }

    public void printArrayRepresentation() {
        int[] array = toArray();
        System.out.print("Array representation: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static BinaryTree fromSortedArray(int[] sortedArray) {
        BinaryTree tree = new BinaryTree();
        tree.root = buildBSTFromSortedArray(sortedArray, 0, sortedArray.length - 1);
        return tree;
    }

    private static Node buildBSTFromSortedArray(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = buildBSTFromSortedArray(arr, start, mid - 1);
        node.right = buildBSTFromSortedArray(arr, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        System.out.println("Original tree traversals:");
        System.out.println("Preorder traversal:");
        tree.preorderTraversal();
        
        System.out.println("Inorder traversal:");
        tree.inorderTraversal();
        
        System.out.println("Postorder traversal:");
        tree.postorderTraversal();

        System.out.println("\nArray representation of the original tree:");
        tree.printArrayRepresentation();

       
        int[] sortedArray = {23,55,3,8,16,32,11,22,35,66,95};
        BinaryTree balancedTree = BinaryTree.fromSortedArray(sortedArray);
        
        System.out.println("\nBalanced BST created from sorted array:");
        System.out.println("Preorder traversal:");
        balancedTree.preorderTraversal();
        
        System.out.println("Inorder traversal:");
        balancedTree.inorderTraversal();
        
        System.out.println("Postorder traversal:");
        balancedTree.postorderTraversal();

        System.out.println("\nArray representation of the balanced tree:");
        balancedTree.printArrayRepresentation();
    }
}