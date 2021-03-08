package sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //System.out.println("希尔交换排序");
        //shellExchangeSort(arr);
        System.out.println("希尔插入排序");
        shellInsertSort(arr);
    }

    //希尔排序-交换
    public static void shellExchangeSort(int[] arr) {
        int div = arr.length;
        int temp = 0;
        while (div != 1) {
            //获得步长
            div /= 2;
            for (int i = div; i < arr.length; i++) {
                for (int j = i - div; j >= 0; j -= div) {
                    //当前元素大于加上步长后的数，则交换
                    if (arr[j] > arr[j + div]) {
                        temp = arr[j];
                        arr[j] = arr[j + div];
                        arr[j + div] = temp;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }


    //希尔排序-移位
    public static void shellInsertSort(int[] arr) {
        int div = arr.length;
        while (div != 1) {
            div /= 2;
            for (int i = div; i < arr.length; i++) {
                //插入下标与插入值
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - div]) {
                    //在下标范围中寻找插入点，同时前面的数后移
                    while (j - div >= 0 && temp < arr[j - div]) {
                        arr[j] = arr[j - div];
                        j -= div;
                    }
                    //退出while循环代表找到了插入位置
                    arr[j] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
