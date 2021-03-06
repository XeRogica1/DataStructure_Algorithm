package linkedlist;

public class SingleLinkedListTest {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //顺序添加节点
        singleLinkedList.addNode(hero1);
        singleLinkedList.addNode(hero3);
        singleLinkedList.addNode(hero2);
        singleLinkedList.addNode(hero4);
        singleLinkedList.showLinkedList();
        System.out.println("-------------------");
        //按顺序插入节点
        singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNodeByOrder(hero1);
        singleLinkedList.addNodeByOrder(hero4);
        singleLinkedList.addNodeByOrder(hero2);
        singleLinkedList.addNodeByOrder(hero3);
        singleLinkedList.addNodeByOrder(hero3);
        singleLinkedList.showLinkedList();
        System.out.println("----------------");
        //修改节点
        HeroNode newNode = new HeroNode(3,"卢本伟","aab");
        HeroNode newNode2 = new HeroNode(5,"卢本伟","aab");
        singleLinkedList.changeNode(newNode);
        singleLinkedList.changeNode(newNode2);
        singleLinkedList.showLinkedList();
        System.out.println("--------------------");
        //删除节点
        singleLinkedList.deleteNode(3);
        singleLinkedList.deleteNode(2);
        singleLinkedList.deleteNode(7);
        singleLinkedList.showLinkedList();
    }
}
