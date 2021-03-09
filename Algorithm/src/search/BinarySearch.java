package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {3, 14, 53, 214, 542, 748, 4396, 4396, 4396, 4396, 7890};
        int num = 4396;
        int index = binarySearch(arr, num, 0, arr.length);
        System.out.println(num + "的下标是" + index);
        List indexList = binarySearchAll(arr, num, 0, arr.length);
        System.out.println(indexList);
    }


    //二分查找，必须是有序数组
    public static int binarySearch(int[] arr, int num, int start, int end) {
        int mid = (start + end) / 2;

        if (start > end) {
            return -1;
        }
        //查找数大于中间数，向右递归
        if (num > arr[mid]) {
            start = mid + 1;
            return binarySearch(arr, num, start, end);
        } else if (num < arr[mid]) {
            //查找数小于中间数，向左递归
            end = mid - 1;
            return binarySearch(arr, num, start, end);
        } else {
            //查找数与中间数相同，直接返回中间下标
            return mid;
        }
    }

    //二分查找，找到数组中所有的相同数据
    //找到索引值是不立刻返回，扫描左侧，扫描右侧，将结果值的下标加入到集合中
    //返回arraylist
    public static List binarySearchAll(int[] arr, int num, int start, int end) {
        int mid = (start + end) / 2;

        List<Integer> indexList = new ArrayList<>();
        if (start > end) {
            return new ArrayList();
        }
        //查找数大于中间数，向右递归
        if (num > arr[mid]) {
            start = mid + 1;
            return binarySearchAll(arr, num, start, end);
        } else if (num < arr[mid]) {
            //查找数小于中间数，向左递归
            end = mid - 1;
            return binarySearchAll(arr, num, start, end);
        } else {
            indexList.add(mid);
            //扫描左边
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != num) {
                    //如果扫描结束或找到不相同的值结束循环
                    break;
                }
                indexList.add(temp);
                temp--;
            }
            //扫描右边
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != num) {
                    //如果扫描结束或找到不相同的值结束循环
                    break;
                }
                indexList.add(temp);
                temp++;
            }
            return indexList;
        }
    }
}
