package kruskal;

//边的信息
public class Edge implements Comparable<Edge>{
    char start;
    char end;
    int weight;

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{(" + start + "," + end + ")=" + weight + '}';
    }


    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
