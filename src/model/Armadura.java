package model;

public class Armadura {
    private int defesa;

    public Armadura() {
        this.defesa = 1;
    }

    public Armadura(int defesa) {
        this.defesa = defesa;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
