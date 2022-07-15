package sortTest;

import java.util.Arrays;

public class InsertTest {
    public static void main(String[] args) {
        int arr[] = {3,9,-1,10,-2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //待插入的值
            int insertVal = arr[i];
            //待插入的位置
            int insertIndex= i-1;
            //当待插入的值的前面的数都大于插入值时，该位置的数后移，直到找到小于插入数的位置，再将该数后一个位置放入插入值
            while(insertIndex>=0 && arr[insertIndex]>insertVal){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;

        }
    }
}
