/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiz.graph;

/**
 *
 * @author Admin
 */
public class TGraph extends MGraph {



    public TGraph(int k) {
        super(k);

    }

    @Override
    public int getEdgeCount() {
        int licznik = 0;
        for (int i = 0; i < super.getVertexCount(); i++) {
            for (int j = 0; j < super.getVertexCount(); j++) {
                if(super.isEdge(i, j)) licznik++;
                
            }
            
        }
        return licznik;
    }

    @Override
    public void writeMatrix() {
        for (int i = 0; i < super.getVertexCount(); i++) {
            for (int j = 0; j < super.getVertexCount(); j++) {
                if(super.isEdge(i, j)) System.out.print("1 ");
                else System.out.print("- ");
            }
            System.out.println();
            
        }
    }

    
}
