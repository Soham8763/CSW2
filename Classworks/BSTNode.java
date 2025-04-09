package Classworks;

public class BSTNode {
    // Member variables
    private int info;
    private BSTNode left;
    private BSTNode right;

    // Constructor
    public BSTNode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }

    // Getter and Setter methods
    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    // Method to insert a new node
    public void insert(int value) {
        if (value < this.info) {
            if (this.left == null) {
                this.left = new BSTNode(value);
            } else {
                this.left.insert(value);
            }
        } else if (value > this.info) {
            if (this.right == null) {
                this.right = new BSTNode(value);
            } else {
                this.right.insert(value);
            }
        }
        // If value is equal to info, we don't insert (assuming no duplicates)
    }

    // Pre-order traversal
    public void preOrderTraversal() {
        System.out.print(this.info + " ");
        if (this.left != null) {
            this.left.preOrderTraversal();
        }
        if (this.right != null) {
            this.right.preOrderTraversal();
        }
    }

    // In-order traversal
    public void inOrderTraversal() {
        if (this.left != null) {
            this.left.inOrderTraversal();
        }
        System.out.print(this.info + " ");
        if (this.right != null) {
            this.right.inOrderTraversal();
        }
    }

    // Post-order traversal
    public void postOrderTraversal() {
        if (this.left != null) {
            this.left.postOrderTraversal();
        }
        if (this.right != null) {
            this.right.postOrderTraversal();
        }
        System.out.print(this.info + " ");
    }

    public static BSTNode CreateTree(int[] arr) {
        return CreateTreeHelper(arr, 0, arr.length - 1);
    }

    private static BSTNode CreateTreeHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(arr[mid]);
        node.left = CreateTreeHelper(arr, start, mid - 1);
        node.right = CreateTreeHelper(arr, mid + 1, end);
        return node;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        BSTNode root = CreateTree(sortedArray);
        
        System.out.println("Pre-order traversal:");
        root.preOrderTraversal();
        System.out.println("\n");
        
        System.out.println("In-order traversal:");
        root.inOrderTraversal();
        System.out.println("\n");
        
        System.out.println("Post-order traversal:");
        root.postOrderTraversal();
        System.out.println("\n");
    }
} 