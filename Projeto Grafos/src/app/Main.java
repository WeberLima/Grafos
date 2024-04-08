package app;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        Vertice v1 = new Vertice ("1");
        g.adicionarVertice(v1);
        Vertice v2 = new Vertice ("2");
        g.adicionarVertice(v2);
        Vertice v3= new Vertice ("3");
        g.adicionarVertice(v3);
        Vertice v4= new Vertice ("4");
        g.adicionarVertice(v4);




        Aresta a1 = new Aresta("a1", v1, v2);
        g.adicionarAresta(a1);
        Aresta a2 = new Aresta ("a2", v1, v3);
        g.adicionarAresta(a2);
        Aresta a3 = new Aresta("a3", v2, v3);
        g.adicionarAresta(a3);
        Aresta a4= new Aresta("a4", v3, v4);
        g.adicionarAresta(a4);






        System.out.println(g);

        g.verificaAdjacencias();
        System.out.println("MATRIZ ADJACENCIA");// Certifica-se de que as adjacências estão corretamente preenchidas
        g.atualizarMatrizAdjacencia();

        System.out.println("MATRIZ INCIDENCIA");
        g.atualizarMatrizIncidencia();// Atualiza a matriz de adjacência



    }
}