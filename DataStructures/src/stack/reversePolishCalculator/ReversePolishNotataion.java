package stack.reversePolishCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotataion {
    public static List<String> toInfixExpressionList(String infixExpression) {
        List<String> list = new ArrayList<>();
        int i = 0;//遍历字符串的指针
        String num;//多位数拼接
        char c;//字符
        do {
            //扫描字符串
            c = infixExpression.charAt(i);
            //非数字直接加入list中
            if (c < 48 || c > 57) {
                list.add(c + "");
                i++;
            } else {
                //是数字，考虑多位数
                num = "";//清空
                while (i < infixExpression.length() && (c = infixExpression.charAt(i)) >= 48 && (c = infixExpression.charAt(i)) <= 57) {
                    num += c;//拼接
                    i++;
                }
                list.add(num);
            }
        } while (i < infixExpression.length());
        return list;
    }

    //将中缀表达式集合转换为后缀表达式集合
    public static List<String> parseInfixToSuffix(List<String> infixList) {
        //两个栈
        Stack<String> operStack = new Stack<>();
        //用list代替栈
        List<String> resStack = new ArrayList<>();
        //遍历list
        for (String ele : infixList) {
            //如果是数，入res
            if (ele.matches("\\d+")) {
                resStack.add(ele);
            } else if (ele.equals("(")) {
                //如果是(，入oper
                operStack.push(ele);
            } else if (ele.equals(")")) {
                //如果是)，oper中弹出元素进res直到遇见(，且丢弃()
                while (!operStack.peek().equals("(")) {
                    resStack.add(operStack.pop());
                }
                operStack.pop();//将(弹出，丢弃一组括号
            } else {
                //ele优先级小于等于栈顶元素，则将该元素加入res，并且与新的栈顶比较
                while (operStack.size() != 0 && operStack.peek() != "(" && OperPriority.getPriority(ele) <= OperPriority.getPriority(operStack.peek())) {
                    resStack.add(operStack.pop());
                }
                operStack.push(ele);
            }
        }
        //将剩余元素弹出并加入res
        while (operStack.size() != 0) {
            resStack.add(operStack.pop());
        }
        return resStack;
    }
}
