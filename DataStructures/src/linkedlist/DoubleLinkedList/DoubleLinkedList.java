package linkedlist.DoubleLinkedList;

public class DoubleLinkedList {
    HeroNode head = new HeroNode(0,"","");

    //遍历双向链表
    public void showLinkedList() {
        //判断空
        if (head.getNext() == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    //添加节点在尾部
    public void addNode(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            //如果辅助变量的next为空，则插入节点，不为空则寻找下一个节点
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    //根据编号插入节点
    public void addNodeByNo(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                System.out.println(heroNode.getNo() + "已存在");
                return;
            }
            temp = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.getNext().setPre(heroNode);
        }
        heroNode.setPre(temp);
        heroNode.setNext(temp.getNext());
        temp.setNext(heroNode);

    }

    //根据编号修改节点信息
    public void changeNode(HeroNode heroNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (temp != null) {
            if (temp.getNo() == heroNode.getNo()) {
                temp.setName(heroNode.getName());
                temp.setNickname(heroNode.getNickname());
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("未找到对应" + heroNode.getNo() + "节点");
    }

    //根据编号删除节点
    public void deleteNode(Integer no) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (temp != null) {
            if (temp.getNo() == no) {
                temp.getPre().setNext(temp.getNext());
                //如果删除最后一个节点，不执行下面一条，否则会出现NullPointException
                if (temp.getNext() != null) {
                    temp.getNext().setPre(temp.getPre());
                }
                return;
            }
            temp = temp.getNext();
        }
    }
}
