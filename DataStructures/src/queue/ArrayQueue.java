package queue;

public class ArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列首
    private int rear;//队列尾
    private int[] arr;//数组模拟队列

    //构造队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;//front指向队列头前一个位置
        rear = -1;//rear指向队列尾包含的位置
    }

    //判断队列满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列空
    public boolean isEmpty() {
        return rear == front;
    }

    //入队列
    public void addQueue(int num) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，无法存数据");
            return;
        }
        //rear后移
        rear++;
        arr[rear] = num;
    }

    //出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法取数据");
        }
        //front后移
        front++;
        return arr[front];
    }

    //显示队列值
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //显示队列头
    public void showHead() {
        if (isEmpty()) {
            System.out.println("队列空");
        }
        System.out.println(arr[front + 1]);
    }
}
