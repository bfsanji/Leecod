package 动态规划;

import java.util.Arrays;

public class LeeCode70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));

    }
    public static int climbStairs(int n) {
        int[] weight = {1,2};
        if(n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<n+1;i++){
            for (int j = 0; j < weight.length; j++) {
                dp[i] += dp[i-weight[j]];
            }
        }
        return dp[n];
    }
}
