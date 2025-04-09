package Assignment6.q2;

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

public class q2 {
    public static TreeNode CreateTree(int[] arr) {
        return CreateTreeHelper(arr, 0, arr.length - 1);
    }

    private static TreeNode CreateTreeHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = CreateTreeHelper(arr, start, mid - 1);
        root.right = CreateTreeHelper(arr, mid + 1, end);

        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        TreeNode root = CreateTree(arr);
        
        System.out.println("Inorder traversal of the constructed BST:");
        inorderTraversal(root);
    }
}
