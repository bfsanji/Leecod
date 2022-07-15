package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
    int[] arr={101,34,119,1};
    selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            //假设第一个最小，循环寻找最小值及其索引，为后面交换做准备
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找到最小值
                if (min > arr[j]) {//说明不是最小
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                //将最小值，放在arr[i]，即交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
