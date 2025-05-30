package Assignment6.q2;

public class BSTArray {
    int value;
    BSTArray left;
    BSTArray right;
    public BSTArray(int value){
        this.value = value;
    }
    public BSTArray createTree(int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        BSTArray root = new BSTArray(arr[mid]);
        root.left = createTree(arr, start, mid-1);
        root.right =  createTree(arr, mid+1, end);
        return root;
    }
    public void inOrder(BSTArray root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        BSTArray tree = new BSTArray(0);
        BSTArray root = tree.createTree(arr, 0, arr.length - 1);
        System.out.print("In-order traversal: ");
        tree.inOrder(root);
    }
}
