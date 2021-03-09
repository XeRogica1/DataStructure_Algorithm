package search;

import java.util.Arrays;

public class FibonacciSearch {
    //斐波那契数列长度
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {3, 14, 53, 214, 542, 748, 4396, 7890};
        int num = 14;
        int index = fibonacciSearch(arr, num);
        System.out.println(num + "的下标是" + index);
    }


    //构建斐波那契数列
    public static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    //斐波那契查找
    public static int fibonacciSearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;//计算得到中间值
        int k = 0;//斐波那契数列的下标
        int f[] = fib();//获得斐波那契数列

        //获取分隔值的下标
        while (f[k] - 1 < arr.length) {
            k++;
        }
        //创建临时数组
        int[] temp = new int[f[k] - 1];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        //由于斐波那契长度的数组可能长于原数组，用最后一个数填充后续下标
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[end];
        }
        //二分查找思路
        while (start <= end) {
            //计算mid值
            mid = start + f[k - 1] - 1;
            if (num < arr[mid]) {
                //查找数小于中间数，向左侧查找
                //全部元素f[k]-1=长片段f[k-1]-1+短片段f[k-2]-1;
                end = mid - 1;
                k--;
            } else if (num > arr[mid]) {
                //查找数大于中间数，向右侧查找
                start = mid + 1;
                k -= 2;
            } else {
                if (mid <= end) {
                    //如果查找下标小于最大下标，返回查找下标
                    return mid;
                } else {
                    //反之说明查找下标处于扩容部分，返回最大下标
                    return end;
                }
            }
        }
        return -1;
    }
}
