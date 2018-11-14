/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiz.graph;

import java.util.*;

/**
 * @author Admin
 */
public class BFSGraph3 extends TGraph {

    public BFSGraph3(int k) {
        super(k);
    }

    public void bfs(int sourceVertex, int destinationVertex) {
        Queue<Integer> kolekcja = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] odleglosci = new int[super.getVertexCount()];
        int[] poprzednik = new int[super.getVertexCount()];

        for (int i = 0; i < odleglosci.length; i++) {
            odleglosci[i] = 404;
            poprzednik[i] = 404;
        }

        odleglosci[sourceVertex] = 0;

        kolekcja.add(sourceVertex);

        bfs(kolekcja, visited, odleglosci, destinationVertex, poprzednik);

        if (odleglosci[destinationVertex] != 404) {
            Deque<Integer> stos = new ArrayDeque<>();
            stos.add(destinationVertex);
            System.out.print("Trasa ("+odleglosci[destinationVertex]+" kroków) : ");

            while (stos.peek() != sourceVertex && poprzednik[stos.peek()] != 404) {
                stos.push(poprzednik[destinationVertex]);
                destinationVertex = poprzednik[destinationVertex];
            }

            while (!stos.isEmpty()) {
                System.out.print(stos.pop() + " ");
            }
        } else {
            System.out.println("Nie ma trasy.");
        }

    }

    private void bfs(Queue<Integer> kolekcja, HashSet<Integer> visited, int[] odleglosci, int destinationVertex, int[] poprzednik) {
        if (!kolekcja.isEmpty()) {
            int source = kolekcja.remove();
            visited.add(source);

            //System.out.println("Przeszukuję węzeł " + source);
            for (int i = 0; i < super.getVertexCount(); i++) {
                if (super.isEdge(source, i) && !visited.contains(i) && !kolekcja.contains(i)) {
                    kolekcja.add(i);
                    odleglosci[i] = odleglosci[source] + 1;
                    poprzednik[i] = source;
                    if (super.isEdge(source, destinationVertex)) {
                        kolekcja.clear();
                    }
                }
            }


            bfs(kolekcja, visited, odleglosci, destinationVertex, poprzednik);

        }
    }

}
