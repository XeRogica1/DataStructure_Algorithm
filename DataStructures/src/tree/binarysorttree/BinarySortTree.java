package tree.binarysorttree;

public class BinarySortTree {
    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //添加节点
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root == null) {
            System.out.println("二叉排序树为空");
        } else {
            root.infixOrder();
        }
    }

    //查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            System.out.println("二叉排序树为空");
            return null;
        }
        return root.search(value);
    }

    //查找删除节点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            System.out.println("二叉排序树为空");
            return null;
        }
        return root.searchParent(value);
    }

    //返回以node为根节点二叉排序树的最小值，并删除该最小值的节点
    public int removeMin(Node node) {
        Node temp = node;
        //循环查找左节点就能找到最小值
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        //删除该最小节点
        removeNode(temp.getValue());
        return temp.getValue();
    }

    //删除节点
    public void removeNode(int value) {
        //root为空
        if (root == null) {
            return;
        }
        //root为唯一节点
        if (root.getLeft() == null && root.getRight() == null) {
            root = null;
            return;
        }
        Node targetNode = search(value);
        //没有找到要删除节点
        if (targetNode == null) {
            return;
        }
        Node parent = searchParent(value);


        if (targetNode.getLeft() == null && targetNode.getRight() == null) {//删除节点是叶子节点
            if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
                parent.setLeft(null);
            } else if (parent.getRight() != null && parent.getRight().getValue() == value) {
                parent.setRight(null);
            }
        } else if (targetNode.getLeft() != null && targetNode.getRight() != null) {//删除节点有两个子节点
            //返回以删除节点为根节点二叉排序树的最小值，并删除该最小值的节点
            int min = removeMin(targetNode.getRight());
            //删除节点赋值为最小值
            targetNode.setValue(min);
        } else {//删除节点有一个子节点
            if (targetNode.getLeft() != null) {//有左子节点
                if (parent == null) {
                    root = targetNode.getLeft();
                    return;
                }
                if (parent.getLeft().getValue() == value) {
                    //删除节点是父节点的左节点
                    parent.setLeft(targetNode.getLeft());
                } else if (parent.getRight().getValue() == value) {
                    //删除节点是父节点的右接地那
                    parent.setRight(targetNode.getLeft());
                }
            } else if (targetNode.getRight() != null) {//有右子节点
                if (parent == null) {
                    root = targetNode.getRight();
                    return;
                }
                if (parent.getLeft().getValue() == value) {
                    //删除节点是父节点的左节点
                    parent.setLeft(targetNode.getRight());
                } else if (parent.getRight().getValue() == value) {
                    //删除节点是父节点的右接地那
                    parent.setRight(targetNode.getRight());
                }
            }
        }
    }
}
