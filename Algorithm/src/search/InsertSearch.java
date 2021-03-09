package search;

import java.util.Arrays;

public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        arr[0] = 1;
        for (int i = 0; i < 99; i++) {
            arr[i + 1] = arr[i] + 1;
        }
        //System.out.println(Arrays.toString(arr));
        int num = 2;
        int index = insertSearch(arr, num, 0, arr.length - 1);
        System.out.println(num + "的下标是" + index);
    }

    //插值查找
    public static int insertSearch(int[] arr, int num, int start, int end) {
        //num<arr[start]和num>arr[end]用来防止mid计算下标越界
        if (start > end || num < arr[start] || num > arr[end]) {
            return -1;
        }
        int mid = start + (end - start) * (num - arr[start]) / (arr[end] - arr[start]);

        if (start > end) {
            return -1;
        }
        //查找数大于中间数，向右递归
        if (num > arr[mid]) {
            start = mid + 1;
            return insertSearch(arr, num, start, end);
        } else if (num < arr[mid]) {
            //查找数小于中间数，向左递归
            end = mid - 1;
            return insertSearch(arr, num, start, end);
        } else {
            //查找数与中间数相同，直接返回中间下标
            return mid;
        }
    }
}
