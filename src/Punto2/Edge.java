package Punto2;

import java.util.Comparator;

public class Edge {
    Object inicio, fin;
    int peso;

    public void setEdge(Object inicio, Object fin, int peso){
        this.peso = peso;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "inicio=" + inicio +
                ", fin=" + fin +
                ", peso=" + peso +
                '}';
    }
    // Comparator function used for
    // sorting edgesbased on their weight

}
