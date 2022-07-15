package 动态规划;

import java.util.Arrays;

public class LeeCode322 {
    public static void main(String[] args) {
        int[] coins = {2,3};
        int i = coinChange(coins, 3);
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;
        for(int i = 0; i<coins.length;i++){
            for(int j = coins[i];j<amount+1;j++){
                if (dp[j - coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
