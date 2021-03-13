package huffmancode;

public class HuffmanCodeTest02 {
    public static void main(String[] args) {
        String srcFile = "Algorithm/resources/source/mdr.png";
        String destFile = "Algorithm/resources/result/mdr-compressed.zip";
        HuffmanCode.compressFile(srcFile, destFile);
        System.out.println("压缩文件成功");


        String srcFile1 = "Algorithm/resources/result/mdr-compressed.zip";
        String destFile1 = "Algorithm/resources/result/mdr-decompressed.png";
        HuffmanCode.decompresseFile(srcFile1, destFile1);
        System.out.println("解压文件成功");
    }
}
