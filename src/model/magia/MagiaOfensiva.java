package model.magia;

import model.Personagem;
import model.TipoMagia;
import util.Dado;

public class MagiaOfensiva extends Magia {
    private int dano;

    public MagiaOfensiva(TipoMagia tipo, String nome, int dano) {
        super(tipo, nome);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }

    @Override
    public void aplicarEfeito(Personagem atual, Personagem alvo) {
        int ataque = atual.getAtaqueFinal();
        int valorArmadura = alvo.getValorDefesa();
        int dano = this.dano * ataque - valorArmadura;

        if(dano > 0) {
            alvo.levarDano(dano);
            System.out.println(atual.getNome()+" lançou \""+this.nome+"\" e causou : "+dano+" de dano "+this.tipo);   
        } else
            System.out.println("DANO BAIXO!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
