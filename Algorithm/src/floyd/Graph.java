package floyd;

import java.util.Arrays;

public class Graph {
    char[] vertex;//顶点数组
    int[][] distance;//存放顶点到其他顶点的距离
    char[][] pre;//存放前驱顶点的下标

    public Graph(char[] vertex, int[][] distance) {
        this.vertex = vertex;
        this.distance = distance;
        this.pre = new char[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            Arrays.fill(pre[i], vertex[i]);
        }
    }

    //显示distance和pre数组
    public void print() {
        System.out.println("各点到其他顶点的距离");
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                System.out.print(distance[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("各点到其他顶点的前驱顶点");
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[i].length; j++) {
                System.out.print(pre[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //弗洛伊德算法
    public void floyd() {
        int len = 0;//保存距离的变量
        //k为中间节点
        for (int k = 0; k < vertex.length; k++) {
            //i为起始节点
            for (int i = 0; i < vertex.length; i++) {
                //j为终点节点
                for (int j = 0; j < vertex.length; j++) {
                    //求出ij通过中间节点k的距离
                    len = distance[i][k] + distance[k][j];
                    //如果借助中间节点距离小于直连距离，那么更新距离与前驱顶点
                    if (len < distance[i][j]) {
                        distance[i][j] = len;
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
