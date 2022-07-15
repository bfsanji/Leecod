package 动态规划;

public class LeeCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length()+1;
        int n = text2.length()+1;
        int[][] dp = new int[m][n];
        for(int i = 1;i<text1.length()+1;i++){
            char char1 = text1.charAt(i-1);
            for(int j = 1;j<text2.length()+1;j++){
                char char2 = text2.charAt(j-1);
                if(char1==char2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    //若要求连续子串则没有这一步，若不要求连续则有
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }
        return dp[m-1][n-1];
    }
}
