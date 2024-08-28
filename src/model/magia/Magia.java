package model.magia;

import model.Personagem;
import model.TipoMagia;

public abstract class Magia {
    protected TipoMagia tipo;
    protected String nome;
    
    public Magia(TipoMagia tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public abstract void aplicarEfeito(Personagem atual, Personagem alvo);

    public void imprimirDetalhes() {
        System.out.println();
        System.out.println("#########################################");
        System.out.println("Detalhes da magia");
        System.out.println("Nome: "+nome);
        System.out.println("Tipo: "+tipo);
        System.out.println("#########################################");
        System.out.println();
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
