package strategy;

import model.Personagem;

public class TerrenoAlto extends Strategy {

    public TerrenoAlto(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int modificarAtaque() {
        int resultado = personagem.getAtaque() + 20;

        System.out.println("Estratégia TerrenoAlto: " + personagem.getAtaque() + " --> " + resultado);
        
        return resultado;
    }
    
}
