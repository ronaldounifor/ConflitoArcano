package controller;

import java.util.Map;

import data.GameDatabase;
import model.Personagem;
import model.item.Anel;
import model.item.Brinco;
import model.item.Chapeu;
import model.magia.Magia;

public class Conflito {
    private GameDatabase entityManager;

    private int numeroInimigos;

    private Personagem heroi;
    private Personagem vilao;

    public Conflito(int dificuldade) {
        entityManager = new GameDatabase();

        this.numeroInimigos = dificuldade;
    }

    public boolean turnoHeroi(Magia magia) {
        magia.aplicarEfeito(heroi, vilao);

        imprimirResultado();
        
        boolean vilaoVivo = vilao.getVida() > 0;

        if(!vilaoVivo) {
            //TODO registrar duelo
            // entityManager.insertDuelResult(0, 0, 0, vilaoVivo);
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
        return entityManager.getAllCharacterNames();
    }

    public void selecionarHeroi(int nextInt) {
        heroi = entityManager.findPersonagemByID(nextInt);
    }
}