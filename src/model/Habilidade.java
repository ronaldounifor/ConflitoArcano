package model;

public class Habilidade {
    private TipoMagia tipo;
    private int dano;
    private String nome;
    
    public Habilidade(TipoMagia tipo, int dano, String nome) {
        this.tipo = tipo;
        this.dano = dano;
        this.nome = nome;
    }

    public TipoMagia getTipo() {
        return tipo;
    }
    public void setTipo(TipoMagia tipo) {
        this.tipo = tipo;
    }
    public int getDano() {
        return dano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
