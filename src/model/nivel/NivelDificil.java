package model.nivel;

import model.Personagem;

public class NivelDificil extends Nivel {

    @Override
    protected void criarInimigos() {
        inimigos.add(new Personagem("Minotauro", 225));
    }

    @Override
    protected void criarEventos() {
        // nada
    }
    
}
