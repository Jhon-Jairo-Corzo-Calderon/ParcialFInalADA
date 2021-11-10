package Punto2;

public class Graph {
    int vertices;
    int edgesCant;
    Edge[] edges;

    public Graph(int ver, int ed){
        vertices = ver;
        edgesCant = ed;

        edges = new Edge[edgesCant];
        for (int i = 0; i < ed; ++i)
            edges[i] = new Edge();
    }

}
