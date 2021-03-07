package linkedlist.SingleLinkedList;
//翻转单链表
//利用栈将链表倒序输出，不破坏原来栈的结构
public class SingleLinkedListTest03 {
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

        sll.reverse();
        System.out.println("翻转后的链表");
        sll.showLinkedList();
        System.out.println();
        System.out.println("链表倒序输出");
        sll.reversePrint();
    }
}
