package tree.arraybinarytree;

public class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //将数组顺序存储二叉树
    //前序遍历存储
    //index是节点对于二叉树的第几个元素，也就是数组的下标
    public void preOrder(int index) {
        //判断数组
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //输出当前节点的数
        System.out.println(arr[index]);
        //向左递归
        if (index * 2 + 1 < arr.length) {
            preOrder(index * 2 + 1);
        }
        //向右递归
        if (index * 2 + 2 < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
    //重载
    public void preOrder(){
        preOrder(0);
    }
}
