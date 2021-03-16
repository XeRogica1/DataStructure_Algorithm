package dijkstra;

import java.util.Arrays;

//已访问的顶点集合
public class VisitedVertex {
    //记录该顶点是否访问
    public boolean[] isVisited;
    //记录该顶点的前一个顶点下标
    public int[] preVisited;
    //记录该顶点到其他各顶点的距离
    public int[] distance;

    //length表示顶点个数，index表示出发顶点的下标
    public VisitedVertex(int num, int index) {
        this.isVisited = new boolean[num];
        this.preVisited = new int[num];
        this.distance = new int[num];
        //当前顶点到其他顶点距离设默认值为最大
        Arrays.fill(distance, 100);
        //当前顶点到自身的距离为0
        this.distance[index] = 0;
    }

    //更新距离数组
    public void updateDistance(int index, int length) {
        distance[index] = length;
    }

    //更新前驱节点数组
    public void updatePre(int index, int pre) {
        preVisited[index] = pre;
    }

    //返回出发顶点到下标顶点的距离
    public int getDistance(int index) {
        return distance[index];
    }

    //选择新的顶点
    public int getNext() {
        int min = 100, index = 0;
        for (int i = 0; i < isVisited.length; i++) {
            //如果新的节点i未被访问过且连通
            if (!isVisited[i] && distance[i] < min) {
                //置为新的节点
                min = distance[i];
                index = i;
            }
        }
        //更新新的顶点为已访问
        isVisited[index]=true;
        return index;
    }
}
