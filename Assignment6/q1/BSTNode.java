package Assignment6.q1;

public class BSTNode {
    int info;
    BSTNode left;
    BSTNode right;
    public BSTNode(int info){
        this.info = info;
        this.left = this.right = null;
    }
    public BSTNode insert(BSTNode root,int value){
        if(root == null) return new BSTNode(value);
        if(value < root.info){
            insert(root.left, value);
        }else if(value > root.info){
            insert(root.right, value);
        }
        return root;
    }
    public void preOrder(BSTNode root) {
        if (root != null) {
            System.out.print(root.info + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(BSTNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.info + " ");
            inOrder(root.right);
        }
    }

    public void postOrder(BSTNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.info + " ");
        }
    }

    public static void main(String[] args) {
        BSTNode root = null;
        BSTNode tree = new BSTNode(0);

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            root = tree.insert(root, value);
        }

        System.out.print("Pre-order: ");
        tree.preOrder(root);
        System.out.print("\nIn-order: ");
        tree.inOrder(root);
        System.out.print("\nPost-order: ");
        tree.postOrder(root);
    }
}