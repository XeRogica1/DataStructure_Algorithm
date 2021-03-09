package search;

public class SequentialSearch {
    public static void main(String[] args) {
        int[] arr = {542, 53, 3, 14, 214, 4396, 748};
        int num = 4396;
        int index = sequentialSearch(arr, num);
        System.out.println(num + "的下标是" + index);
    }

    //顺序查找
    public static int sequentialSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }
}
