package model;

public class Personagem {
    private String nome;
    private Classe classe;
    private int nivel;
    private int vida;
    public int getVida() {
        return vida;
    }

    public void levarDano(int dano) {
        this.vida -= dano;
    }

    private Armadura armadura;
    //private Raca raca;
    //private genero
    //private atributos / pontos

    public Personagem(String nome, Classe classe) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = 1;
        this.armadura = new Armadura();
        this.vida = 20000;
    }

    public String getNome() {
        return nome;
    }
    
    public Classe getClasse() {
        return classe;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        this.nivel++;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public void equiparArmadura(Armadura armadura) {
        this.armadura = armadura;
    }
}
