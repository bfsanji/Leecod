package 二叉树.Leecode513;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: JBM
 * @Date: 2022/3/28 10:36
 */
public class Leecode513 {
    public int findBottomLeftValue(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int val = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0; i<size; i++){
            TreeNode cur = queue.poll();
            if(i == 0){
                val = cur.val;
            }
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }

        }
    }
    return val;
}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


