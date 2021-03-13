package huffmancode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
    //赫夫曼编码表存放在Map<Byte,String>中
    static Map<Byte, String> codeMap = new HashMap<>();
    //赫夫曼编码需要拼接路径，创建StringBuilder
    static StringBuilder code = new StringBuilder();

    //将节点转换为赫夫曼编码，并放入到集合中

    /**
     * @param node 节点
     * @param path 路径，左子节点为0，右子节点为1
     * @param code 拼接路径
     */
    public static Map<Byte, String> getCodes(HuffmanNode node, String path, StringBuilder code) {
        StringBuilder codex = new StringBuilder(code);
        codex.append(path);
        if (node != null) {
            //非叶子节点
            if (node.getValue() == null) {
                //向左递归
                getCodes(node.getLeft(), "0", codex);
                //向右
                getCodes(node.getRight(), "1", codex);
            } else {
                //是叶子节点，直接加入map中
                codeMap.put(node.getValue(), codex.toString());
            }
        }
        return codeMap;
    }

    //重载
    public static Map<Byte, String> getCodes(HuffmanNode root) {

        return getCodes(root, "", code);
    }

    //通过赫夫曼编码表将byte数组变为压缩后的byte数组
    public static byte[] compressBytes(byte[] bytes, Map<Byte, String> codeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        //将字符串数组通过赫夫曼编码转换为被压缩的字符串
        for (byte b : bytes) {
            stringBuilder.append(codeMap.get(b));
        }

        //将压缩后的二进制字符串转换为byte数组
        //获得byte数组的长度
        //可以(stringBuilder.length()+7)/8
        int len;
        //如果字符串长度是八的整数倍则数组长度为长度/8
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            //不是则+1
            len = stringBuilder.length() / 8 + 1;
        }
        //创建压缩后的byte数组
        byte[] compressedBytes = new byte[len];
        //byte数组下标
        int index = 0;
        //每8位为一个byte
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            //截取8位转换为byte存储到数组中
            if (i + 8 > stringBuilder.length()) {
                //不足八位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            compressedBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return compressedBytes;
    }

    //封装将字符串转换成压缩后的数组
    public static byte[] huffmanCompress(byte[] bytes) {
        //数组转为赫夫曼节点集合
        List<HuffmanNode> nodeList = HuffmanCodeTree.getNodes(bytes);
        //通过赫夫曼节点集合构建赫夫曼树
        HuffmanNode root = HuffmanCodeTree.createHuffmanTree(nodeList);
        //通过赫夫曼树将数组转换为赫夫曼编码
        Map<Byte, String> codeMap = getCodes(root);
        //通过赫夫曼编码压缩数组
        return compressBytes(bytes, codeMap);
    }


    /**
     * 将byte数组转换为二进制字符串
     *
     * @param b    要转换的byte
     * @param flag 是否需要补高位，最后一个byte数不需要补高位
     * @return 二进制字符串
     */
    public static String byteToBitString(byte b, boolean flag) {
        //临时整数变量保存byte
        int temp = b;
        //正数需要补高位
        if (flag) {
            //按位与256
            temp |= 256;
        }
        //返回补码
        String str = Integer.toBinaryString(temp);
        if (flag || temp < 0) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    //解码，将压缩后的byte数组转换为原来的字符串
    public static byte[] huffmanDecompress(byte[] bytes, Map<Byte, String> codeMap) {
        //拼接每一个byte数转换的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            //判断是不是最后一个字节，是则不需要补高位
            boolean flag = (i == bytes.length - 1);
            stringBuilder.append(byteToBitString(bytes[i], !flag));
        }

        //将赫夫曼编码表调换为反向查询的表
        Map<String, Byte> reverseCodeMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : codeMap.entrySet()) {
            reverseCodeMap.put(entry.getValue(), entry.getKey());
        }

        //创建集合存放byte
        List<Byte> byteList = new ArrayList<>();
        //i是扫描二进制字符串的指针
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //取出1或0，同时将字符串截取
                //i不动，count进行移动，直到截取出匹配的编码
                String key = stringBuilder.substring(i, i + count);
                //在编码表中查找是否有匹配数据，如果匹配返回对应byte，如果不对返回null
                b = reverseCodeMap.get(key);

                if (b == null) {
                    //没有匹配到，则count移动
                    count++;
                } else {
                    //匹配到退出循环
                    flag = false;
                }
            }
            //将匹配到的byte加入集合
            byteList.add(b);
            //至臻直接增长到count位置
            i += count;
        }
        //将byte集合转换为数组
        byte[] resBytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            resBytes[i] = byteList.get(i);
        }
        return resBytes;
    }

    /**
     * 压缩文件
     *
     * @param srcFile  待压缩文件的全路径
     * @param destFile 压缩文件的存储路径
     */
    public static void compressFile(String srcFile, String destFile) {
        //自动关闭IO流
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(destFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            //读取文件
            byte[] b = new byte[fis.available()];
            fis.read(b);
            //对源文件进行压缩
            byte[] compressedFile = huffmanCompress(b);
            //把压缩后的数组与赫夫曼编码写入压缩文件中
            oos.writeObject(compressedFile);
            oos.writeObject(codeMap);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 将文件解压缩
     *
     * @param srcFile  压缩文件的路径
     * @param destFile 解压缩后文件的路径
     */
    public static void decompresseFile(String srcFile, String destFile) {
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(destFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            //读取数组文件
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取编码表
            Map<Byte,String> codeMap = (Map<Byte, String>) ois.readObject();
            //解码
            byte[] b= huffmanDecompress(huffmanBytes,codeMap);
            fos.write(b);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
