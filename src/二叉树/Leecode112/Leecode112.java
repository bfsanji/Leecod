package 二叉树.Leecode112;

public class Leecode112 {

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

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum - root.val);
    }

    public boolean dfs(TreeNode root, int sum) {
        //如果到叶子节点且sum为0
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        //如果到叶子节点且sum不为0
        if (root.left == null && root.right == null) {
            return false;
        }
        // 左 （空节点不遍历）
        if (root.left != null) {
            sum -= root.left.val;
            // 遇到叶子节点返回true，则直接返回true
            if (dfs(root.left, sum)) {
                return true;
            }
            sum += root.left.val; // 回溯
        }
        if (root.right != null) {
            sum -= root.right.val;
            if (dfs(root.right, sum)) {
                return true;
            }
            sum += root.right.val;
        }
        return false;

    }


}

