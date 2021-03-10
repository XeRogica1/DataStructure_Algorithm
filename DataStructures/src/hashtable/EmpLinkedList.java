package hashtable;

//员工链表
public class EmpLinkedList {
    private Employee head;

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    //添加员工时，id自增长
    public void add(Employee emp) {
        //添加第一个员工
        if (head == null) {
            head = emp;
            return;
        }
        //不是第一个员工则需要定位最后的指针
        Employee cur = head;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(emp);
    }

    //遍历链表
    public void show(int num) {
        if (head == null) {
            System.out.println(num + "链表为空");
            return;
        }
        System.out.print(num + "链表的信息为");
        Employee cur = head;
        while (cur != null) {
            System.out.print(" => id:" + cur.getId() + ",name:" + cur.getName());

            cur = cur.getNext();
        }
    }

    //根据id查找员工，找到返回员工，没找到返回空
    public Employee findById(int id) {
        //链表空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Employee cur = head;
        while (true) {
            //找到退出循环
            if (cur.getId() == id) {
                break;
            }
            //没找到
            if (cur.getNext() == null) {
                cur = null;
                break;
            }
            cur = cur.getNext();
        }
        return cur;
    }

    //根据id删除员工
    public void remove(int id) {
        //链表空
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Employee cur = head;
        while (true) {
            //遍历完未找到直接返回
            if (cur.getNext() == null) {
                System.out.println("未找到" + id + "员工");
                return;
            }
            //找到退出循环
            if (cur.getNext().getId() == id) {
                break;
            }
            cur = cur.getNext();
        }
        cur.setNext(cur.getNext().getNext());
    }
}
