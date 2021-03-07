package stack.reversePolishCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishCalculator {
    public static void main(String[] args) {
        //(3+4)*5-6的后缀表达式：3 4 + 5 * 6 -
        //为了方便，逆波兰表达式用空格隔开字符
        String ReversePolishNotation = "3 4 + 5 * 6 -";
        List<String> rpnList = ReversePolishCalculator.getListString(ReversePolishNotation);
        System.out.println(rpnList);

        int res = ReversePolishCalculator.calc(rpnList);
        System.out.println("(3+4)*5-6的结果是" + res);
        System.out.println((3 + 4) * 5 - 6);


        String infixExpression = "1+((2+3)*4)-5";
        List<String> infixList = ReversePolishNotataion.toInfixExpressionList(infixExpression);
        System.out.println("中缀表达式集合为" + infixList);
        //将中缀表达式1+((2+3)*4)-5转换为后缀表达式1 2 3 + 4 * + 5 -
        List<String> suffixList = ReversePolishNotataion.parseInfixToSuffix(infixList);
        System.out.println("后缀表达式集合为" + suffixList);
        //利用转换后的后缀表达式求计算器结果
        res = ReversePolishCalculator.calc(suffixList);
        System.out.println("1+((2+3)*4)-5的结果是" + res);
        System.out.println(1 + ((2 + 3) * 4) - 5);

    }

    //将逆波兰表达式分隔并存入list中
    public static List<String> getListString(String expression) {
        String[] split = expression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //计算
    public static int calc(List<String> rpnList) {
        //创建栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String ele : rpnList) {
            //使用正则表达式取出数
            if (ele.matches("\\d+")) {
                //匹配多位数，入栈
                stack.add(ele);
            } else {
                //匹配符号，pop两个数，计算再入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (ele.equals("+")) {
                    res = num2 + num1;
                } else if (ele.equals("-")) {
                    res = num2 - num1;
                } else if (ele.equals("*")) {
                    res = num2 * num1;
                } else if (ele.equals("/")) {
                    res = num2 / num1;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
