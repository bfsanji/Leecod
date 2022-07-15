package sortTest;

import java.util.Arrays;

public class RadixTest {
    public static void main(String[] args) {
        int arr[] = {53,3,540,748,14,214};
//        radixSort(arr);
        RadixSort(arr);
    }


    public static void radixSort(int[] arr){
        //首先确定数组中数的最大位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();

        //定义一个桶，两个维度，0-9结尾的对应的数据存入
        int[][] bucket = new int[10][arr.length];
        //记录对应桶中元素的数量
        int[] bucketNum = new int[10];
        //将数组中的元素装入桶中
        for (int i = 0,n=1; i < maxLength; n*=10,i++) {
            for (int j = 0; j < arr.length;j++) {
                int digitOfElement =  arr[j]/n%10;
                bucket[digitOfElement][bucketNum[digitOfElement]] = arr[j];
                bucketNum[digitOfElement]++;
            }
            //取出桶中元素
            int index = 0;
            //依次取出0-9的数，放入数组
            for (int k = 0; k < 10; k++) {
                // 0-9结尾的数可能不止一个，需要正序遍历，因为先放入的小，后放入的大
                for (int j = 0; j < bucketNum[k]; j++) {
                    arr[index] = bucket[k][j];
                    index++;
                }
                // 桶中数据的数量清0
                bucketNum[k] = 0;
            }
            System.out.println("第i轮，对个位的排序处理："+ Arrays.toString(arr));
        }

    }
    public static void RadixSort(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketNum = new int[10];
        for (int i = 0, n = 1; i < maxLength;n*=10, i++) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j]/n%10;
                bucket[digitOfElement][bucketNum[digitOfElement]] = arr[j];
                bucketNum[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < bucketNum[j]; k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
                bucketNum[j] = 0;
            }
            System.out.println("第i轮，对个位的排序处理："+ Arrays.toString(arr));
        }
    }
}


