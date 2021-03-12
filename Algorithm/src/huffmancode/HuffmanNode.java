package huffmancode;

public class HuffmanNode implements Comparable<HuffmanNode> {
    private Byte value;//字符
    private int weight;//权值，字符出现的次数
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(Byte value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.getWeight() - o.getWeight();
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.getLeft() != null) {
            this.getLeft().preOrder();
        }
        if (this.getRight() != null) {
            this.getRight().preOrder();
        }
    }
}
