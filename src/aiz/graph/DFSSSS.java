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
public class DFSSSS extends TGraph {


    ArrayDeque<Integer> kolekcja = new ArrayDeque<>();
    HashSet<Integer> visited = new HashSet<>();
    int[] odleglosci = new int[super.getVertexCount()];
    int[] poprzedni = new int[super.getVertexCount()];
    int[] czasWejsciowy = new int[super.getVertexCount()];
    int[] czasWyjsciowy = new int[super.getVertexCount()];




    public DFSSSS(int k) {
        super(k);
    }


    public void dfs(int sourceVertex) {


        wypełnijDomyslneWartosci(sourceVertex);

        kolekcja.add(sourceVertex);
        int timer = 1;
        while (!kolekcja.isEmpty()) {

            int source = kolekcja.remove();
            if(czasWejsciowy[source]==404) czasWejsciowy[source]= timer++;

            visited.add(source);
            System.out.println("Przeszukuję węzeł " + source);
            boolean hasEdge = false;
            for (int i = 0; i < super.getVertexCount(); i++) {
                if (super.isEdge(source, i) && !visited.contains(i) && !kolekcja.contains(i)) {
                    kolekcja.add(i);
                    odleglosci[i] = odleglosci[source] + 1;
                    poprzedni[i] = source;
                    hasEdge = true;
                    break;
                }

            }
            if(!hasEdge) {
                czasWyjsciowy[source] = timer++;
                if(poprzedni[source]!=404) kolekcja.push(poprzedni[source]); // jesli ma poprzednika, to dodaj go do stosu
            }

        }

        wypiszOdleglosci(sourceVertex);
        //wypiszTrase(sourceVertex, destinationVertex);
        wypiszCzasy(sourceVertex);

    }

    private void wypełnijDomyslneWartosci(int sourceVertex) {
        for (int i = 0; i < odleglosci.length; i++) {
            odleglosci[i] = 404;
            poprzedni[i] = 404;
            czasWejsciowy[i] = 404;
            czasWyjsciowy[i] = 404;
        }
        odleglosci[sourceVertex] = 0;
        poprzedni[sourceVertex] = 404;
    }

    private void wypiszTrase(int sourceVertex, int destinationVertex) {
        if (odleglosci[destinationVertex] != 404) {
            Deque<Integer> stos = new ArrayDeque<>();
            stos.add(destinationVertex);
            System.out.print("Trasa ("+ odleglosci[destinationVertex] +" kroków) : ");

            while (stos.peek() != sourceVertex && poprzedni[stos.peek()] != 404) {
                stos.push(poprzedni[destinationVertex]);
                destinationVertex = poprzedni[destinationVertex];
            }

            while (!stos.isEmpty()) {
                System.out.print(stos.pop() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Nie ma trasy.");
            System.out.println();
        }
    }

    private void wypiszOdleglosci(int sourceVertex) {
        System.out.print("Odległość od " + sourceVertex + " - ");
        for (int i = 0; i < odleglosci.length; i++) {
            System.out.print(i + ":" + odleglosci[i]+"; ");
        }
        System.out.println();
    }
    private void wypiszCzasy(int sourceVertex) {
        System.out.print("Czasy od " + sourceVertex + " - ");
        for (int i = 0; i < czasWejsciowy.length; i++) {
            System.out.print(i + ":" + czasWejsciowy[i]+"/"+czasWyjsciowy[i]+"; ");
        }
        System.out.println();
    }

}

