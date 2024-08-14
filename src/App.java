import java.util.Scanner;

import model.Classe;
import model.Habilidade;
import model.Personagem;
import util.Dado;
import util.Magias;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Personagem heroi = new Personagem("Gandalf", new Classe("Arquimago"));
    private static Personagem vilao = new Personagem("Feiticeira Escarlate", new Classe("Feiticeira"));

    public static void main(String[] args) throws Exception {
        while(heroi.getVida() > 0 && vilao.getVida() > 0) {
            lutar(heroi, vilao);
            lutar(vilao, heroi);
        }

        if(heroi.getVida() > 0)
            System.out.println(heroi.getNome()+" venceu!");
        else
            System.out.println(vilao.getNome()+" venceu!");

        scanner.close();
    }

    private static void lutar(Personagem atual, Personagem alvo) {
        System.out.println("Escolha a magia que o " + atual.getNome() + " irá usar:");
        int i = 0;
        for (Habilidade habilidade : Magias.MAGIAS)
            System.out.println("["+(i++)+"]. "+habilidade.getNome());

        Habilidade magia = Magias.MAGIAS[scanner.nextInt()];
        int dano = magia.getDano() * Dado.lancarDado();
        alvo.levarDano(dano);
        
        System.out.println(atual.getNome()+" lançou \""+magia.getNome()+"\" e causou : "+dano+" de dano "+magia.getTipo());   
        imprimirLuta();
    }

    private static void imprimirLuta() {
        System.out.println();
        System.out.println("#########################################");
        System.out.println(heroi.getNome()+"("+heroi.getVida()+" de vida), "
                        + vilao.getNome()+"("+vilao.getVida()+" de vida)");
        System.out.println("#########################################");
    }
}
