package 动态规划;

import java.util.Arrays;

public class LeeCode746 {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        minCostClimbingStairs(cost);


    }
    public static int minCostClimbingStairs(int[] cost) {
        //默认第一次爬需要耗费体力，因此再爬倒数第一次的时候就不需要耗费体力了，因为倒数第二次已经耗费了
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
            System.out.println("i="+i+"  "+dp[i]);
        }

        //最后一步，如果是由倒数第二步爬，则最后一步的体力花费可以不用算
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
