package 动态规划;

import java.util.Arrays;

public class PackageTest {
    public static void main(String[] args) {
        int[] w = {1,4,3};//物品重量
        int[] val = {1500,300,2000};//物品的价值
        int m =4; //背包的容量
        int n = val.length; //物品的个数
        //创建二维数组
        int[][] v = new int[n+1][m+1];

        //记录放商品的情况，定义一个二维数组
        int[][] path = new int[n+1][m+1];

        //初始化第一行和第一列,这里在本程序中，可以不去处理，因为默认是0
        for(int i = 0; i<v.length;i++){
            v[i][0] = 0;
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //因为二维数组有一行一列为0，而重量数组和单价数组不包含0，所以用到的时候都要减去一
        //根据公式动态规划处理
        for (int i = 1; i <v.length; i++) {
            for(int j = 1;j<v[0].length;j++){
                if (w[i-1]>j){
                    v[i][j] = v[i-1][j];
                }else {
//                    v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                //为了记录商品存放到背包的情况，我们不能简单的使用上面的公式。需要使用if else
                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }


    }
}
