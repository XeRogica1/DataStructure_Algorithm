package stack.recursion;

//阶乘递归
public class RecursionTest02 {
    public static void main(String[] args) {
        int res = factorial(5);
        System.out.println(res);
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
