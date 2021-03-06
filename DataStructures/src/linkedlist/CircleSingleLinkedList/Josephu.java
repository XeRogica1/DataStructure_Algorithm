package linkedlist.CircleSingleLinkedList;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoys(5);
        circleSingleLinkedList.show();
        System.out.println();
        System.out.println("-----------");
        //josephu问题测试
        //5个人，从1开始报数，数2，结果2-4-1-5-3
        circleSingleLinkedList.josephuCount(1,2,5);
    }
}
