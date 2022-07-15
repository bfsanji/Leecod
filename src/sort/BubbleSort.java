package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        boolean flag = false;//标识变量，表示是否进行过变化
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if(arr[j] > arr[j+1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(flag == false){
                //一趟排序中，一次交换都没发生过
                break;
            }
            else{
                flag = false; //重置flag,进行下次判断
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
