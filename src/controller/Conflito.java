package controller;

import model.Personagem;
import model.item.Anel;
import model.item.Brinco;
import model.item.Chapeu;
import model.magia.Magia;

public class Conflito {
    private Personagem heroi;
    private Personagem vilao;

    public Conflito(String nomeHeroi, String nomeVilao) {
        this.heroi = new Personagem(nomeHeroi);
        this.heroi.equipar(new Anel());
        this.vilao = new Personagem(nomeVilao);
        this.vilao.equipar(new Chapeu());
        this.vilao.equipar(new Brinco());
    }

    public boolean turnoHeroi(Magia magia) {
        magia.aplicarEfeito(heroi, vilao);

        imprimirResultado();

        return vilao.getVida() > 0;
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
}
