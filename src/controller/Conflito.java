package controller;

import java.util.Scanner;

import model.Classe;
import model.Personagem;
import model.item.Anel;
import model.item.Brinco;
import model.item.Chapeu;
import model.magia.Magia;
import util.Grimorio;

public class Conflito {
    private static Scanner scanner = new Scanner(System.in);
    private Personagem heroi;
    private Personagem vilao;

    public Conflito(String nomeHeroi, String nomeVilao) {
        this.heroi = new Personagem(nomeHeroi, new Classe("Herói"));
        this.heroi.equipar(new Anel());
        this.vilao = new Personagem(nomeVilao, new Classe("Vilão"));
        this.vilao.equipar(new Chapeu());
        this.vilao.equipar(new Brinco());

        iniciar();
    }

    private void iniciar() {
        
        while(heroi.getVida() > 0 && vilao.getVida() > 0) {
            iniciarTurno(heroi, vilao);

            if(vilao.getVida() > 0)
                iniciarTurno(vilao, heroi);
        }
    }

    private void iniciarTurno(Personagem atual, Personagem alvo) {
        escolherMagia(atual).aplicarEfeito(atual, alvo);
     
        imprimirLuta();
    }
    
    private Magia escolherMagia(Personagem atual) {
        System.out.println("Escolha a magia que o " + atual.getNome() + " irá usar:");
        int i = 0;
        for (Magia habilidade : Grimorio.MAGIAS)
            System.out.println("["+(i++)+"]. "+habilidade.getNome());

        return Grimorio.MAGIAS[scanner.nextInt()];
    }

    private void imprimirLuta() {
        System.out.println();
        System.out.println("#########################################");
        System.out.println(heroi.getNome()+"("+(heroi.getVida()>0?heroi.getVida():0)+" de vida), "
                        + vilao.getNome()+"("+(vilao.getVida()>0?vilao.getVida():0)+" de vida)");
        System.out.println("#########################################");
        System.out.println();
    }
}
