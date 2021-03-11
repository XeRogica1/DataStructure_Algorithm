package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 8, 2, 3, 5, 4, 9, 0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //堆排序
    public static void heapSort(int[] arr) {
        //总共有arr.length/2-1个非叶子节点，依次从下到上执行
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toTopHeap(arr, i, arr.length);
        }
        //将大顶堆根节点（为arr[0]同时为最大值）与末尾元素交换
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //重新调整
            toTopHeap(arr, 0, i);
        }

    }

    //将一个数组变成大顶堆
    //arr是要调整的数组，index是非叶子节点的索引，length表示多少元素需要调整，逐渐会减少
    public static void toTopHeap(int[] arr, int index, int length) {
        //index为非叶子节点父节点，保存到临时变量
        int temp = arr[index];
        //寻找左子节点i
        for (int i = index * 2 + 1; i < length; i = i * 2 + 1) {
            //左子节点小于右子节点，则指向右子节点
            if (i + 1 < length && arr[i] < arr[i + 1]) {
                i++;
            }
            //如果子节点大于父节点
            if (arr[i] > temp) {
                //父节点变为子节点
                arr[index] = arr[i];
                //将子节点变为父节点，继续循环比较
                index = i;
            } else {
                //
                break;
            }
            //将临时值赋值到index的位置
            arr[index] = temp;
        }
    }
}
