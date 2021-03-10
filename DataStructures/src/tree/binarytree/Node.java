package tree.binarytree;

public class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
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

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public Node preOrderSearch(int no) {
        System.out.println("前序查找一次");
        //与当前节点比较
        if (this.no == no) {
            return this;
        }
        //向左递归查找
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        //如果左侧找到就返回，不会再继续向右查找
        if (resNode != null) {
            return resNode;
        }
        //向右递归查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序查找
    public Node infixOrderSearch(int no) {
        //向左递归查找
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        //如果左侧找到就返回，不会再继续向右查找
        if (resNode != null) {
            return resNode;
        }
        System.out.println("中序查找一次");
        //与当前节点比较
        if (this.no == no) {
            return this;
        }
        //向右递归查找
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //后序查找
    public Node postOrderSearch(int no) {
        //向左递归查找
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        //如果左侧找到就返回，不会再继续向右查找
        if (resNode != null) {
            return resNode;
        }
        //向右递归查找
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        //如果右侧找到就返回，不会再继续找父节点
        if (resNode != null) {
            return resNode;
        }
        System.out.println("后序查找一次");
        //与当前节点比较
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //删除节点
    public void removeNode(int no) {
        //左节点不为空且为要删除节点，则置空并返回
        if (this.left != null && this.left.getNo() == no) {
            this.left = null;
            return;
        }
        //右节点不为空且为要删除节点，则置空并返回
        if (this.right != null && this.right.getNo() == no) {
            this.right = null;
            return;
        }
        //向左节点递归删除
        if (this.left != null) {
            this.left.removeNode(no);
        }
        //向右节点递归删除
        if (this.right != null) {
            this.right.removeNode(no);
        }
    }
}
