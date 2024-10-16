package model.nivel;

import model.Personagem;
import util.Dado;

public class NivelMedio extends Nivel {

    @Override
    protected void criarInimigos() {
        int numeroGoblins = 1 + Dado.getInstancia().lancarDado(4);

        while (--numeroGoblins >= 0)
            inimigos.add(new Personagem("Goblin Mago", 25, 5));
    }

    @Override
    protected void criarEventos() {
        // Uma conjuração de cura
    }
    
}
