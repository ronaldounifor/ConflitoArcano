package controller;

import java.util.Map;
import java.util.NoSuchElementException;

import data.adapter.DBAdapter;
import data.adapter.GerenteBDAdapter;
import model.Personagem;
import model.magia.Magia;
import model.nivel.Nivel;
import model.nivel.NivelDificil;
import model.nivel.NivelFacil;
import model.nivel.NivelMedio;

public class Conflito {
    private DBAdapter entityManager;

    private Nivel nivel;
    private Personagem heroi;
    private Personagem inimigoAtual;

    public Conflito(int dificuldade) {
        entityManager = new GerenteBDAdapter();

        //FIXME L do SOLID
        if(dificuldade == 1)
            this.nivel = new NivelFacil();
        else if(dificuldade == 2)
            this.nivel = new NivelMedio();
        else
            this.nivel = new NivelDificil();

        this.nivel.gerar();

        try {
            this.inimigoAtual = nivel.fornecerInimigo();
        } catch (NoSuchElementException e) {
            //TODO Transferir turnoHeroi para construtor
            System.out.println("TEste emtreo no catch");
        }
    }

    //TODO registrar duelo no BD
    // entityManager.insertDuelResult(0, 0, 0, vilaoVivo);
    public boolean turnoHeroi(Magia magia) {
        magia.aplicarEfeito(heroi, inimigoAtual);

        imprimirResultado();
        
        boolean vilaoVivo = true;

        if(inimigoAtual.getVida() <= 0) {
            try {
                inimigoAtual = nivel.fornecerInimigo();
            } catch (NoSuchElementException e) {
                vilaoVivo = false;
            }
        }

        return vilaoVivo;
    }

    //FIXME Vilao age por conta propria
    public boolean turnoVilao(Magia magia) {
        magia.aplicarEfeito(inimigoAtual, heroi);

        imprimirResultado();

        return heroi.getVida() > 0;
    }

    private void imprimirResultado() {
        System.out.println();
        System.out.println("#########################################");
        System.out.println(heroi.getNome()+"("+(heroi.getVida()>0?heroi.getVida():0)+" de vida), "
                        + inimigoAtual.getNome()+"("+(inimigoAtual.getVida()>0?inimigoAtual.getVida():0)+" de vida)");
        System.out.println("#########################################");
        System.out.println();
    }

    public Map<Integer, String> iniciar() {
        return entityManager.listarPersonagens();
    }

    public void selecionarHeroi(int id) {
        heroi = entityManager.buscarPersonagemPorID(id);
    }
}