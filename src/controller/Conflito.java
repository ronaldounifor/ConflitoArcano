package controller;

import java.util.Scanner;

import model.Classe;
import model.Personagem;
import model.item.Anel;
import model.item.Brinco;
import model.item.Chapeu;
import model.magia.Magia;
import model.magia.MagiaOfensiva;
import model.magia.MagiaRestaurativa;
import util.Dado;
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
        Magia magia = escolherMagia(atual);

        if(magia instanceof MagiaOfensiva)
            aplicarDano((MagiaOfensiva) magia, atual, alvo);
        else if(magia instanceof MagiaRestaurativa)
            aplicarCura((MagiaRestaurativa) magia, atual);

    }

    private void aplicarDano(MagiaOfensiva magia, Personagem atual, Personagem alvo) {
        int resultadoDado = Dado.lancarDado(6);
        int valorArmadura = alvo.getValorDefesa();
        int dano = magia.getDano() * resultadoDado - valorArmadura;

        if(dano > 0) {
            alvo.levarDano(dano);
        
            System.out.println(atual.getNome()+" lançou \""+magia.getNome()+"\" e causou : "+dano+" de dano "+magia.getTipo());   
            imprimirLuta();
        } else {
            System.out.println("DANO BAIXO!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    private void aplicarCura(MagiaRestaurativa magia, Personagem atual) {
        int resultadoDado = Dado.lancarDado(6);
        int cura = magia.getCura() * resultadoDado;

        atual.curar(cura);
        
        System.out.println(atual.getNome()+" lançou \""+magia.getNome()+"\" e curou : "+cura+" de vida");   
        
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
