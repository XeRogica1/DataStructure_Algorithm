package hashtable;

public class HashTable {
    private EmpLinkedList[] empLinkedListArr;
    private int size;//表示有多少条链表

    public HashTable(int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];
        //初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    //取模法散列函数
    public int hash(int id) {
        return id % size;
    }

    //添加员工
    public void add(Employee emp) {
        //根据员工id确定哪一条链表
        int empLinkedListNum = hash(emp.getId());
        //添加emp到对应链表
        empLinkedListArr[empLinkedListNum].add(emp);
    }

    //遍历链表
    public void show() {
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].show(i);
        }
    }

    //查找员工
    public void findById(int id) {
        int empLinkedListNum = hash(id);
        Employee emp = empLinkedListArr[empLinkedListNum].findById(id);
        if (emp != null) {
            System.out.println("在" + empLinkedListNum + "链表中找到员工" + emp);
            return;
        } else {
            System.out.println("未找到id为" + id + "的员工");
            return;
        }
    }

    //删除员工
    public void remove(int id) {
        int empLinkedListNum = hash(id);
        empLinkedListArr[empLinkedListNum].remove(id);
    }
}
