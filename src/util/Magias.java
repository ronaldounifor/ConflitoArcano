package util;
import model.Habilidade;
import model.TipoMagia;

/**
 * @author GPT
 */
public class Magias {
    // Array que contém todas as habilidades
    public static final Habilidade[] MAGIAS;

    static {
        // Inicializa o array com o tamanho adequado
        MAGIAS = new Habilidade[]{
            new Habilidade(TipoMagia.FOGO, 100, "Luz Branca"),
            new Habilidade(TipoMagia.FOGO, 85, "Chama Dourada"),
            new Habilidade(TipoMagia.AR, 90, "Vento Tornado"),
            new Habilidade(TipoMagia.TERRA, 95, "Terremoto"),
            new Habilidade(TipoMagia.LUZ, 60, "Explosão de Luz"),
            new Habilidade(TipoMagia.TREVAS, 100, "Escudo das Trevas"),
            
            new Habilidade(TipoMagia.FOGO, 70, "Conflagração"),
            new Habilidade(TipoMagia.AGUA, 65, "Chuva Intensa"),
            new Habilidade(TipoMagia.AR, 80, "Barreira de Ar"),
            new Habilidade(TipoMagia.TERRA, 75, "Mudança de Terra"),
            new Habilidade(TipoMagia.LUZ, 120, "Luz Criativa"),
            new Habilidade(TipoMagia.TREVAS, 110, "Anseio das Trevas"),
            
            new Habilidade(TipoMagia.FOGO, 80, "Chamas Congelante"),
            new Habilidade(TipoMagia.AGUA, 85, "Oceano Profundo"),
            new Habilidade(TipoMagia.AR, 75, "Vortex de Ar"),
            new Habilidade(TipoMagia.TERRA, 90, "Desastre Terrestre")
        };
    }

    // Retorna o array de habilidades
    public static Habilidade[] getMagias() {
        return MAGIAS;
    }
}
