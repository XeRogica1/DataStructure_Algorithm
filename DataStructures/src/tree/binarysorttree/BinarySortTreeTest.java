package tree.binarysorttree;

public class BinarySortTreeTest {
    public static void main(String[] args) {
 /*             7
              /  \
             3   10
           /  \  / \
          1   5 9  12
          \  / /    \
          2 4 8     13
*/

        int[] arr = {7,3,10,12,5,1,9,2,4,8,13};
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            bst.add(new Node(arr[i]));
        }
        bst.infixOrder();

        bst.removeNode(7);
        System.out.println("删除后");
        bst.infixOrder();
    }
}
