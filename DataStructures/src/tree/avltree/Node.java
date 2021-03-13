package tree.avltree;

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

        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.getRight() != null && this.getRight().rightHeight() < this.getRight().leftHeight()){
                this.getRight().rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        if (this.leftHeight() - this.rightHeight() > 1) {
            //一个节点的左子树的右子树高度大于其左子树的高度时，要先对当前节点左节点进行左旋转，再对当前节点进行右旋转
            if (this.getLeft() != null && this.getLeft().rightHeight() > this.getLeft().leftHeight()){
                this.getLeft().leftRotate();
                rightRotate();
            }else {
                //否则直接右旋转
                rightRotate();
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

    //返回以当前节点为根节点树的高度
    public int height() {
        //左(右)子树为空则为0，否则递归
        //取左右子树中较大的值
        //+1算上当前节点
        return Math.max(this.getLeft() == null ? 0 : this.getLeft().height(),
                this.getRight() == null ? 0 : this.getRight().height()) + 1;
    }

    //返回左子树高度
    public int leftHeight() {
        if (this.getLeft() == null) {
            return 0;
        } else {
            return this.getLeft().height();
        }
    }

    //返回右子树的高度
    public int rightHeight() {
        if (this.getRight() == null) {
            return 0;
        } else {
            return this.getRight().height();
        }
    }

    //左旋转
    public void leftRotate() {
        //创建一个新节点，值等于当前节点的根节点
        Node temp = new Node(this.getValue());
        //把新节点的左子树设置为当前节点的左子树
        temp.setLeft(this.getLeft());
        //把新节点的右子树设置为当前节点右子树的左子树
        temp.setRight(this.getRight().getLeft());
        //把当前节点替换为右子节点的值
        this.setValue(this.getRight().getValue());
        //把当前节点右子树设置为右子树的右子树
        this.setRight(this.getRight().getRight());
        //把当前节点的左子树设置为新节点
        this.setLeft(temp);

    }

    //右旋转
    //左旋转
    public void rightRotate() {
        Node temp = new Node(this.getValue());
        temp.setRight(this.getRight());
        temp.setLeft(this.getLeft().getRight());
        this.setValue(this.getLeft().getValue());
        this.setLeft(this.getLeft().getLeft());
        this.setRight(temp);

    }
}
