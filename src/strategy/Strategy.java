package strategy;

import model.Personagem;

public abstract class Strategy {
    protected Personagem personagem;

    
    public Strategy(Personagem personagem) {
        this.personagem = personagem;
    }

    public abstract int modificarAtaque();
}
