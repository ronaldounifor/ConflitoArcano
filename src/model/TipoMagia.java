package model;

/**
 * @author GPT
 */
public enum TipoMagia {
    FOGO("Fogo"),
    AGUA("Água"),
    AR("Ar"),
    TERRA("Terra"),
    LUZ("Luz"),
    TREVAS("Trevas");

    private final String descricao;

    TipoMagia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
