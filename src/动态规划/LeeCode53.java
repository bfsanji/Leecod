package 动态规划;

public class LeeCode53 {
    public int maxSubArray(int[] nums) {
        //此题的题解很全面！！
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);

            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
