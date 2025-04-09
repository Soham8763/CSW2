package Assignment6.q3;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class q3 {
    public static boolean isBST(TreeNode root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTHelper(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isBSTHelper(node.left, min, node.val) && 
               isBSTHelper(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Test case 1: Valid BST
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        // Test case 2: Invalid BST
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(4); 

        System.out.println("Is tree 1 a BST? " + isBST(root1));
        System.out.println("Is tree 2 a BST? " + isBST(root2));
    }
}
