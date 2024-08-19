package model;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String titulo;
    private List<Magia> habilidades;

    public Classe(String titulo) {
        this.titulo = titulo;
        this.habilidades = new ArrayList<>();
    }

    public List<Magia> getHabilidades() {
        return habilidades;
    }

    public void addHabilidade(Magia habilidade) {
        this.habilidades.add(habilidade);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
