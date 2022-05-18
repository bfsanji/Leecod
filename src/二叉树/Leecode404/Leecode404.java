package 二叉树.Leecode404;

/**
 * @Author: JBM
 * @Date: 2022/3/28 9:43
 */
public class Leecode404 {
    public static void main(String[] args) {
       TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        sumOfLeftLeaves(root);
    }
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal =sumOfLeftLeaves(root.right);
        int midVal = 0;
        if(root.left!=null && root.left.left ==null && root.left.right==null){
            midVal = root.left.val;
        }
        int sum = midVal+leftVal+rightVal;
        return sum;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
