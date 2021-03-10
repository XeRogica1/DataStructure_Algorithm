package tree.binarytree;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("该树为空");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("该树为空");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("该树为空");
        }
    }

    //前序查找
    public Node preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);

        } else {
            System.out.println("该树为空");
            return null;
        }
    }

    //中序查找
    public Node infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);

        } else {
            System.out.println("该树为空");
            return null;
        }
    }

    //后序查找
    public Node postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            System.out.println("该树为空");
            return null;
        }
    }

    //删除节点
    public void removeNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.removeNode(no);
            }
        } else {
            System.out.println("二叉树为空");
        }
    }
}
