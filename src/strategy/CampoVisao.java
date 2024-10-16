package strategy;

import model.Personagem;

public class CampoVisao extends Strategy {
    private int campo;

    /**
     * @param campo - sem visão (0) até visão completa (100)
     */
    public CampoVisao(Personagem personagem, int campo) {
        super(personagem);

        this.campo = campo;
    }

    @Override
    public int modificarAtaque() {
        int resultado = personagem.getAtaque() * (campo/100);

        System.out.println("Estratégia CampoVisao("+campo+"): " + personagem.getAtaque() + " --> " + resultado);
        
        return resultado;
    }

}