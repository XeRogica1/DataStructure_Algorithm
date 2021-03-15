package prim;

import java.util.Arrays;

public class MiniTree {
    /**
     * 创建最小生成树
     *
     * @param graph     图对象
     * @param vertexNum 图的顶点个数
     * @param data      图的各个顶点的值
     * @param weight    图的邻接矩阵
     */
    public void createGraph(PGraph graph, int vertexNum, char[] data, int[][] weight) {
        for (int i = 0; i < vertexNum; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertexNum; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(PGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 普利姆算法求最小生成树
     *
     * @param graph 图
     * @param v     从哪个顶点开始
     */
    public void prim(PGraph graph, int v) {
        //标记该节点是否已访问
        boolean[] visited = new boolean[graph.vertexNum];
        //把当前节点标记为已访问
        visited[v] = true;
        //记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        //初始为较大值，后面会被替换
        int minWeight = 100;
        //有vertexNum个顶点，则有vertexNum-1条边
        for (int k = 1; k < graph.vertexNum; k++) {

            for (int i = 0; i < graph.vertexNum; i++) {//i节点表示被访问过的节点
                if (visited[i]) {//i已访问
                    for (int j = 0; j < graph.vertexNum; j++) {//j节点表示未被访问过得节点
                        //j未访问，ij之间的权值小于最小权值
                        if (!visited[j] && graph.weight[i][j] < minWeight) {
                            minWeight = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                        }
                    }
                }
            }
            //找到一条最小的边
            System.out.println("<" + graph.data[h1] + "," + graph.data[h2] + ">的边权值为" + minWeight);
            //将找到的新节点设为已访问
            visited[h2] = true;
            //重置minWeight
            minWeight = 100;
        }
    }
}
