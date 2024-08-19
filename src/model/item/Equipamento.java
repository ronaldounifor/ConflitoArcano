package model.item;

public abstract class Equipamento {
    protected int defesa;

    public Equipamento() {
        this.defesa = 10;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
