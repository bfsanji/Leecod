package 动态规划;

public class LeeCode416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        canPartition(nums);
    }
    public static boolean canPartition(int[] nums) {
        //找到2/sum的子集合
        int sum = 0;
        for(int i = 0; i< nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2 !=0){
            return false;
        }
        int[] dp = new int[sum/2 +1];
        dp[0] = 0;



        for(int i = 0;i<nums.length;i++){
            for(int j = dp.length-1;j>=nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }

        for (int j = 0; j <= sum/2; j++){
            System.out.print(dp[j] + " ");
        }
        return dp[sum/2] == sum/2;
    }
}
