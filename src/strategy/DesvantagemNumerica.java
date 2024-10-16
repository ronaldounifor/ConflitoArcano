package strategy;

import model.Personagem;

public class DesvantagemNumerica extends Strategy {

    public DesvantagemNumerica(Personagem personagem) {
        super(personagem);
    }

    @Override
    public int modificarAtaque() {
        int resultado = personagem.getAtaque() / 2;

        System.out.println("Estratégia DesvantagemNumerica: " + personagem.getAtaque() + " --> " + resultado);
        
        return resultado;
    }
    
}