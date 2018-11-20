/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfs;

import aiz.graph.BFSGraphWithDistance;
import aiz.graph.BFSGraphWithTracking;
import aiz.graph.DFSSSS;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DFSSSS graf = new DFSSSS(8);
        
        graf.addEdge(0, 1);
        graf.addEdge(0, 2);
        graf.addEdge(1, 3);
        graf.addEdge(1, 4);
        graf.addEdge(2, 5);
        graf.addEdge(2, 6);
        graf.addEdge(6, 0);
        graf.addEdge(5, 3);
        graf.addEdge(3, 1);
        graf.addEdge(6, 2);
        graf.addEdge(0, 3);
        graf.addEdge(1, 2);
        graf.addEdge(6, 7);
        
        
        System.out.println(graf.getEdgeCount());
        graf.writeMatrix();

        graf.sSS();
    }
    
}
