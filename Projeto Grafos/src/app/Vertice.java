package app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data


public class Vertice {
    private String nome;
    private List<Vertice> adjacencias;

    public  Vertice(String nome){
        this.nome = nome;
        adjacencias= new ArrayList<>();
    }
}