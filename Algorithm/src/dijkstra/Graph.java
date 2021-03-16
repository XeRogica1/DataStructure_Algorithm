package dijkstra;


import java.util.Arrays;

public class Graph {
    char[] vertex;//节点数据
    int[][] matrix;//存放边的邻接矩阵

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //index出发顶点
    public void dijkstra(int index) {
        VisitedVertex vv = new VisitedVertex(vertex.length, index);
        update(index, vv);
        for (int i = 0; i < vertex.length; i++) {
            //选择新的访问顶点
            index = vv.getNext();
            update(index,vv);
        }
        //输出结果
        System.out.println(Arrays.toString(vv.distance));
    }

    //修改已访问顶点的信息(是否访问，到各点距离，前驱节点)
    public void update(int index, VisitedVertex vv) {
        int len = 0;
        //从邻接矩阵中找到出发顶点对应的一行开始遍历
        for (int i = 0; i < matrix[index].length; i++) {
            //距离为已有距离加上顶点到其他顶点的总距离
            len = vv.getDistance(index) + matrix[index][i];
            //如果i没被访问过，并且总距离小于出发顶点到i顶点的总距离
            if (!vv.isVisited[i] && len < vv.getDistance(i)) {
                //更新前驱顶点和距离
                vv.updatePre(i, index);
                vv.updateDistance(i, len);
                vv.isVisited[index]=true;
            }
        }
    }

}
