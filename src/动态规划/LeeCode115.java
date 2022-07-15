package 动态规划;

public class LeeCode115 {
    public int numDistinct(String s, String t) {
        //dp表示 以i-1为结尾的s字符串，匹配j-1结尾的t字符串的个数
        int[][] dp = new int[s.length()+1][t.length()+1];
        //初始化：dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
        //dp[0][i] 一定是0
        for(int i = 0;i<s.length();i++){
            dp[i][0] = 1;
        }

        for(int i = 1;i<s.length()+1;i++){
            for(int j = 1;j<t.length()+1;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    //以s = "rara" t = "ra" 为例，当i = 3, j = 1时，s[i] == t[j]。此时分为2种情况，s串用最后一位的a + 不用最后一位的a。如果用s串最后一位的a,那么t串最后一位的a也被消耗掉，此时的子序列其实=dp[i-1][j-1] 如果不用s串最后一位的a，那就得看"rar"里面是否有"ra"子序列的了，就是dp[i-1][j]
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];

    }
}
