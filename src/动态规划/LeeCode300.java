package 动态规划;

import java.util.Arrays;

public class LeeCode300 {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        lengthOfLIS(nums);
    }
    public static int lengthOfLIS(int[] nums) {
        //dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
//            res = Math.max(res,dp[i]);
            System.out.println(dp[i]);
        }

        return dp[nums.length-1];
    }

}
