package sortTest;

public class BubbleTest {
    public static void main(String[] args) {
        int arr[] = {-4,9,-1,10,-2,6};
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
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
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
