package model.magia;

import model.TipoMagia;

public class MagiaOfensiva extends Magia {
    private int dano;

    public MagiaOfensiva(TipoMagia tipo, String nome, int dano) {
        super(tipo, nome);
        this.dano = dano;
    }

    public int getDano() {
        return dano;
    }
}
