package model.nivel;

import model.Personagem;
import util.Dado;

public class NivelFacil extends Nivel {

    @Override
    protected void criarInimigos() {
        int numeroGoblins = Dado.getInstancia().lancarDado(3);

        while (--numeroGoblins >= 0)
            inimigos.add(new Personagem("Goblin Mago", 25));
    }

    @Override
    protected void criarEventos() {
        if(Dado.getInstancia().lancarDado(2) % 2 == 0)
            eventos.add("Você não achou nada!");
        else
            eventos.add("Você achou um scroll da cura");
    }
    
}
