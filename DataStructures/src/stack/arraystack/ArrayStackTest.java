package stack.arraystack;

import java.util.Scanner;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        int key = ' ';
        while (true) {
            System.out.println("--------------");
            System.out.println("1(push)，入栈");
            System.out.println("2(pop)，出栈");
            System.out.println("3(show)，显示栈");
            System.out.println("4(exit)，退出");
            Scanner s = new Scanner(System.in);
            key = s.nextInt();
            switch (key) {
                case 1:
                    System.out.println("输入数据");
                    int num = s.nextInt();
                    arrayStack.push(num);
                    break;
                case 2:
                    int res = arrayStack.pop();
                    System.out.println(res + "出栈");
                    break;
                case 3:
                    arrayStack.show();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
