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
public class BFSGraph2 extends TGraph implements IBfsSearchable {

    public BFSGraph2(int k) {
        super(k);
    }

    @Override
    public void bfs(int sourceVertex) {
        Queue<Integer> kolekcja = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] odleglosci = new int[super.getVertexCount()];
        for (int i = 0; i < odleglosci.length; i++) {
            odleglosci[i]= 404;
            
        }
        odleglosci[sourceVertex] = 0; 
        
        kolekcja.add(sourceVertex);
        
        bfs(kolekcja, visited,odleglosci);
        System.out.println("Odległość od "+sourceVertex+":");
        for(int i=0; i<odleglosci.length;i++){
            System.out.println("do "+i+ ": "+odleglosci[i]);
        }
    }

    private void bfs(Queue<Integer> kolekcja, HashSet<Integer> visited, int[] odleglosci) {
        if(!kolekcja.isEmpty()){
            int source = kolekcja.remove();
            visited.add(source);
            System.out.println("Przeszukuję węzeł "+source);
            for (int i = 0; i < super.getVertexCount(); i++) {
                if(super.isEdge(source, i)&&!visited.contains(i)&&!kolekcja.contains(i)){
                    kolekcja.add(i);
                    odleglosci[i] = odleglosci[source] + 1;
                }
            }
            
            bfs(kolekcja,visited,odleglosci);
            
        }
    }
    
}
