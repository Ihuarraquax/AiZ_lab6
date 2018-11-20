/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiz.graph;

import java.util.*;

/**
 *
 * @author Admin
 */
public class BFSGraphSearching extends TGraph implements IBfsSearchable {

    public BFSGraphSearching(int k) {
        super(k);
    }

    @Override
    public void bfs(int sourceVertex) {
        Queue<Integer> kolekcja = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        kolekcja.add(sourceVertex);

        bfs(kolekcja, visited);
    }

    private void bfs(Queue<Integer> kolekcja, HashSet<Integer> visited) {
        if(!kolekcja.isEmpty()){
            int source = kolekcja.remove();
            visited.add(source);
            System.out.println("Przeszukuję węzeł "+source);
            for (int i = 0; i < super.getVertexCount(); i++) {
                if(super.isEdge(source, i)&&!visited.contains(i)&&!kolekcja.contains(i)){
                    kolekcja.add(i);
                }
            }
            bfs(kolekcja,visited);
            
        }
    }
    
}
