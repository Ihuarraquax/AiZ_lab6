/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiz.graph;

import jdk.nashorn.internal.objects.NativeArray;

import java.util.*;

/**
 * @author Admin
 */
public class BFSGraphWithTracking extends TGraph {

    public BFSGraphWithTracking(int k) {
        super(k);
    }


    public void bfs(int sourceVertex, int destinationVertex) {
        Queue<Integer> kolekcja = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] odleglosci = new int[super.getVertexCount()];
        int[] poprzedni = new int[super.getVertexCount()];

        wypełnijDomyslneWartosci(sourceVertex, odleglosci, poprzedni);

        kolekcja.add(sourceVertex);

        while (!kolekcja.isEmpty()) {

            int source = kolekcja.remove();
            visited.add(source);
            System.out.println("Przeszukuję węzeł " + source);
            for (int i = 0; i < super.getVertexCount(); i++) {
                if (super.isEdge(source, i) && !visited.contains(i) && !kolekcja.contains(i)) {
                    kolekcja.add(i);
                    odleglosci[i] = odleglosci[source] + 1;
                    poprzedni[i] = source;
                }

            }
            if (super.isEdge(source, destinationVertex)) {
                kolekcja.clear();
            }

        }

        wypiszOdleglosci(sourceVertex, odleglosci);
        wypiszTrase(sourceVertex, destinationVertex, odleglosci[destinationVertex], poprzedni);

    }

    private void wypełnijDomyslneWartosci(int sourceVertex, int[] odleglosci, int[] poprzedni) {
        for (int i = 0; i < odleglosci.length; i++) {
            odleglosci[i] = 404;
            poprzedni[i] = 404;
        }
        odleglosci[sourceVertex] = 0;
        poprzedni[sourceVertex] = 404;
    }

    private void wypiszTrase(int sourceVertex, int destinationVertex, int i, int[] poprzedni) {
        if (i != 404) {
            Deque<Integer> stos = new ArrayDeque<>();
            stos.add(destinationVertex);
            System.out.print("Trasa ("+ i +" kroków) : ");

            while (stos.peek() != sourceVertex && poprzedni[stos.peek()] != 404) {
                stos.push(poprzedni[destinationVertex]);
                destinationVertex = poprzedni[destinationVertex];
            }

            while (!stos.isEmpty()) {
                System.out.print(stos.pop() + " ");
            }
        } else {
            System.out.println("Nie ma trasy.");
        }
    }

    private void wypiszOdleglosci(int sourceVertex, int[] odleglosci) {
        System.out.println("Odległość od " + sourceVertex + ":");
        for (int i = 0; i < odleglosci.length; i++) {
            System.out.println("do " + i + ": " + odleglosci[i]);
        }
    }

}
