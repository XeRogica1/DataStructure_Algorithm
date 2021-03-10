package tree.binarytree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        //创建二叉树
        /*  1a
           /  \
          2b  3c
             /  \
            5e  4d*/
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        Node root = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node5 = new Node(5, "e");
        //手动添加节点
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();//前序遍历1,2,3,5,4
        System.out.println("中序遍历");
        binaryTree.infixOrder();//中序遍历2,1,5,3,4
        System.out.println("后序遍历");
        binaryTree.postOrder();//后序遍历2,5,4,3,1
        //查找
        Node res = binaryTree.preOrderSearch(5);
        System.out.println("前序查找找到" + res);

        res = binaryTree.infixOrderSearch(5);
        System.out.println("后序查找找到" + res);

        res = binaryTree.postOrderSearch(5);
        System.out.println("后序查找找到" + res);
        //删除
        System.out.println("删除前");
        binaryTree.preOrder();
        System.out.println("删除后");
        binaryTree.removeNode(5);
        binaryTree.preOrder();

    }
}
