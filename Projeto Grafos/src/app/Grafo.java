package app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private boolean eDirecionado;

    public Grafo() {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
    }

    public Grafo(boolean eDirecionado) {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
        this.eDirecionado = eDirecionado;

    }

    public void adicionarVertice(Vertice vertice) {
        if (vertice == null) System.out.println("Vértice nulo não pode ser adicionado!");
        else if (vertices.contains(vertice)) System.out.println("Vértice " + vertice.getNome() + " já existe!");
        else if (vertice.getNome().isEmpty()) System.out.println("Vértice sem nome não pode ser adicionado!");
        else {
            vertices.add(vertice);
            System.out.println("Vértice " + vertice.getNome() + " adicionado com sucesso!");
        }
    }

    public void adicionarAresta(Aresta aresta) {
        if (aresta == null) System.out.println("Aresta " + aresta.getNome() + " é nula não pode ser adicionada!");
        else if (arestas.contains(aresta)) System.out.println("Aresta " + aresta.getNome() + " já existe!");
        else if (aresta.getNome().isEmpty()) System.out.println("Aresta sem nome não pode ser adicionada!");
        else if (!vertices.contains(aresta.getOrigem()) || !vertices.contains(aresta.getDestino()))
            System.out.println("Vértice de origem ou destino da aresta" + aresta.getNome() + " não existe!");
        else {
            if (!this.eDirecionado)
                descobreSeEDigrafo(aresta);

            arestas.add(aresta);
            System.out.println("Aresta " + aresta.getNome() + " adicionada com sucesso!");
        }

    }

    private void descobreSeEDigrafo(Aresta aresta){
        if(aresta.getOrigem() == aresta.getDestino())
            this.eDirecionado= true;
        else{
            for(Aresta arestaSalvo : arestas){
                if(aresta.getOrigem() == arestaSalvo.getDestino()
                        && aresta.getDestino() == arestaSalvo.getOrigem()) {
                    this.eDirecionado = true;
                    break;
                }

            }
        }

    }

    public void verificaAdjacencias() {
        for (Aresta aresta : arestas) {
            Vertice origem = aresta.getOrigem();
            Vertice destino = aresta.getDestino();

            if (this.eDirecionado) {

                origem.getAdjacencias().add(destino);
            } else {

                origem.getAdjacencias().add(destino);
                destino.getAdjacencias().add(origem);
            }
        }
    }




    public boolean verificaAdjacencias(Vertice v1, Vertice v2) {
        for (Aresta aresta : arestas) {
            if ((aresta.getOrigem().equals(v1) && aresta.getDestino().equals(v2))
                    || (aresta.getOrigem().equals(v2) && aresta.getDestino().equals(v1))) {
                return true;
            }
        }
        return false;
    }

    public void atualizarMatrizAdjacencia() {
        int numVertices = vertices.size();
        int[][] matrizAdjacencia = new int[numVertices][numVertices];


        System.out.print("  ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices.get(i).getNome() + " ");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices.get(i).getNome() + " ");
            for (int j = 0; j < numVertices; j++) {
                if (this.eDirecionado) {

                    if (vertices.get(i).getAdjacencias().contains(vertices.get(j))) {
                        matrizAdjacencia[i][j] = 1;
                    } else {
                        matrizAdjacencia[i][j] = 0;
                    }
                } else {

                    if (vertices.get(i).getAdjacencias().contains(vertices.get(j)) ||
                            vertices.get(j).getAdjacencias().contains(vertices.get(i))) {
                        matrizAdjacencia[i][j] = 1;
                    } else {
                        matrizAdjacencia[i][j] = 0;
                    }
                }
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }




    public void atualizarMatrizIncidencia() {
        int numVertices = vertices.size();
        int numArestas = arestas.size();
        int[][] matrizIncidencia = new int[numVertices][numArestas];


        System.out.print("   ");
        for (int j = 0; j < numArestas; j++) {
            System.out.print(arestas.get(j).getNome() + " ");
        }
        System.out.println();

        if(this.eDirecionado) {
            for (int i = 0; i < numVertices; i++) {
                System.out.print(vertices.get(i).getNome() + "  ");
                for (int j = 0; j < numArestas; j++) {
                    Vertice vertice = vertices.get(i);
                    Aresta aresta = arestas.get(j);

                    if (vertice.equals(aresta.getOrigem())) {
                        matrizIncidencia[i][j] = -1;
                    } else if (vertice.equals(aresta.getDestino())) {
                        matrizIncidencia[i][j] = 1;
                    } else {
                        matrizIncidencia[i][j] = 0;
                    }
                    System.out.print(matrizIncidencia[i][j] + "  ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < numVertices; i++) {
                System.out.print(vertices.get(i).getNome() + "  ");
                for (int j = 0; j < numArestas; j++) {
                    Vertice vertice = vertices.get(i);
                    Aresta aresta = arestas.get(j);

                   
                    if (vertice.equals(aresta.getOrigem()) || vertice.equals(aresta.getDestino())) {
                        matrizIncidencia[i][j] = 1;
                    } else {
                        matrizIncidencia[i][j] = 0;
                    }
                    System.out.print(matrizIncidencia[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }




}




