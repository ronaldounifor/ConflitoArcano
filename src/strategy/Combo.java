package strategy;

import model.Personagem;
import util.Dado;

public class Combo extends Strategy {

    public Combo(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int modificarAtaque() {
        int resultado = personagem.getAtaque() * Dado.getInstancia().lancarDado(4);

        System.out.println("Estratégia Combo: " + personagem.getAtaque() + " --> " + resultado);
        
        return resultado;
    }
    
}
