package stack.linkedliststack;

public class LinkedListStackTest {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        LinkedListStack lls = new LinkedListStack();
        lls.push(n1);
        lls.push(n2);
        lls.show();
        System.out.println("----------");
        lls.pop();
        lls.push(n4);
        lls.push(n3);
        lls.push(n2);
        lls.show();
        System.out.println("------");
        lls.pop();
        lls.pop();
    }
}
