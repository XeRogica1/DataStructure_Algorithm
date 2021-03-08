package sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        selectSort(arr);
    }


    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //假定单轮第一个值为最小值
            int minIndex = i;
            int min = arr[i];
            //从第一个值后面进行比较
            for (int j = i + 1; j < arr.length; j++) {
                //值小于假定最小值，则变为最小值
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //将找到的最小值与该轮第一个值交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮排序结果");
            System.out.println(Arrays.toString(arr));
        }
    }
}
