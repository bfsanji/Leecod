package 动态规划;

public class LeeCode123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        //五种状态：0保持不动；1第一次买入；2第一次卖出；3第二次买入；4第二次卖出
        dp[0][1] = -prices[0];
        //同一天买入卖出，再买入
        dp[0][3] = -prices[0];
        for(int i = 1;i<prices.length;i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][1]+prices[i],dp[i-1][2]);
            dp[i][3] = Math.max(dp[i-1][2]-prices[i],dp[i-1][3]);
            dp[i][4] = Math.max(dp[i-1][3]+prices[i],dp[i-1][4]);
        }
        return dp[prices.length-1][4];
    }
}
