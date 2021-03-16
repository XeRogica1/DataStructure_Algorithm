package dijkstra;

import java.util.Arrays;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
/*         A———8————B
         / \       / \
       7/  2\   3/    \9
       /     \ /       \
     C       G         D
     \      / \       /
     8\   4/  6\   4/
       \ /      \ /
        E———5————F
    A-B 5
    A-C 7
    A-D 12
    A-E 6
    A-F 8
    A-G 2
*/
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {100, 5, 7, 100, 100, 100, 2},
                {5, 100, 100, 9, 100, 100, 3},
                {7, 100, 100, 100, 8, 100, 100},
                {100, 9, 100, 100, 100, 4, 100},
                {100, 100, 8, 100, 100, 5, 4},
                {100, 100, 100, 4, 5, 100, 6},
                {2, 3, 100, 100, 4, 6, 100}};
        Graph graph = new Graph(vertex,matrix);
        graph.print();
        System.out.println(Arrays.toString(vertex));
        graph.dijkstra(0);
    }
}
