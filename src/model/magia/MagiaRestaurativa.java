package model.magia;

import model.TipoMagia;

public class MagiaRestaurativa extends Magia {
    private int cura;

    public MagiaRestaurativa(TipoMagia tipo, String nome, int cura) {
        super(tipo, nome);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }
    
}
