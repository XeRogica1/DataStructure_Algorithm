package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 4396, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序
    public static void radixSort(int[] arr) {
        //定义二维数组作为十个桶
        //10为桶的数量，为了防止桶下标溢出，将数组长度定为桶的深度
        int[][] bucket = new int[10][arr.length];
        //每个桶的下标作为一个一维数组
        int[] bucketCount = new int[10];

        //得到数组最大数的位数作为循环数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int loopNum = (max + "").length();

        for (int i = 0, n = 1; i < loopNum; i++, n *= 10) {
            //遍历数组，将每个元素的对应位数放到对应桶中
            for (int j = 0; j < arr.length; j++) {
                int digit = arr[j] / n % 10;
                bucket[digit][bucketCount[digit]] = arr[j];
                bucketCount[digit]++;
            }
            //原数组的下标
            int index = 0;
            //遍历每一个桶，将桶中数据依次放回数组
            for (int j = 0; j < bucketCount.length; j++) {
                //桶中有数据才放回数组
                if (bucketCount[j] != 0) {
                    for (int k = 0; k < bucketCount[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                }
                //将存放桶数量的数组清零
                bucketCount[j] = 0;
            }
            System.out.println("第" + (i + 1) + "轮排序的结果" + Arrays.toString(arr));
        }

    }
}
