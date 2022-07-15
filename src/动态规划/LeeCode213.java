package 动态规划;

import java.util.Arrays;

public class LeeCode213 {
    public int rob(int[] nums) {
        if(nums.length<2){
            return nums[0];
        }
        //因为是循环的，即意味着偷了第一个房子就不能偷最后一个房子，因此可以将数组分成两部分，
        //第一部分是从第一个房子到倒数第二个房子，第二部分是从第二个房子到倒数第一个房子，最终取这两个结果的较大值
        return Math.max(robAction(Arrays.copyOfRange(nums,0,nums.length-1)),
                robAction(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int robAction(int[] subnums){
        if(subnums.length<1){
            return 0;
        }
        if(subnums.length<2){
            return subnums[0];
        }
        int[] dp = new int[subnums.length];
        dp[0] = subnums[0];
        dp[1] = Math.max(subnums[0],subnums[1]);
        for(int i = 2;i<subnums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+subnums[i]);
        }
        return dp[subnums.length-1];
    }
}
