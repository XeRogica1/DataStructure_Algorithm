package hashtable;

import java.util.Scanner;

public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        String key = "";
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("-------------");
            System.out.println("add,添加员工");
            System.out.println("show,显示员工");
            System.out.println("find,查找员工");
            System.out.println("remove,删除员工");
            System.out.println("exit,退出");
            key = s.next();
            switch (key) {
                case "add":
                    System.out.println("输入id与名字");
                    int id = s.nextInt();
                    String name = s.next();
                    //创建员工
                    Employee emp = new Employee(id, name);
                    //添加员工
                    hashTable.add(emp);
                    break;
                case "show":
                    hashTable.show();
                    break;
                case "find":
                    System.out.println("输入要查找的id");
                    id = s.nextInt();
                    hashTable.findById(id);
                    break;
                case "remove":
                    System.out.println("输入要删除的id");
                    id = s.nextInt();
                    hashTable.remove(id);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
