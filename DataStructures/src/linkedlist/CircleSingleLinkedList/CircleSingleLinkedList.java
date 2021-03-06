package linkedlist.CircleSingleLinkedList;

public class CircleSingleLinkedList {
    //创建first节点
    private Boy first = null;

    //添加节点，构建环形链表
    public void addBoys(int nums) {
        if (nums < 1) {
            System.out.println("nums需要大于1");
            return;
        }
        //辅助节点用于构建环形链表
        Boy curboy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);//形成环状
                curboy = first;//当前节点指向第一个节点
            } else {
                curboy.setNext(boy);//确立当前节点与新增节点的连接
                boy.setNext(first);//确立新增节点与第一节点的连接
                curboy = boy;//新增节点变为当前节点
            }
        }
    }

    //遍历环形链表
    public void show() {
        if (first == null) {
            System.out.println("单向环形链表为空");
        }
        Boy curboy = first;
        while (true) {
            System.out.print(curboy.getNo() + " ");
            if (curboy.getNext() == first) {
                break;
            }
            curboy = curboy.getNext();
        }
    }

    /**
     * @param startNo  开始数值
     * @param countNum 数多少
     * @param nums     最初总数
     */
    public void josephuCount(int startNo, int countNum, int nums) {
        //数据校验
        if (startNo < 1 || startNo > nums) {
            System.out.println("输入数据有误");
            return;
        }
        //辅助指针
        Boy last = first;
        //指向最后一个节点
        while (true) {
            if (last.getNext() == first) {
                break;
            }
            last = last.getNext();
        }
        //从约定编号的值开始，first和last往后移位startNo-1
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            last = last.getNext();
        }
        //first和last往后移位countNum-1
        while (true) {
            //当first==last则代表单向链表中只有一个节点
            if (first == last) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            //出圈
            System.out.println(first.getNo() + "出圈");
            first = first.getNext();
            last.setNext(first);
        }
        //输出最后留的节点
        System.out.println("最后留的节点" + first.getNo());

    }
}
