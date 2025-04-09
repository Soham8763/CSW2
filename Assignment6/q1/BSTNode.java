package Assignment6.q1;


public class BSTNode {
    private int info;
    private BSTNode left;
    private BSTNode right;
    public BSTNode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
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
    }

    public void preOrderTraversal() {
        System.out.print(this.info + " ");
        if (this.left != null) {
            this.left.preOrderTraversal();
        }
        if (this.right != null) {
            this.right.preOrderTraversal();
        }
    }

    public void inOrderTraversal() {
        if (this.left != null) {
            this.left.inOrderTraversal();
        }
        System.out.print(this.info + " ");
        if (this.right != null) {
            this.right.inOrderTraversal();
        }
    }

    public void postOrderTraversal() {
        if (this.left != null) {
            this.left.postOrderTraversal();
        }
        if (this.right != null) {
            this.right.postOrderTraversal();
        }
        System.out.print(this.info + " ");
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(50);

        root.insert(30);
        root.insert(20);
        root.insert(40);
        root.insert(70);
        root.insert(60);
        root.insert(80);
        
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