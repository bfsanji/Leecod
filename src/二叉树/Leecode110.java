package 二叉树;
/**
 * @Author: JBM
 * @Date: 2022/3/23 19:05
 */
public class Leecode110 {
    public boolean isBalanced(TreeNode root){
        return getHeight(root) != -1;
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);//左
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = getHeight(root.right);//右
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight)>1){  // 中
            return -1;
        }
        return Math.max(leftHeight,rightHeight) +1;
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