package dynamic_programming;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3, 2};//物品重量
        int[] value = {1500, 3000, 2000, 1800};//单个物品价值
        int m = 6;//背包总重量
        int n = value.length;//物品个数

        //v[i][j]代表前n个物品在m容量下物品的最大总价值
        int[][] v = new int[n + 1][m + 1];
        //记录放入物品的情况
        int[][] object = new int[n + 1][m + 1];
        //初始化第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        //初始化第一行
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //动态规划
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (weight[i - 1] > j) {
                    //新增的物品重量大于背包剩余容量，使用上一格的装入策略
                    v[i][j] = v[i - 1][j];
                } else {
                    //新增物品重量小于背包剩余容量，比较 上一格装入策略 和 新增物品加剩余背包装入策略 的更大值
                    //v[i][j] = Math.max(v[i - 1][j], value[i - 1] + v[i - 1][j - weight[i - 1]]);
                    //记录物品放入情况，需要用if else判断
                    if (v[i - 1][j] < value[i - 1] + v[i - 1][j - weight[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - weight[i - 1]];
                        object[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出填表
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }

        int i = object.length - 1;//行最大下标
        int j = object[0].length - 1;//列最大下标
        while (i > 0 & j > 0) {//从后向前遍历
            if (object[i][j] == 1) {
                System.out.println("第" + i + "个物品放入背包");
                j -= weight[i - 1];//调整背包容量
            }
            i--;
        }
    }


}
