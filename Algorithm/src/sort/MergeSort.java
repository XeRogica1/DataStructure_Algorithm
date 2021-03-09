package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    //归并排序
    public static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        //递归拆分归并
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    //归并部分
    //left表示左部分的第一位，mid表示右部分的初始位，right表示最后一位
    public static void merge(int[] arr, int left, int mid, int right) {
        //临时数组
        int[] temp = new int[arr.length];
        //临时数组的指针
        int t = left;
        //左右部分的移动指针
        int i = left;
        int j = mid + 1;
        //左右部分同时遍历
        while (i <= mid && j <= right) {
            //小的数存入临时数组中
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //退出循环代表左右其中某一部分遍历完成
        //将未遍历完的部分剩余数存入临时数组
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //将临时数组复制回原数组
        for (int k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }
}
