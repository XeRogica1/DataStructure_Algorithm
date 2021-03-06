package queue;

public class CircleArrayQueue {
    private int maxSize;//最大容量
    private int front;//队列首，指向队列第一个元素
    private int rear;//队列尾，指向队列最后一个元素后一个的空位置
    private int[] arr;//数组模拟队列

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;
        rear = 0;
    }

    //判断满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断空
    public boolean isEmpty() {
        return rear == front;
    }

    //存数据
    public void addQueue(int num) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，无法存数据");
            return;
        }
        //rear空值位置存数据，然后后移
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    //取数据
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法取数据");
        }
        //先赋值给临时值，front后移，返回临时值
        int res = arr[front];
        front = (front + 1) % maxSize;
        return res;
    }

    //显示队列
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        //从front开始遍历，遍历(rear+maxSize-front)%maxSize个元素
        for (int i = front; i < front + size(); i++) {
            //数组下标i可能超过数组长度，需要取模
            System.out.print(arr[i % maxSize] + " ");
        }
        System.out.println();
    }

    //求当前队列有效数据个数，用于遍历
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头
    public void showHead() {
        if (isEmpty()) {
            System.out.println("队列空");
        }
        System.out.println(arr[front]);
    }
}
