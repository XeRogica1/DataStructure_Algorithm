package stack.reversePolishCalculator;

public class OperPriority {
    //定义加减乘除的优先级
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //静态方法返回输入运算符的优先级
    public static int getPriority(String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
        }
        return res;
    }
}
