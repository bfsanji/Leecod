package 动态规划;

public class LeeCode96 {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<n+1;i++){
            for(int j = 1; j<=i;j++){
                //，j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
