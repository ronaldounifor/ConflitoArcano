package view;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import controller.Conflito;
import util.Grimorio;

public class InterfaceJogo {
      private Scanner scan;
      private Conflito conflito;

      public InterfaceJogo() {
            scan = new Scanner(System.in);

            iniciarJogo();

            vezDoHeroi();

            scan.close();
      }

      
      private void iniciarJogo() {
            System.out.println("Escolha o nível de dificuldade (1 - Facil, 2 - Medio, 3 - Dificil): ");
            int dificuldade = scan.nextInt();

            this.conflito = new Conflito(dificuldade);

            Map<Integer, String> personagens = conflito.iniciar();

            System.out.println("Escolhe o seu personagem: ");
            for (Entry<Integer, String> personagem : personagens.entrySet())
                  System.out.println("["+personagem.getKey()+"]: "+personagem.getValue());
            
            conflito.selecionarHeroi(scan.nextInt());
      }


      private void vezDoHeroi() {
            // Vez do Herói
            System.out.println("Escolha a magia do heroi: ");
            // Selecione sua magia

            for (int i = 0; i < Grimorio.MAGIAS.length; i++)
                  System.out.println("["+i+"]. "+Grimorio.MAGIAS[i].getNome());

            boolean vilaoVivo = conflito.turnoHeroi(Grimorio.MAGIAS[scan.nextInt()]);

            if(vilaoVivo)
                  vezDoVilao();
      }

      private void vezDoVilao() {
            System.out.println("Escolha a magia do vilao: ");

            for (int i = 0; i < Grimorio.MAGIAS.length; i++)
                  System.out.println("["+i+"]. "+Grimorio.MAGIAS[i].getNome());

            boolean heroiVivo = conflito.turnoVilao(Grimorio.MAGIAS[scan.nextInt()]);

            if(heroiVivo)
                  vezDoHeroi();
      }
}
      