package 动态规划;

public class LeeCode63 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        uniquePathsWithObstacles(arr);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length&&obstacleGrid[i][0]==0;i++){
            obstacleGrid[i][0] = 1;
            System.out.println(obstacleGrid[i][0]);
        }
        for(int i=0;i<obstacleGrid[0].length&&obstacleGrid[0][i]==0;i++){
            obstacleGrid[0][i] = 1;
            System.out.println(obstacleGrid[0][i]);
        }

        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
