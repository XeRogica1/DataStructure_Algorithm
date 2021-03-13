package tree.avltree;

public class AVLTreeTest3 {
    public static void main(String[] args) {
/*         10            10             8
          / \           / \            / \
         7  11         8  11          7  10
        / \           / \            /   / \
       6   8         7  9           6   9  11
           \        /
            9      6
*/
        int[] arr = {10,11,7,6,8,9};
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
