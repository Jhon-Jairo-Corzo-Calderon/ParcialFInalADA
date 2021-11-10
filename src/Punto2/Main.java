package Punto2;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        int V = 7;
        int E = 10;
        Graph graph = new Graph(V, E);
        Main mn = new Main();

        graph.edges[0].setEdge("1", "3", 1);
        graph.edges[1].setEdge("1", "2", 3);
        graph.edges[2].setEdge("2", "3", 8);
        graph.edges[3].setEdge("2", "4", 7);
        graph.edges[4].setEdge("2", "5", 5);
        graph.edges[5].setEdge("4", "5", 6);
        graph.edges[6].setEdge("4", "7", 9);
        graph.edges[7].setEdge("7", "5", 2);
        graph.edges[8].setEdge("5", "6", 1);
        graph.edges[9].setEdge("7", "6", 4);
        Hashtable<String, Integer> conversion = new Hashtable<String, Integer>();
        System.out.println("------------------Ejercicio #1------------------");
        Graph transformedG = transformGraph(conversion, V, E, graph);

        //System.out.println(Arrays.toString(transformedG.edges));
        //System.out.println(conversion);
        mn.KruskalMST(transformedG,conversion);

        System.out.println("\n\n------------------Ejercicio #2------------------");
        conversion.clear();

        V = 8; E = 11;
        Graph graph2 = new Graph(8,11);

        graph2.edges[0].setEdge("a", "b", 2);
        graph2.edges[1].setEdge("a", "c", 3);
        graph2.edges[2].setEdge("c", "d", 1);
        graph2.edges[3].setEdge("b", "d", 2);
        graph2.edges[4].setEdge("d", "e", 2);
        graph2.edges[5].setEdge("d", "f", 4);
        graph2.edges[6].setEdge("f", "e", 1);
        graph2.edges[7].setEdge("e", "g", 2);
        graph2.edges[8].setEdge("g", "f", 2);
        graph2.edges[9].setEdge("f", "h", 1);
        graph2.edges[10].setEdge("h", "g", 3);

        transformedG = transformGraph(conversion, 8, 11, graph2);


        mn.KruskalMST(transformedG,conversion);
    }

    static Graph transformGraph(Hashtable<String, Integer> conversion, int verCant, int edCant, Graph graph) {
        int indx = 0;
        for (int i = 0; i < edCant; i++) {
            if (!conversion.containsKey(graph.edges[i].inicio)) {
                conversion.put((String) graph.edges[i].inicio, indx++);
            } else if (!conversion.containsKey(graph.edges[i].fin)) {
                conversion.put((String) graph.edges[i].fin, indx++);
            }
        }

        Graph newGraph = new Graph(verCant, edCant);

        for (int j= 0; j < edCant; j++) {
            newGraph.edges[j].setEdge(conversion.get(graph.edges[j].inicio), conversion.get(graph.edges[j].fin), graph.edges[j].peso);
        }

        return newGraph;
    }

    public Object findValue(int sentinal, Hashtable<String, Integer> hashMap){
        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if((int) entry.getValue() == sentinal){
                return entry.getKey();
            }
        }
        return null;
    }

    class subset {
        int parent, rank;
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent
                    = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
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


    public void KruskalMST(Graph graph, Hashtable<String, Integer> conversion) {

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

        for (int v = 0; v < ver; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < ver - 1) {
            Edge next_edge = edges[i++];

            int x = find(subsets, (int) next_edge.inicio);
            int y = find(subsets, (int) next_edge.fin);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }

        }

        System.out.println("-------Aristas del arbol recubridor mínimo-------");
        int minimumCost = 0;
        for (i = 0; i < e; ++i) {
            System.out.println("Vertices: " + findValue((int) result[i].inicio, conversion)  + " -- "
                    + findValue((int) result[i].fin, conversion)
                    + "| Peso: " + result[i].peso);
            minimumCost += result[i].peso;
        }
        System.out.println("Peso del árbol recubridor mínimo: "
                + minimumCost);

    }


}
