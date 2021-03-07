package stack.linkedliststack;

public class LinkedListStack {
    Node head = new Node(0);
    Node top = head.getNext();

    //栈空
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //入栈，头插法
    public void push(Node node) {
        node.setNext(head.getNext());
        head.setNext(node);
        top = head.getNext();
        System.out.println(node+"入栈");
    }

    //出栈
    public Node pop() {
        if (isEmpty()) {
            System.out.println("栈空");
            return null;
        }
        top = head.getNext();
        Node res = head.getNext();
        head.setNext(top.getNext());
        top = head.getNext();
        System.out.println(res + "出栈");
        return res;
    }

    //显示栈
    public void show() {
        if (isEmpty()) {
            System.out.println("栈空");
        }
        while (top != null) {
            System.out.print(top.getData() + " ");
            top = top.getNext();
        }
        System.out.println();
    }
}
