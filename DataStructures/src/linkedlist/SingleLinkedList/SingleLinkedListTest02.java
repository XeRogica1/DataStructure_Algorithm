package linkedlist.SingleLinkedList;

//输出一个链表倒数第k个节点
public class SingleLinkedListTest02 {
    public static void main(String[] args) {
        SingleLinkedList sll = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        sll.addNode(hero1);
        sll.addNode(hero2);
        sll.addNode(hero3);
        sll.addNode(hero4);

        int length = sll.getLength();
        System.out.println("链表长度为" + length);
        int k = 3;
        HeroNode node = sll.getLastIndexNode(k);
        System.out.println("链表倒数第" + k + "个节点是" + node);
    }
}
