package model;

import java.util.ArrayList;
import java.util.List;

import model.item.Equipamento;

public class Personagem {
    public static final int VIDA_MAX = 80;
    private String nome;
    private Classe classe;
    private int nivel;
    private int vida;
    private List<Equipamento> equipamentos;
    //private Raca raca;
    //private genero
    //private atributos / pontos

    
    public Personagem(String nome, Classe classe) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = 1;
        this.equipamentos = new ArrayList<>();
        this.vida = VIDA_MAX;
    }
    
    public int getVida() {
        return vida;
    }

    public void levarDano(int dano) {
        this.vida -= dano;
    }

    public void curar(int cura) {
        if(vida + cura > VIDA_MAX)
            this.vida = VIDA_MAX;
        else
            this.vida = vida + cura;
    }

    public String getNome() {
        return nome;
    }
    
    public Classe getClasse() {
        return classe;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        this.nivel++;
    }

    public int getValorDefesa() {
        int defesaTotal = 0;
        for (Equipamento equipamento : equipamentos)
            defesaTotal += equipamento.getDefesa();
        
        return defesaTotal;
    }

    public void equipar(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
    }
}
