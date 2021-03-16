package kruskal;

import java.util.Arrays;

public class Graph {
    int edgeNum;//边个数
    char[] vertex;//节点数据
    int[][] weight;//存放边的邻接矩阵

    public Graph(char[] vertex, int[][] weight) {
        this.vertex = vertex;
        this.weight = weight;
        for (int i = 0; i < weight.length; i++) {
            for (int j = i + 1; j < weight[i].length; j++) {
                if (weight[i][j] != 100) {
                    edgeNum++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[i].length; j++) {
                System.out.print(weight[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    //返回顶点对应的下标
    public int getVertexIndex(char v) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == v) {
                return i;
            }
        }
        return -1;
    }

    //获取所有边的数据
    public Edge[] getEdges() {
        int index = 0;
        Edge[] edges = new Edge[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (weight[i][j] != 100) {
                    edges[index] = new Edge(vertex[i], vertex[j], weight[i][j]);
                    index++;
                }
            }
        }
        return edges;
    }

    //动态获取下标为i顶点当前的重点，用于判断两个顶点是否指向同一个终点，从而判断是否产生回路
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        //结果数组的索引
        int index = 0;
        //已有最小生成树每个顶点的终点
        int[] ends = new int[vertex.length];
        //最小生成树结果
        Edge[] res = new Edge[vertex.length - 1];
        //所有边的数组，排序
        Edge[] edges = getEdges();
        Arrays.sort(edges);
        //遍历数组，将变添加到最小生成树中，同时判断会不会构成回路
        for (int i = 0; i < edgeNum; i++) {
            //p1p2分别代表当前边的两个顶点下标
            int p1 = getVertexIndex(edges[i].start);
            int p2 = getVertexIndex(edges[i].end);
            //获取p1p2在已有最小生成树中的终点下标
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            //终点相等则构成回路
            if (m != n) {
                //设置顶点m的终点是n
                ends[m] = n;
                res[index] = edges[i];
                index++;
            }
        }
        //输出最小生成树结果
        System.out.println(Arrays.toString(res));
    }
}
