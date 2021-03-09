package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //快速排序
    public static void quickSort(int[] arr, int low, int high) {
        int i, j,pivot;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //基准位
        pivot = arr[low];
        //临时变量
        int temp;
        while (i < j) {
            //j从右到左遍历直到数小于基准退出循环
            while (arr[j] >= pivot && i < j) {
                j--;
            }
            //i从左到右遍历直到数大于基准退出循环
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            //交换
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //跳出循环代表i=j，将基准位与i交换
        arr[low] = arr[i];
        arr[i] = pivot;

        //递归左半部分
        quickSort(arr, low, j - 1);
        //递归右半部分
        quickSort(arr, j + 1, high);
    }
}
