package tree.threadedbinarytree;


public class ThreadedBinaryTree {
    private Node root;
    //指向当前节点前驱节点的指针
    private Node pre = null;


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //对二叉树进行线索化
    //node是需要线索化的节点
    public void threadedNode(Node node) {
        //节点为空无法线索化
        if (node == null) {
            return;
        }
        //线索化左子树
        threadedNode(node.getLeft());
        //线索化当前节点
        //当前节点左指针为空
        if (node.getLeft() == null) {
            //指向前驱节点
            node.setLeft(pre);
            //修改类型
            node.setLeftType(1);
        }
        //当前节点右指针为空
        if (pre != null && pre.getRight() == null) {
            //此时pre实际为当前节点，node实际为后继节点
            //指向后继节点
            pre.setRight(node);
            //修改类型
            pre.setRightType(1);
        }
        //保存当前节点为下一个节点的前驱节点
        pre = node;

        //线索化右子树
        threadedNode(node.getRight());
    }

    //重载
    public void threadedNode() {
        this.threadedNode(root);
    }

    //遍历线索化二叉树
    public void threadedShow() {
        //定义指向当前节点的指针
        Node cur = root;
        while (cur != null) {
            //找到中序遍历的第一个节点，也就是左指针指向前驱节点的节点
            while (cur.getLeftType() != 1) {
                cur = cur.getLeft();
            }
            //输出这个节点
            System.out.println(cur);
            //该节点右节点是后续节点就继续输出
            while (cur.getRightType() == 1) {
                cur = cur.getRight();
                System.out.println(cur);
            }
            //当发现右节点不是后续节点的节点，替换为当前节点
            cur = cur.getRight();
        }

    }
}
