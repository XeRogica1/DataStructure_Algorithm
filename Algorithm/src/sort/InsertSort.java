package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        insertSort(arr);
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //从第二个数开始为要插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;//要插入的数前一个数为插入坐标

            //insertIndex > 0确保下标不越界
            //insertVal < arr[insertIndex]要插入的数比插入坐标的数要小
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //将插入值后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出了while循环说明找到了插入位置

            arr[insertIndex + 1] = insertVal;
            System.out.println("第" + i + "轮排序后的数组");
            System.out.println(Arrays.toString(arr));
        }

    }
}
