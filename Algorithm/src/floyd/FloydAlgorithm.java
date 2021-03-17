package floyd;

public class FloydAlgorithm {
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
*/
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 5, 7, 100, 100, 100, 2},
                {5, 0, 100, 9, 100, 100, 3},
                {7, 100, 0, 100, 8, 100, 100},
                {100, 9, 100, 0, 100, 4, 100},
                {100, 100, 8, 100, 0, 5, 4},
                {100, 100, 100, 4, 5, 0, 6},
                {2, 3, 100, 100, 4, 6, 0}};
        Graph graph = new Graph(vertex,matrix);
        graph.print();
        graph.floyd();
        graph.print();
    }

}
