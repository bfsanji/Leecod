package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int temp =0;
        int pivot = arr[(left + right)/2]; //中轴值
        while(l<r) {//while循环目的是让比pivot值小的放到左边，大的放到右边
            //在pivot的左边一直找，找到大于等于pivot值，才推出
            while(arr[l]<pivot){
                l+=1;
            }
            while(arr[r]>pivot){
                r-=1;
            }
            //如果此条件成立，说明pivot的左右的值，已经全是 左边小于等于pivot,右边大于等于pivot
            if(l>=r){
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //如果交换后，发现arr[l] == pivot值，r--, 前移
            if(arr[l] == pivot){
                r-=1;
            }
            //如果交换后，发现arr[r]==pivot值 l++
            if(arr[r] == pivot){
                l++;
            }
        }
        //如果l==r,必须l++, r-- 否则出现栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        if(right>l){
            quickSort(arr,l,right);
        }


    }
}
