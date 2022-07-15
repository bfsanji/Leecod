package 动态规划;


/*
怎么更新dp数组呢？

遍历nums，遍历的数记作num
再逆序遍历从P到num，遍历的数记作j
更新dp[j] = dp[j - num] + dp[j]
这样遍历的含义是，对每一个在nums数组中的数num而言，dp在从num到P的这些区间里，都可以加上一个num，来到达想要达成的P。
举例来说，对于数组[1,2,3,4,5]，想要康康几种方法能组合成4,那么设置dp[0]到dp[4]的数组
假如选择了数字2,那么dp[2:5]（也就是2到4）都可以通过加上数字2有所改变，而dp[0:2]（也就是0到1）加上这个2很明显就超了，就不管它。
以前没有考虑过数字2,考虑了会怎么样呢？就要更新dp[2:5]，比如说当我们在更新dp[3]的时候，就相当于dp[3] = dp[3] + dp[1],即本来有多少种方法，加上去掉了2以后有多少种方法。因为以前没有考虑过2,现在知道，只要整到了1,就一定可以整到3。
 */
public class LeeCode495 {
    public int findTargetSumWays(int[] nums, int target) {
        /*原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
        我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里  正 子集P = [1, 3, 5]和负子集N = [2, 4]  那么让我们看看如何将其转换为子集求和问题：sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N) 2 * sum(P) = target + sum(nums)
因此，原来的问题已转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum(P) = (target + sum(nums)) / 2*/
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if((target+sum)%2!=0){
            return 0;
        }
        int[] dp = new int[(target+sum)/2+1];
        dp[0] = 1;
        for(int i = 0;i<nums.length;i++){
            for(int j = (target+sum)/2;j>=nums[i];j--){
                //此处表示，原来的数量加上 添加了新的数nums[i]后的数量   即思考：有了新数字nums[i]对原先没有该数字的数量的变化
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[(target+sum)/2];
    }

}
