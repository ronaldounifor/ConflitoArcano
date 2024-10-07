package controller;

import java.util.Map;

import data.adapter.DBAdapter;
import data.adapter.GameDataBaseAdapter;
import data.adapter.GerenteBDAdapter;
import model.Personagem;
import model.magia.Magia;

public class Conflito {
    private DBAdapter entityManager;

    private int numeroInimigos;

    private Personagem heroi;
    private Personagem vilao;

    public Conflito(int dificuldade) {
        entityManager = new GameDataBaseAdapter();

        this.numeroInimigos = dificuldade;

        this.vilao = new Personagem("Mago Goblin", 35);
    }

    public boolean turnoHeroi(Magia magia) {
        magia.aplicarEfeito(heroi, vilao);

        imprimirResultado();
        
        boolean vilaoVivo = vilao.getVida() > 0;

        if(!vilaoVivo) {
            //TODO registrar duelo
            // entityManager.insertDuelResult(0, 0, 0, vilaoVivo);

            if(numeroInimigos > 0) {
                numeroInimigos--;

                this.vilao = new Personagem("Mago Goblin", 35);
                vilaoVivo = true;
            }
        }

        return vilaoVivo;
    }

    public boolean turnoVilao(Magia magia) {
        magia.aplicarEfeito(vilao, heroi);

        imprimirResultado();

        return heroi.getVida() > 0;
    }

    private void imprimirResultado() {
        System.out.println();
        System.out.println("#########################################");
        System.out.println(heroi.getNome()+"("+(heroi.getVida()>0?heroi.getVida():0)+" de vida), "
                        + vilao.getNome()+"("+(vilao.getVida()>0?vilao.getVida():0)+" de vida)");
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