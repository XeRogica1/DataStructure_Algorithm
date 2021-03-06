package queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
        //菜单
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("-----------");
            System.out.println("s(show),显示队列");
            System.out.println("e(exit),退出");
            System.out.println("a(add),添加数据");
            System.out.println("g(get),取数据");
            System.out.println("h(head),取头数据");
            key = scanner.next().charAt(0);//接收数据
            switch (key) {
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int num = scanner.nextInt();
                    circleArrayQueue.addQueue(num);
                    break;
                case 'g':
                    try {
                        int res = circleArrayQueue.getQueue();
                        System.out.println(res);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    circleArrayQueue.showHead();
                    break;
                case 'e':
                    System.exit(0);
            }
        }
    }
}
