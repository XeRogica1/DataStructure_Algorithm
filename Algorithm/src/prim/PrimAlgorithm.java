package prim;

public class PrimAlgorithm {
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
    修路保证ABCDEFG连通，且总路程最小
    从A开始    从F开始
    A-G 2       F-D 4
    G-B 3       F-E 5
    G-E 4       E-G 4
    E-F 5       G-A 2
    F-D 4       G-B 3
    A-C 7       A-C 7
*/

        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertexNum = data.length;
        int[][] weight = {
                {100, 5, 7, 100, 100, 100, 2},
                {5, 100, 100, 9, 100, 100, 3},
                {7, 100, 100, 100, 8, 100, 100},
                {100, 9, 100, 100, 100, 4, 100},
                {100, 100, 8, 100, 100, 5, 4},
                {100, 100, 100, 4, 5, 100, 6},
                {2, 3, 100, 100, 4, 6, 100}};
        PGraph graph = new PGraph(vertexNum);
        MiniTree miniTree = new MiniTree();
        miniTree.createGraph(graph, vertexNum, data, weight);
        miniTree.showGraph(graph);
        miniTree.prim(graph, 5);
    }
}
