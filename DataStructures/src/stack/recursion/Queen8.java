package stack.recursion;

public class Queen8 {
    //皇后数量
    int queenNum = 8;
    //一维数组代表最后的皇后拜访规则arr[i]=val代表第i+1个皇后摆放在i+1行val+1列
    int[] queenArr = new int[queenNum];
//解法数
    int count = 0;


    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }


    //放入第n皇后在第n行
    public void check(int n) {
        //如果放置第八个皇后，输出并返回
        if (n == queenNum) {
            printArr();
            return;
        }
        //依次在第i列放入皇后
        for (int i = 0; i < queenNum; i++) {
            queenArr[n] = i;
            //判断不冲突，则递归放置下一个
            if (judge(n)) {
                check(n + 1);
            }
            //冲突，则将当前皇后放入下一列
        }
    }

    //判断皇后位置
    //n代表第几个皇后
    //返回这个皇后与之前皇后是否冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //一维数组下标代表行数，所以已经规避皇后在同一行
            //queenArr[i] == queenArr[n]代表第n个皇后与之前皇后不在同一列
            //Math.abs(n - i) == Math.abs(queenArr[n] - queenArr[i])代表第n个皇后与之前皇后不在同一斜线
            if (queenArr[i] == queenArr[n] ||
                    Math.abs(n - i) == Math.abs(queenArr[n] - queenArr[i])) {
                return false;
            }
        }
        return true;
    }

    //输出数组
    public void printArr() {
        count++;
        StringBuffer str = new StringBuffer();
        str.append(count);
        str.append("解法:[");
        for (int i = 0; i < queenArr.length; i++) {
            str.append(queenArr[i]);
            str.append(", ");
        }
        str.delete(str.length() - 2, str.length());
        str.append("]");
        System.out.println(str);
    }
}
