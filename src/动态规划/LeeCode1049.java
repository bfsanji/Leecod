package 动态规划;

public class LeeCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone:stones){
            sum+=stone;
        }
        int[] dp = new int[sum/2+1];

        for(int i = 0;i<stones.length;i++){
            for(int j = sum/2;j>=stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[sum/2];
    }
}
