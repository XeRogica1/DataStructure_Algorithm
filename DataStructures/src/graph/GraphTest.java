package graph;

public class GraphTest {
    public static void main(String[] args) {
/*           0
            / \
           1   2
         / |  / \
       3   4 5 - 6
       \  /
        7
       /
      8
    深度优先遍历：0->1->3->7->4->8->2->5->6
    广度优先遍历：0->1->2->3->4->5->6->7->8
*/
        int n = 9;
        Graph graph = new Graph(n);
        String[] vertexs = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        //添加节点
        for (int i = 0; i < vertexs.length; i++) {
            graph.insertVertex(vertexs[i]);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(7, 8, 1);
        //显示邻接矩阵
        graph.showGraph();
        //深度优先遍历
        System.out.println("DFS");
        graph.DFS();
        //广度优先遍历
        System.out.println();
        System.out.println("BFS");
        graph.BFS();
    }
}
