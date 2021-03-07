package stack.stackcalculator;

public class ArrayStack {
    private int maxSize;//栈大小
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满，无法继续放入数据");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空，无数据返回");
            return 0;
        }
        int res = stack[top];
        top--;
        return res;
    }

    //显示栈
    //从栈顶开始遍历
    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    //返回栈顶元素的值
    public int peek() {
        return stack[top];
    }

    //判断符号优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断数字与符号
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
