package stack.stackcalculator;

public class StackCalculator {
    public static void main(String[] args) {
        String expression = "10-2*2+1";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        int index = 0;//index扫描指针
        int num1 = 0;
        int num2 = 0;
        char oper = ' ';
        int res = 0;
        char ch = ' ';
        String kNum = "";//用于拼接多位数
        while (true) {
            //每次扫描的字符存储到ch
            ch = expression.charAt(index);
            //判断ch
            if (operStack.isOper(ch)) {
                //是符号且符号栈为空，直接入栈
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    //符号栈有符号且当前符号小于或等于栈中符号
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = (char) operStack.pop();
                        res = operStack.cal(num1, num2, oper);
                        numStack.push(res);
                        //再次判断
                        if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                            num1 = numStack.pop();
                            num2 = numStack.pop();
                            oper = (char) operStack.pop();
                            res = operStack.cal(num1, num2, oper);
                            numStack.push(res);
                        }
                        operStack.push(ch);
                    } else {
                        //符号栈有符号且当前符号大于栈中符号
                        operStack.push(ch);
                    }
                }
            } else {
                //需要判断是否为多位数
                kNum += ch;
                //如果ch是最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(ch - 48);
                } else {
                    //判断后一位是否为数字
                    if (operStack.isOper(expression.charAt(index + 1))) {
                        //为符号，直接入栈
                        numStack.push(Integer.parseInt(kNum));
                        //清空kNum
                        kNum = "";
                    }
                }

            }
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //表达式扫描完毕，从数栈和符号栈pop
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = (char) operStack.pop();
            res = operStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        //输出结果
        System.out.println(expression + "的结果是" + numStack.pop());
        System.out.println(10 - 2 * 2 + 1);
    }
}
