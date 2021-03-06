package linkedlist.DoubleLinkedList;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        HeroNode newNode = new HeroNode(1,"卢本伟","aab");
        //创建双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //添加节点
        doubleLinkedList.addNode(hero4);
        doubleLinkedList.addNode(hero2);
        doubleLinkedList.addNode(hero3);
        doubleLinkedList.addNode(hero1);
        doubleLinkedList.showLinkedList();
        System.out.println("-------------");
        //插入节点
        doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addNodeByNo(hero2);
        doubleLinkedList.addNodeByNo(hero1);
        doubleLinkedList.addNodeByNo(hero2);
        doubleLinkedList.addNodeByNo(hero3);
        doubleLinkedList.addNodeByNo(hero4);
        doubleLinkedList.showLinkedList();
        System.out.println("------------");
        //修改节点
        doubleLinkedList.changeNode(newNode);
        doubleLinkedList.showLinkedList();
        System.out.println("---------------");
        //删除节点
        doubleLinkedList.deleteNode(4);
        doubleLinkedList.deleteNode(2);
        doubleLinkedList.deleteNode(1);
        doubleLinkedList.showLinkedList();
    }
}
