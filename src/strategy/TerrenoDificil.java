package strategy;

import model.Personagem;

public class TerrenoDificil  extends Strategy {

    public TerrenoDificil(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int modificarAtaque() {
        int resultado = personagem.getAtaque() - 20;

        System.out.println("Estratégia TerrenoDificil: " + personagem.getAtaque() + " --> " + resultado);
        
        return resultado;
    }
    
}