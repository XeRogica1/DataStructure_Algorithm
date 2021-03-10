package tree.threadedbinarytree;

/*    1
     / \
    3   6
  / \  /
 8 10 14
中序遍历的结果是8,3,10,1,14,6
 */
public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        //创建线索二叉树
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        //创建节点
        Node root = new Node(1, "a");
        Node node1 = new Node(3, "b");
        Node node2 = new Node(6, "c");
        Node node3 = new Node(8, "d");
        Node node4 = new Node(10, "e");
        Node node5 = new Node(14, "f");
        //手动创建数
        threadedBinaryTree.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        //中序线索化
        threadedBinaryTree.threadedNode();
        //测试
        //线索化后10节点的左节点应为3
        Node left = node4.getLeft();
        System.out.println("前驱节点为" + left);
        //线索化后10节点的右节点应为1
        Node right = node4.getRight();
        System.out.println("后继节点为" + right);
        //遍历线索化后的二叉树
        threadedBinaryTree.threadedShow();

    }
}
