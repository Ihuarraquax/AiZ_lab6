package aiz.graph;

/**
 * Klasa abstrakcyjna reprezentuj¹ca graf za pomoca macierzy sasiedztwa
 */
public abstract class MGraph {

    private int N; // liczba wierzcholkow
    private boolean[][] tab; //macierz sasiedztwa

    /**
     * Zwraca liczbe wierzcholkow w grafie.
     *
     * @return liczba wierzcholkow
     */
    public int getVertexCount() {
        return N;
    }

    public MGraph(int k) {
        tab = new boolean[k][k];
        N = k;
    }

    /**
     * Tworzy krawedz pomiedzy wierzcholkiem i oraz j.
     *
     * @param i wierzcholek zrodlowy
     * @param j wierzcholek docelowy
     */
    public void addEdge(int i, int j){
        tab[i][j] = true;
    }

    /**
     * Zwraca liczbe krawedzi w grafie.
     *
     * @return liczba krawedzi
     */
    public abstract int getEdgeCount();

    /**
     * Wypisuje macierz sasiedztwa grafu.
     */
    public abstract void writeMatrix();

    /**
     * Sprawdza, czy istnieje krawedz pomiedzy wierzcholkiem i oraz j.
     *
     * @param i wierzcholek zrodlowy
     * @param j wierzcholek docelowy
     * @return true jesli istnieje krawedz (i,j)
     */
    public boolean isEdge(int i, int j){
        return tab[i][j];
    }

}
