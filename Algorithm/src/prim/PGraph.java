package prim;

public class PGraph {
    int vertexNum;//节点个数
    char[] data;//节点数据
    int[][] weight;//存放边的邻接矩阵

    public PGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        data =new char[vertexNum];
        weight = new int[vertexNum][vertexNum];
    }
}
