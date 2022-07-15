package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1; // arr[1]前面这个数的下表
            //给insertVal找到插入的位置
            //说明：1、insertIndex>=0保证再给insertVal找插入位置，不越界  2、insertVal<arr[insertIndex]待插入的数，还没找到插入位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if(insertIndex + 1!=i){
                //推出while循环时，说明插入的位置找到，insertIndex +1
                arr[insertIndex + 1] = insertVal;
            }

        }
    }
}
