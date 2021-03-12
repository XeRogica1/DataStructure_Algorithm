package huffmancode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HuffmanCodeTest {
    public static void main(String[] args) {
        //String str = "i like like like java do you like a java";
        String str = "hello world";

        //将string转换为byte数组
        byte[] strBytes = str.getBytes();
        //将byte数组转换为node集合
        List<HuffmanNode> nodeList = HuffmanCodeTree.getNodes(strBytes);
        //根据集合创建赫夫曼树
        HuffmanNode root = HuffmanCodeTree.createHuffmanTree(nodeList);
        //通过赫夫曼树根节点生成赫夫曼编码表
        Map<Byte, String> codeMap = HuffmanCode.getCodes(root);
/*
        System.out.println("赫夫曼编码表");
        System.out.println(codeMap);
        //将字符串的byte数组通过赫夫曼编码表转换为压缩后的byte数组
        byte[] compressedBytes = HuffmanCode.compressBytes(strBytes,codeMap);
        System.out.println("压缩后的byte数组");
        System.out.println(Arrays.toString(compressedBytes));
*/
        //封装后
        byte[] bytes = HuffmanCode.huffmanCompress(str);
        System.out.println(str);
        System.out.println("压缩为");
        System.out.println(Arrays.toString(bytes));

        //解码
        System.out.println("重新解码");
        String resStr = HuffmanCode.huffmanDecompress(bytes, codeMap);
        System.out.println(resStr);
    }
}
