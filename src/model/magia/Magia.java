package model.magia;

import model.TipoMagia;

public abstract class Magia {
    protected TipoMagia tipo;
    protected String nome;
    
    public Magia(TipoMagia tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public TipoMagia getTipo() {
        return tipo;
    }
    public void setTipo(TipoMagia tipo) {
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
