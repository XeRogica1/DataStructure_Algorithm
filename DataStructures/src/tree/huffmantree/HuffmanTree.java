package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    //创建哈夫曼树
    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodeList = new ArrayList<>();
        //遍历数组，将数组元素构建节点，并将节点放入ArrayList
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            nodeList.add(node);
        }
        //当list中只有一个值代表构建完成
        while (nodeList.size() > 1) {
            //使用集合工具包排序
            Collections.sort(nodeList);
            //取出权值最小的两个节点组成二叉树
            Node left = nodeList.get(0);
            Node right = nodeList.get(1);
            Node newNode = new Node(left.getValue() + right.getValue());
            newNode.setLeft(left);
            newNode.setRight(right);
            //从list中删除处理过的节点并把新的节点加入
            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(newNode);
        }
        //返回赫夫曼树的根节点
        return nodeList.get(0);
    }

    //前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("该树为空");
        }
    }
}
