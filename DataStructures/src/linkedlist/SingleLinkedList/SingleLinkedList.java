package linkedlist.SingleLinkedList;

public class SingleLinkedList {
    //初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点在尾部
    //找到链表的最后一个节点，将其next指向新的节点
    public void addNode(HeroNode heroNode) {
        //需要辅助变量temp
        HeroNode temp = head;
        while (temp.getNext() != null) {
            //如果辅助变量的next为空，则插入节点，不为空则寻找下一个节点
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
    }

    //遍历链表
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

    //根据编号插入节点
    public void addNodeByOrder(HeroNode heroNode) {
        //辅助节点temp是添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;//标记编号是否存在
        while (temp.getNext() != null) {
            //找到插入节点的位置
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                //编号存在，修改标记
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag == true) {
            System.out.println(heroNode.getNo() + "编号已存在");
        } else {
            //插入节点在temp后
            heroNode.setNext(temp.getNext());
            temp.setNext(heroNode);
        }
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
        while (temp.getNext() != null) {
            if (temp.getNext().getNo() == no) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("未找到对应" + no + "节点");
    }
}
