package sortTest;

import java.util.Arrays;

public class HeapTest {

    public static void main(String[] args) {
        //要求将数组进行升序排序
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr){

        int n = arr.length;
        heapBuild(arr,n);
        for (int i = n-1; i >=0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,i,0);
        }
    }

    /*
     n:总的节点数
     i:堆化的节点
     */
    public static void heapify(int[] arr, int n, int i){
        if(n<=i){
           return;
        }
        int l_node = 2*i+1;
        int r_node = 2*i+2;
        int max = i;
        if(l_node<n && arr[l_node]>arr[max]){
            max = l_node;
        }
        if(r_node<n && arr[r_node]>arr[max]){
            max = r_node;
        }
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr,n,max);
        }

    }
    public static void heapBuild(int[] arr, int n){
        int last_node = n-1;
        int parent = (n-1)/2;
        for (int i = parent; i >=0 ; i--) {
            heapify(arr,n,i);
        }
    }
}
