package huffmancode;

import java.util.*;

public class HuffmanCodeTree {
    //将byte数组构建有序节点集合
    public static List<HuffmanNode> getNodes(byte[] bytes) {
        List<HuffmanNode> nodeList = new ArrayList<>();
        //创建Map，key存放byte值，value存放出现次数
        Map<Byte, Integer> byteMap = new HashMap<>();

        //遍历byte数组
        for (Byte b : bytes) {
            Integer count = byteMap.get(b);
            //如果map中不包含该元素则放入
            if (!byteMap.containsKey(b)) {
                byteMap.put(b, 1);
            } else {
                //有则出现次数value+1
                byteMap.put(b, count + 1);
            }
        }

        //遍历map
        for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()
        ) {
            //将键和值构建节点，并加入节点集合
            nodeList.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return nodeList;
    }


    //通过list构建对应赫夫曼树
    public static HuffmanNode createHuffmanTree(List<HuffmanNode> nodeList) {
        while (nodeList.size() > 1) {
            //对集合排序
            Collections.sort(nodeList);
            //前两个节点分别为左右叶子节点
            HuffmanNode left = nodeList.get(0);
            HuffmanNode right = nodeList.get(1);
            //创建新的节点，该节点没有数据value，只有权值
            HuffmanNode newNode = new HuffmanNode(null, left.getWeight() + right.getWeight());
            newNode.setLeft(left);
            newNode.setRight(right);
            //移除处理过的节点，加入新的节点
            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(newNode);
        }
        //返回根节点
        return nodeList.get(0);
    }

    //前序遍历
    public static void preOrder(HuffmanNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }
}
