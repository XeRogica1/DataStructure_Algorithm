package linkedlist.SingleLinkedList;

public class SingleLinkedListTest04 {
    public static void main(String[] args) {
        SingleLinkedList s1 = new SingleLinkedList();
        SingleLinkedList s2 = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "卢本伟", "aab");
        s1.addNodeByOrder(hero4);
        s1.addNodeByOrder(hero1);
        s1.addNodeByOrder(hero5);
        s2.addNodeByOrder(hero3);
        s2.addNodeByOrder(hero2);
        System.out.println("s1链表");
        s1.showLinkedList();
        System.out.println("s2链表");
        s2.showLinkedList();
        System.out.println("合并后的链表");
        SingleLinkedList.merge(s1.getHead(),s2.getHead());
    }
}
