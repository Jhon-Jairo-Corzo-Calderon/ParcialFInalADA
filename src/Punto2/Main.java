package Punto2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

            int V = 4;
            int E = 5;
            Graph graph = new Graph(V, E);
            Main mn = new Main();

            graph.edges[0].setEdge(0,1,10);
            graph.edges[1].setEdge(0,2,6);
            graph.edges[2].setEdge(0,3, 5);
            graph.edges[3].setEdge(1,3,15);
            graph.edges[4].setEdge(2,3,4);

            Hashtable<Integer, Object> conversion = new Hashtable<Integer, Object>();

            mn.KruskalMST(graph);
    }
    static void transformGraph(Hashtable<Integer, Object> conversion, int verCant, Graph graph){
        for (int i = 0; i < verCant; i++) {
            if(!conversion.containsValue(graph.edges[i].inicio)){
                conversion.put(i,graph.edges[i].inicio);
            }
            else if(!conversion.containsValue(graph.edges[i].inicio)){

            }
        }
    }

    class subset
    {
        int parent, rank;
    }

    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent
                    = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }


    public  void KruskalMST(Graph graph) {

        int ver = graph.vertices;
        Edge[] edges = graph.edges.clone();
        Edge result[] = new Edge[ver];

        int e = 0;

        int i = 0;
        for (i = 0; i < ver; ++i)
            result[i] = new Edge();

        MergeSort.sort(edges, 0, edges.length - 1);

        subset subsets[] = new subset[ver];
        for (i = 0; i < ver; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < ver; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < ver - 1)
        {
            Edge next_edge = edges[i++];

            int x = find(subsets,(int) next_edge.inicio);
            int y = find(subsets,(int) next_edge.fin);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }

        }

        System.out.println("-------Aristas del arbol recubridor mínimo-------");
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(result[i].inicio + " -- "
                    + result[i].fin
                    + " == " + result[i].peso);
            minimumCost += result[i].peso;
        }
        System.out.println("Peso del árbol recubridor mínimo: "
                + minimumCost);

    }


}
