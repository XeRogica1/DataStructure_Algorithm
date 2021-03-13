package tree.avltree;

public class AVLTreeTest {
    public static void main(String[] args) {
/*        4                          6
         / \                        / \
        3   6                      4   7
           / \                    / \  \
          5   7                  3  5   8
               \
               8
*/
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTree avl = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avl.add(new Node(arr[i]));
        }
        avl.infixOrder();
        System.out.println("---------------");
        System.out.println("处理树的高度:" + avl.getRoot().height());
        System.out.println("左树的高度:" + avl.getRoot().leftHeight());
        System.out.println("右树的高度:" + avl.getRoot().rightHeight());
        System.out.println("根节点为" + avl.getRoot());
    }
}
