package divide_and_conquer;

public class HanoiTower {
    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }


    /**
     * 用分治算法解决汉诺塔
     *
     * @param n 汉诺塔的盘的数量
     * @param a 起始地
     * @param b 借助地
     * @param c 目标地
     */
    public static void hanoi(int n, char a, char b, char c) {
        if (n == 1) {
            System.out.println("第1个盘" + a + "=>" + c);
        } else {
            //上面所有盘A⇒B
            hanoi(n - 1, a, c, b);
            //最下面盘A⇒C
            System.out.println("第" + n + "个盘" + a + "=>" + c);
            //B盘所有盘B⇒C
            hanoi(n - 1, b, a, c);
        }
    }
}
