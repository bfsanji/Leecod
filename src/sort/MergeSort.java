package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分+合的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left<right){
            int mid = (right+left)/2;
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //到合并
            merge(arr,left,mid,right,temp);
        }

    }

    //合并的方法

    /**
     *
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中专的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left; //初始化i ,左边有序序列的初始索引
        int j = mid +1; // 初始化j，右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引

        //1、先把左右两边的数据按照规则填充到temp数组，直到左右两边的有序序列有一边处理完毕
        while(i<=mid && j<= right){//继续
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组，然后t++ i++
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }

        }

        //2、把有剩余的数据的一边以此全部填充到temp
        while(i<=mid){
            //左边的有序序列还有剩余元素,就全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j<= right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        //3、将temp数组元素拷贝到arr
        //并不是每次都拷贝所有的
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft"+tempLeft + " right=" + right);
        while(tempLeft<=right){//第一次合并时tempLeft=0,right=1
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }
}
