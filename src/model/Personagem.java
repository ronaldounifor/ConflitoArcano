package model;

import java.util.ArrayList;
import java.util.List;

import model.item.Equipamento;

public class Personagem {
    public static final int VIDA_MAX = 80;
    private String nome;
    private int vida;
    private List<Equipamento> equipamentos;
    
    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.equipamentos = new ArrayList<>();
        this.vida = vida;
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
