package model.nivel;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import model.Personagem;

public abstract class Nivel {
    protected ArrayList<Personagem> inimigos;
    protected ArrayList<String> eventos;
    
    public void gerar() {
        inimigos = new ArrayList<>();
        eventos = new ArrayList<>();

        criarInimigos();
        criarEventos();
    }

    protected abstract void criarInimigos();

    protected abstract void criarEventos();

    public ArrayList<Personagem> getInimigos() {
        return inimigos;
    }

    public ArrayList<String> getEventos() {
        return eventos;
    }

    public Personagem fornecerInimigo() throws NoSuchElementException {
        return inimigos.removeFirst();
    }

}
