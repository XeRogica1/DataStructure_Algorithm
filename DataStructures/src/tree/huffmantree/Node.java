package tree.huffmantree;

//让node节点对象能够排序，实现comparable接口
public class Node implements Comparable<Node> {
    private int value;//权值
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.getValue() - o.getValue();
    }

    //前序遍历
    public void preOrder() {
        //先输出当前节点
        System.out.println(this);
        //左不为空，递归遍历左
        if (this.left != null) {
            this.left.preOrder();
        }
        //右不为空，递归遍历右
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
