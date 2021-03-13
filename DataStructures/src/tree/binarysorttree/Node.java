package tree.binarysorttree;

public class Node {
    private int value;
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

    //以二叉排序树形式添加节点
    public void add(Node node) {
        //判断为空
        if (node == null) {
            return;
        }
        //判断添加节点与当前节点的值关系
        if (node.getValue() < this.getValue()) {
            //左子节点为空则添加
            if (this.getLeft() == null) {
                this.setLeft(node);
            } else {
                //不为空则递归
                this.getLeft().add(node);
            }
        } else {
            if (this.getRight() == null) {
                this.setRight(node);
            } else {
                this.getRight().add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.getLeft() != null) {
            this.getLeft().infixOrder();
        }
        System.out.println(this);
        if (this.getRight() != null) {
            this.getRight().infixOrder();
        }
    }

    //找到要删除节点
    public Node search(int value) {
        if (value == this.getValue()) {
            //相等返回当前节点
            return this;
        } else if (value < this.getValue()) {
            if (this.getLeft() == null) {
                return null;
            }
            //小于向左递归
            return this.getLeft().search(value);
        } else {
            if (this.getRight() == null) {
                return null;
            }
            //大于向右递归
            return this.getRight().search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.getLeft() != null && this.getLeft().getValue() == value) ||
                (this.getRight() != null && this.getRight().getValue() == value)) {
            return this;
        } else {
            if (value < this.getValue() && this.getLeft() != null) {
                return this.getLeft().searchParent(value);
            } else if (value >= this.getValue() && this.getRight() != null) {
                return this.getRight().searchParent(value);
            } else {
                return null;
            }
        }
    }
}
