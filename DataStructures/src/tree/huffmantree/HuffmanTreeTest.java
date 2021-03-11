package tree.huffmantree;

public class HuffmanTreeTest {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node huffmanTreeRoot = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(huffmanTreeRoot);
    }
}
