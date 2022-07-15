package 动态规划;

public class LeeCode518 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        change1(5,coins);
        System.out.println("+++++++++++++++++++");
        change(5,coins);
    }

    public static int change1(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];

            }
        }
        System.out.println(dp[amount]);
        return dp[amount];
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i<coins.length;i++){
            for(int j = coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];

            }
            for(int k = 0; k<=amount;k++){
                System.out.println(dp[k]);
            }


        }
        return dp[amount];
    }
}
