package linkedlist.SingleLinkedList;

import java.util.Stack;

public class SingleLinkedList {
    //初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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


    //获取链表长度
    public int getLength() {
        if (head.getNext() == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.getNext();
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    //返回倒数第k个数
    public HeroNode getLastIndexNode(int k) {
        int length = getLength();
        if (k > length || k <= 0) {
            System.out.println("输入数不正确");
            return null;
        }
        HeroNode cur = head.getNext();
        for (int i = 0; i < length - k; i++) {
            cur = cur.getNext();
        }
        return cur;
    }


    //翻转链表
    public void reverse() {
        //判断空或只有一个节点则无需翻转
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        //辅助指针用于遍历链表
        HeroNode cur = head.getNext();
        //辅助指针用于指向当前节点的下一个节点
        HeroNode next = null;
        //辅助新头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历链表，头插
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(reverseHead.getNext());
            reverseHead.setNext(cur);
            cur = next;
        }
        //将原头节点指向最后一个节点
        head.setNext(reverseHead.getNext());
    }


    //通过栈逆序打印链表
    public void reversePrint() {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.getNext();
        //压栈
        while (cur != null) {
            stack.add(cur);
            cur = cur.getNext();
        }
        //弹栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }


    //按序合并并输出链表

    /**
     * @param h1 头结点1，作为基础链表
     * @param h2 头结点2
     */
    public static void merge(HeroNode h1, HeroNode h2) {
        HeroNode cur1 = h1.getNext();
        HeroNode cur2 = h2.getNext();
        HeroNode next = null;
        //遍历第二链表
        while (cur2 != null) {
            next = cur2.getNext();
            //获取的节点按序插入第一链表
            while (cur1 != null) {
                if (cur1.getNext().getNo() > cur2.getNo()) {
                    break;
                }
                cur1 = cur1.getNext();
            }
            cur2.setNext(cur1.getNext());
            cur1.setNext(cur2);
            cur2 = next;
        }
        //输出链表
        cur1 = h1.getNext();
        while (cur1 != null) {
            System.out.println(cur1);
            cur1 = cur1.getNext();
        }
    }
}
