package 动态规划;

public class LeeCode337 {
    public static void main(String[] args) {


    }
    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] dp = robAction(root);
        return Math.max(dp[0],dp[1]);
    }

    public static int[] robAction(TreeNode root){
        int[] dp = new int[2];
        if(root==null){
            return dp;
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        //当前节点不偷
        dp[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //当前节点偷
        dp[1] = root.val+left[0]+right[0];
        return dp;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
