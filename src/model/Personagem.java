package model;

import java.util.ArrayList;
import java.util.List;

import model.item.Equipamento;
import strategy.CampoVisao;
import strategy.Combo;
import strategy.DesvantagemNumerica;
import strategy.Strategy;
import strategy.TerrenoAlto;
import strategy.TerrenoDificil;
import util.Dado;

public class Personagem {
    public static final int VIDA_MAX = 80;
    private String nome;
    private int vida;
    private int ataque;
    private Strategy estrategia;
    private List<Equipamento> equipamentos;
    
    public Personagem(String nome, int vida, int ataque) {
        this.nome = nome;
        this.equipamentos = new ArrayList<>();
        this.vida = vida;
        this.ataque = ataque;
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

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueFinal() {
        int estrategiaUsada = Dado.getInstancia().lancarDado(5);

        switch (estrategiaUsada) {
            case 1: estrategia = new Combo(this); break;
            case 2: estrategia = new CampoVisao(this, Dado.getInstancia().lancarDado(100)); break;
            case 3: estrategia = new DesvantagemNumerica(this); break;
            case 4: estrategia = new TerrenoAlto(this); break;
            case 5: estrategia = new TerrenoDificil(this); break;
        
            default: break;
        }

        return estrategia.modificarAtaque();
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public Strategy getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Strategy estrategia) {
        this.estrategia = estrategia;
    }
}
