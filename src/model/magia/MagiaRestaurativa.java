package model.magia;

import model.Personagem;
import model.TipoMagia;
import util.Dado;

public class MagiaRestaurativa extends Magia {
    private int cura;

    public MagiaRestaurativa(TipoMagia tipo, String nome, int cura) {
        super(tipo, nome);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    @Override
    public void aplicarEfeito(Personagem atual, Personagem alvo) {
        int resultadoDado = Dado.lancarDado(6);
        int cura = this.cura * resultadoDado;

        atual.curar(cura);
        
        System.out.println(atual.getNome()+" lançou \""+this.nome+"\" e curou : "+cura+" de vida");   
    }
    
}
