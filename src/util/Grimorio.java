package util;
import model.TipoMagia;
import model.magia.Magia;
import model.magia.MagiaOfensiva;
import model.magia.MagiaRestaurativa;

/**
 * @author GPT
 */
public class Grimorio {
    // Array que contém todas as habilidades
    public static final Magia[] MAGIAS;

    //TODO Colocar magia de gelo
    static {
        // Inicializa o array com o tamanho adequado
        MAGIAS = new Magia[]{
            new MagiaRestaurativa(TipoMagia.LUZ, "Luz Branca", 2),
            new MagiaOfensiva(TipoMagia.FOGO, "Chama Dourada", 8),
            new MagiaOfensiva(TipoMagia.AR, "Vento Tornado", 9),
            new MagiaOfensiva(TipoMagia.TERRA, "Terremoto", 9),
            new MagiaOfensiva(TipoMagia.LUZ, "Explosão de Luz", 6),
            new MagiaRestaurativa(TipoMagia.AGUA, "Água Sagrada", 4)

            //TODO Essa vai pra defesa
            // new MagiaOfensiva(TipoMagia.TREVAS, "Escudo das Trevas", 10) 
            // new Magia(TipoMagia.AR, 8, "Barreira de Ar"),
            
            // new Magia(TipoMagia.FOGO, 7, "Conflagração"),
            // new Magia(TipoMagia.AGUA, 6, "Chuva Intensa"),
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
