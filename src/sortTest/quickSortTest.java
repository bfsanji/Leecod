package sortTest;

import java.util.Arrays;

public class quickSortTest {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int start, int end){
        //递归中止条件
        if(start>=end){
            return;
        }
        int i = start; //左指针
        int j = end;  //右指针
        int pivot = arr[i]; //取数组开头为基准值,此时arr[i]空缺
        //
        while(i<j){
            //找到小于基准值的数，若找不到则j左移,直到j==i
            while(i<j && arr[j]>=pivot){
                j--;
            }
            //此处少一次判断i<j 因为如果i==j 交换也等于没交换
            arr[i] = arr[j];
            //找到大于基准值的数，若找不到则i右移，直到i==j
            while(i<j && arr[i]<=pivot){
                i++;
            }
            arr[j] = arr[i];
        }
        //此时ij重合，并且该位置元素空缺，将基准值填入
        arr[i] = pivot;
        //递归左数组
        quickSort(arr,start,i-1);
        //递归右数组
        quickSort(arr,i+1,end);
    }
}
