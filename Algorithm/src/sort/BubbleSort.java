package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr){
        //临时变量用于交换
        int temp = 0;
        //定义变量用于确定是否有交换发生
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面值比后面值大则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "次的排序结果");
            System.out.println(Arrays.toString(arr));
            //判断，无交换发生结束循环
            if (!flag) {
                break;
            } else {
                //重置flag
                flag = false;
            }
        }
    }
}
