package kruskal;

import java.util.Arrays;

public class KruskalAlgorithm {

    public static void main(String[] args) {
/*         B———8————C
         / \       /|\
      12/  7\   6/ |  \3
       /     \ /   |   \
     A———16———F    5    D
     \      / \   |   /
    14\   9/  2\ | 4/
       \ /      \|/
        G———8————E
    修路保证ABCDEFG连通，且总路程最小
    从A开始
    F-E 2
    C-D 3
    D-E 4
    B-F 7
    E-G 8
    A-B 12
*/
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {0, 12, 100, 100, 100, 16, 14},
                {12, 0, 10, 100, 100, 7, 100},
                {100, 10, 0, 3, 5, 6, 100},
                {100, 100, 3, 0, 4, 100, 100},
                {100, 100, 5, 4, 0, 2, 8},
                {16, 7, 6, 100, 2, 0, 9},
                {14, 100, 100, 100, 8, 9, 0}};
        Graph graph = new Graph(vertex, weight);
        graph.print();
        //获取所有边
        System.out.println("所有边");
        Edge[] e = graph.getEdges();
        System.out.println(Arrays.toString(e));
        System.out.println("排序后的边");
        Arrays.sort(e);
        System.out.println(Arrays.toString(e));
        System.out.println("算法结果");
        graph.kruskal();
    }
}
