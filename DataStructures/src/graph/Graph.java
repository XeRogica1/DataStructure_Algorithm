package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点的集合
    private int edgeNum;//边的数量
    private int[][] edges;//存储图的邻接矩阵
    private boolean[] isVisited;//布尔数组表示该节点是否访问

    //构造器，n为顶点个数
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        isVisited = new boolean[n];
        edgeNum = 0;
    }

    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     顶点1(第几个顶点)
     * @param v2     顶点2
     * @param weight 边的权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeNum++;
    }

    //返回图中顶点的个数
    public int getVertexNum() {
        return vertexList.size();
    }

    //返回边的个数
    public int getEdgeNum() {
        return edgeNum;
    }

    //返回对应下标的顶点
    public String getVertex(int index) {
        return vertexList.get(index);
    }

    //返回两个顶点之间的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的矩阵
    public void showGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }

    //得到下一个邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            //存在则返回对应下表，不存在则返回-1
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接节点下标获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    //针对一个节点的深度优先遍历
    public void DFS(boolean[] isVisited, int i) {
        //访问当前节点
        System.out.print(getVertex(i) + "->");
        //将当前节点设置为已访问
        isVisited[i] = true;
        //查找i的第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1) {//有邻接节点
            //未被访问则递归
            if (!isVisited[w]) {
                DFS(isVisited, w);
            }
            //已经被访问，则查找下一个邻接节点
            w = getNextNeighbor(i, w);
        }
    }

    //重载，遍历所有节点进行DFS
    public void DFS() {
        //现将是否访问数组置空
        for (int i = 0; i < vertexList.size(); i++) {
            isVisited[i] = false;
        }
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                DFS(isVisited, i);
            }
        }
    }

    //针对一个节点的广度优先遍历
    public void BFS(boolean[] isVisited, int i) {
        int u;//队列头节点对应的下标
        int w;//节点邻接节点的下标
        LinkedList<Integer> queue = new LinkedList<>();//队列
        //输出节点
        System.out.print(getVertex(i) + "->");
        //标记为已访问
        isVisited[i] = true;
        //加入队列
        queue.addLast(i);
        //当队列非空，取出队列
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            //有邻接节点
            while (w != -1) {
                //未访问
                if (!isVisited[w]) {
                    System.out.print(getVertex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //访问过，找u在w后的下一个邻接节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    //重载，遍历所有节点进行广度优先
    public void BFS() {
        //现将是否访问数组置空
        for (int i = 0; i < vertexList.size(); i++) {
            isVisited[i] = false;
        }
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                BFS(isVisited, i);
            }
        }
    }
}
