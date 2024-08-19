package util;
import model.Magia;
import model.TipoMagia;

/**
 * @author GPT
 */
public class Grimorio {
    // Array que contém todas as habilidades
    public static final Magia[] MAGIAS;

    static {
        // Inicializa o array com o tamanho adequado
        MAGIAS = new Magia[]{
            new Magia(TipoMagia.FOGO, 10, "Luz Branca"),
            new Magia(TipoMagia.FOGO, 8, "Chama Dourada"),
            new Magia(TipoMagia.AR, 9, "Vento Tornado"),
            new Magia(TipoMagia.TERRA, 9, "Terremoto"),
            new Magia(TipoMagia.LUZ, 6, "Explosão de Luz"),
            new Magia(TipoMagia.TREVAS, 10, "Escudo das Trevas")
            
            // new Magia(TipoMagia.FOGO, 7, "Conflagração"),
            // new Magia(TipoMagia.AGUA, 6, "Chuva Intensa"),
            // new Magia(TipoMagia.AR, 8, "Barreira de Ar"),
            // new Magia(TipoMagia.TERRA, 7, "Mudança de Terra"),
            // new Magia(TipoMagia.LUZ, 12, "Luz Criativa"),
            // new Magia(TipoMagia.TREVAS, 11, "Anseio das Trevas"),
            
            // new Magia(TipoMagia.FOGO, 8, "Chamas Congelante"),
            // new Magia(TipoMagia.AGUA, 8, "Oceano Profundo"),
            // new Magia(TipoMagia.AR, 7, "Vortex de Ar"),
            // new Magia(TipoMagia.TERRA, 9, "Desastre Terrestre")
        };
    }

    // Retorna o array de habilidades
    public static Magia[] getMagias() {
        return MAGIAS;
    }
}
